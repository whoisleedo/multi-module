package com.example.apiserver.time;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Service
public class TimeUtils {
    @Value("${zone.id.name:Asia/Taipei}")
    private String zonedId;


    public  BusinessTime generateBusinessTime(LocalTime now ,
                                              LocalTime startTime,
                                              LocalTime endTime){
        if(startTime.isBefore(endTime)){

            return getBusinessTimeAsc(now,startTime,endTime);
        }

        return  getBusinessTimeDesc(now,startTime,endTime);
    }

    private  BusinessTime setBusinessTime(LocalTime startTime, LocalTime endTime){
        BusinessTime businessTime = new BusinessTime();
        businessTime.setStartTime(startTime);
        businessTime.setEndTime(endTime);

        return businessTime;
    }

    private BusinessTime getBusinessTimeDesc(LocalTime now, LocalTime startTime, LocalTime endTime) {
        BusinessTime businessTime = setBusinessTime(startTime,endTime);
        Instant startInstant;
        Instant endInstant;
        if(now.isBefore(startTime) && now.isBefore(endTime) && endTime.isBefore(startTime)){
            startInstant = getInstant(startTime,-1);
            endInstant = getInstant(endTime,0);
        }else {
            startInstant = getInstant(startTime,0);
            endInstant = getInstant(endTime , 1);
        }
        businessTime.setStartInstant(startInstant);
        businessTime.setEndInstant(endInstant);

        return businessTime;
    }



    private BusinessTime getBusinessTimeAsc(LocalTime now, LocalTime startTime, LocalTime endTime) {
        BusinessTime businessTime = setBusinessTime(startTime,endTime);
        Instant startInstant;
        Instant endInstant;
        if(now.equals(endTime) || now.isAfter(endTime)){
            startInstant = getInstant(startTime,1);
            endInstant = getInstant(endTime,1);
        }else{
            startInstant =getInstant(startTime,0);
            endInstant = getInstant(endTime , 0);
        }
        businessTime.setStartInstant(startInstant);
        businessTime.setEndInstant(endInstant);

        return businessTime;
    }

    private Instant getInstant(LocalTime localTime , int plusDays){
       return ZonedDateTime.now(ZoneId.of(zonedId))
                .withHour(localTime.getHour())
                .withMinute(localTime.getMinute())
                .withSecond(0)
                .withNano(0)
                .plusDays(plusDays)
                .toInstant();
    }
}
