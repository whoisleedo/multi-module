package com.example.apiserver.time;

import java.time.Instant;
import java.time.LocalTime;

public class BusinessTime {
    private LocalTime startTime;
    private LocalTime endTime;
    private Instant startInstant;
    private Instant endInstant;

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public Instant getStartInstant() {
        return startInstant;
    }

    public void setStartInstant(Instant startInstant) {
        this.startInstant = startInstant;
    }

    public Instant getEndInstant() {
        return endInstant;
    }

    public void setEndInstant(Instant endInstant) {
        this.endInstant = endInstant;
    }

    public BusinessTime() {
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer(super.toString());
        sb.append("{startTime:").append(startTime);
        sb.append(", endTime:").append(endTime);
        sb.append(", startInstant:").append(startInstant);
        sb.append(", endInstant:").append(endInstant);
        sb.append('}');
        return sb.toString();
    }
}
