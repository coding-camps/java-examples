package lang.annotation.sqlparser;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

public class SqlParser {

    public static String getQuerySql(User user) {
        // 获取到Class
        Class<?> cls = user.getClass();

        // 获取对应的table
        if (!cls.isAnnotationPresent(DbTable.class)) {
            return null;
        }
        String tableName = ((DbTable) cls.getAnnotation(DbTable.class)).value();

        // 准备拼接SQL
        StringBuilder sql = new StringBuilder();
        sql.append("select * from ").append(tableName);

        // 遍历所有的属性
        List<String> sqlSegmentList = new LinkedList<>();
        Field[] fields = cls.getDeclaredFields();
        for (Field field : fields) {
            // 获取该属性对应的DB字段和值
            if (!field.isAnnotationPresent(DbColumn.class)) {
                continue;
            }
            String columnName = field.getAnnotation(DbColumn.class).value();
            Object columnValue = getFieldValue(cls, user, field);
            // 拼装成sql片段
            String sqlStr = paseKVsql(columnName, columnValue);
            if (sqlStr != null) {
                sqlSegmentList.add(sqlStr);
            }
        }
        sql.append(" where");
        for (int i = 0; i < sqlSegmentList.size() - 1; i++) {
            sql.append(sqlSegmentList.get(i)).append(" and ");
        }
        sql.append(sqlSegmentList.get(sqlSegmentList.size() - 1));
        return sql.toString();
    }

    private static String paseKVsql(String columnName, Object columnValue) {
        StringBuilder sqlSegment = new StringBuilder();
        FieldType fieldType = FieldType.check(columnValue);
        switch (fieldType) {
            case String:
                sqlSegment.append(' ').append(columnName);
                String strValue = (String) columnValue;
                if (strValue.contains(",")) {
                    String[] values = strValue.split(",");
                    sqlSegment.append(" in (");
                    for (String value : values) {
                        sqlSegment.append("'").append(value.trim()).append("', ");
                    }
                    sqlSegment.deleteCharAt(sqlSegment.length() - 2).append(")");
                } else {
                    sqlSegment.append(" = '").append(columnValue).append("'");
                }
                break;
            case Double:
            case Integer:
                sqlSegment.append(' ').append(columnName).append(" = ").append(columnValue);
                break;
            case Object:
                break;
            case Null:
                break;
            default:
                break;
        }
        return sqlSegment.length() == 0 ? null : sqlSegment.toString();
    }

    private static Object getFieldValue(Class<?> cls, User userObj, Field field) {
        String fieldName = field.getName();
        Object fieldValue = null;

        String getter = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
        try {
            Method getMethod = cls.getMethod(getter);
            fieldValue = getMethod.invoke(userObj);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return fieldValue;
    }

}
