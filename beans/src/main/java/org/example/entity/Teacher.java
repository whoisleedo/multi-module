package org.example.entity;

public class Teacher extends Person{
    private int teacherId;
    private String majorClass;

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getMajorClass() {
        return majorClass;
    }

    public void setMajorClass(String majorClass) {
        this.majorClass = majorClass;
    }

    public Teacher() {
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer(super.toString());
        sb.append("{teacherId:").append(teacherId);
        sb.append(", majorClass:'").append(majorClass).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
