package org.example.entity;

public class Student extends Person{
    private int studentId;
    private String major;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Student() {
    }

    public Student(String name,int age,String gender ,int studentId, String major) {
        super.setName(name);
        super.setAge(age);
        super.setGender(gender);
        this.studentId = studentId;
        this.major = major;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer(super.toString());
        sb.append("{studentId:").append(studentId);
        sb.append(", major:'").append(major).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
