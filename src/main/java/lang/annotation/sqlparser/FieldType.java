package lang.annotation.sqlparser;

public enum FieldType {
    // NULL 类型
    Null,
    // 整型
    Integer,
    // 浮点型
    Double,
    // 字符串类型
    String,
    // 对象类型
    Object;

    public static FieldType check(Object fieldValue) {
        if (fieldValue == null) {
            return FieldType.Null;
        }

        FieldType type = FieldType.Null;
        if (fieldValue instanceof java.lang.Integer) {
            if ((Integer) fieldValue != 0) {
                type = FieldType.Integer;
            }
        } else if (fieldValue instanceof java.lang.Double) {
            // BUG float is 0
            if ((Double) fieldValue != 0) {
                type = FieldType.Double;
            }
        } else if (fieldValue instanceof java.lang.String) {
            type = FieldType.String;
        } else {
            type = FieldType.Object;
        }
        return type;
    }

}
