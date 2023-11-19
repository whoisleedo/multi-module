package com.example.apiserver;

public class StudentRequest {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer(super.toString());
        sb.append("{id:").append(id);
        sb.append('}');
        return sb.toString();
    }

    public StudentRequest() {
    }
}
