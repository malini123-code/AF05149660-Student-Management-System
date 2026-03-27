package model;

public class Student {

    private int id;
    private String name;
    private int age;
    private String course;
    private String email;

    public Student() {}

    public Student(String name, int age, String course, String email) {
        this.name = name;
        this.age = age;
        this.course = course;
        this.email = email;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public int getAge() { return age; }
    public String getCourse() { return course; }
    public String getEmail() { return email; }

    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setCourse(String course) { this.course = course; }
    public void setEmail(String email) { this.email = email; }
}