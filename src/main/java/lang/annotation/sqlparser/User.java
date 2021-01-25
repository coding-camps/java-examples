package lang.annotation.sqlparser;

@DbTable("users")
public class User {

    @DbColumn("uid")
    private int id;

    @DbColumn("uname")
    private String name;

    @DbColumn("uage")
    private int age;

    @DbColumn("uemail")
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
