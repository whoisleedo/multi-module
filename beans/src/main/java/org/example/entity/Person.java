package org.example.entity;

public class Person {
    private String name;
    private int age;
    private String gender;

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Person() {
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer(super.toString());
        sb.append("{name:'").append(name).append('\'');
        sb.append(", age:").append(age);
        sb.append(", gender:'").append(gender).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
