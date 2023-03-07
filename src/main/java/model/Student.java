package model;

public class Student {

    private int id;
    private String name;
    private int age;
    private String code;
    private String className;
    private String address;
    private float mark;

    public Student(int id, String name, int age, String className, String code, String address, float mark) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.className = className;
        this.code = code;
        this.address = address;
        this.mark = mark;
    }

    public Student(String name, int age, String className, String code, String address, float mark) {
        this.name = name;
        this.age = age;
        this.className = className;
        this.code = code;
        this.address = address;
        this.mark = mark;
    }

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getMark() {
        return mark;
    }

    public void setMark(float mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return id  + "\t" + name + "\t" + age + "\t" + className+  "\t" +code + "\t" +  address + "\t" +  mark;
    }
}

