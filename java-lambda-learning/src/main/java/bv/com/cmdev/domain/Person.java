package bv.com.cmdev.domain;

public class Person {
    private Integer id;
    private String name;
    private String nickname;
    private String middlename;
    private String lastname;
    private Integer age;

    public Person() { }

    public Person(Integer id, String name, String nickname, String middlename, String lastname, Integer age) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
