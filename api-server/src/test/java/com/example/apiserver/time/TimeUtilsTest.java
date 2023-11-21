package com.example.apiserver.time;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TimeUtilsTest {
    @Autowired
    private TimeUtils timeUtils;
    @Value("${zone.id.name:Asia/Taipei}")
    private String zonedId;


    @Test
    public void testGenerateBusinessTimeDesc_case1() {
        LocalTime now = LocalTime.of(3, 0); // 03:00
        LocalTime startTime = LocalTime.of(3, 0); // 03:00
        LocalTime endTime = LocalTime.of(2, 0); // 02:00

        BusinessTime businessTime = timeUtils.generateBusinessTime(now, startTime, endTime);

        ZonedDateTime expectedStart = getZonedDateTime(startTime, 0);
        ZonedDateTime expectedEnd =  getZonedDateTime(endTime,1);
        assertEquals(expectedStart.toInstant(), businessTime.getStartInstant());
        assertEquals(expectedEnd.toInstant(), businessTime.getEndInstant());
    }
    @Test
    public void testGenerateBusinessTimeDesc_case2() {
        LocalTime now = LocalTime.of(1, 0); // 01:00
        LocalTime startTime = LocalTime.of(3, 0); // 03:00
        LocalTime endTime = LocalTime.of(2, 0); // 02:00

        BusinessTime businessTime = timeUtils.generateBusinessTime(now, startTime, endTime);

        ZonedDateTime expectedStart = getZonedDateTime(startTime, -1);
        ZonedDateTime expectedEnd =  getZonedDateTime(endTime,0);
        assertEquals(expectedStart.toInstant(), businessTime.getStartInstant());
        assertEquals(expectedEnd.toInstant(), businessTime.getEndInstant());
    }
    @Test
    public void testGenerateBusinessTimeDesc_case3() {
        LocalTime now = LocalTime.of(2, 30); // 04:00
        LocalTime startTime = LocalTime.of(3, 0); // 03:00
        LocalTime endTime = LocalTime.of(2, 0); // 02:00

        BusinessTime businessTime = timeUtils.generateBusinessTime(now, startTime, endTime);

        ZonedDateTime expectedStart = getZonedDateTime(startTime, 0);
        ZonedDateTime expectedEnd =  getZonedDateTime(endTime,1);
        assertEquals(expectedStart.toInstant(), businessTime.getStartInstant());
        assertEquals(expectedEnd.toInstant(), businessTime.getEndInstant());
    }
    @Test
    public void testGenerateBusinessTimeDesc_case4() {
        LocalTime now = LocalTime.of(2, 30); // 02:30
        LocalTime startTime = LocalTime.of(3, 0); // 03:00
        LocalTime endTime = LocalTime.of(2, 0); // 02:00

        BusinessTime businessTime = timeUtils.generateBusinessTime(now, startTime, endTime);

        ZonedDateTime expectedStart = getZonedDateTime(startTime, 0);
        ZonedDateTime expectedEnd =  getZonedDateTime(endTime,1);
        assertEquals(expectedStart.toInstant(), businessTime.getStartInstant());
        assertEquals(expectedEnd.toInstant(), businessTime.getEndInstant());
    }
    @Test
    public void testGenerateBusinessTimeDesc_case5() {
        LocalTime now = LocalTime.of(2, 0); // 02:00
        LocalTime startTime = LocalTime.of(3, 0); // 03:00
        LocalTime endTime = LocalTime.of(2, 0); // 02:00

        BusinessTime businessTime = timeUtils.generateBusinessTime(now, startTime, endTime);

        ZonedDateTime expectedStart = getZonedDateTime(startTime, 0);
        ZonedDateTime expectedEnd =  getZonedDateTime(endTime,1);
        assertEquals(expectedStart.toInstant(), businessTime.getStartInstant());
        assertEquals(expectedEnd.toInstant(), businessTime.getEndInstant());
    }

    @Test
    public void testGenerateBusinessTimeAsc_case1() {
        LocalTime now = LocalTime.of(2, 0); // 02:00
        LocalTime startTime = LocalTime.of(1, 0); // 01:00
        LocalTime endTime = LocalTime.of(23, 0); // 23:00

        BusinessTime businessTime = timeUtils.generateBusinessTime(now, startTime, endTime);

        ZonedDateTime expectedStart = getZonedDateTime(startTime, 0);
        ZonedDateTime expectedEnd =  getZonedDateTime(endTime,0);
        assertEquals(expectedStart.toInstant(), businessTime.getStartInstant());
        assertEquals(expectedEnd.toInstant(), businessTime.getEndInstant());
    }
    @Test
    public void testGenerateBusinessTimeAsc_case2() {
        LocalTime now = LocalTime.of(1, 0); // 01:00
        LocalTime startTime = LocalTime.of(1, 0); // 01:00
        LocalTime endTime = LocalTime.of(23, 0); // 23:00

        BusinessTime businessTime = timeUtils.generateBusinessTime(now, startTime, endTime);

        ZonedDateTime expectedStart = getZonedDateTime(startTime, 0);
        ZonedDateTime expectedEnd =  getZonedDateTime(endTime,0);
        assertEquals(expectedStart.toInstant(), businessTime.getStartInstant());
        assertEquals(expectedEnd.toInstant(), businessTime.getEndInstant());
    }
    @Test
    public void testGenerateBusinessTimeAsc_case3() {
        LocalTime now = LocalTime.of(12, 0); // 02:00
        LocalTime startTime = LocalTime.of(1, 0); // 01:00
        LocalTime endTime = LocalTime.of(23, 0); // 23:00

        BusinessTime businessTime = timeUtils.generateBusinessTime(now, startTime, endTime);

        ZonedDateTime expectedStart = getZonedDateTime(startTime, 0);
        ZonedDateTime expectedEnd =  getZonedDateTime(endTime,0);
        assertEquals(expectedStart.toInstant(), businessTime.getStartInstant());
        assertEquals(expectedEnd.toInstant(), businessTime.getEndInstant());
    }
    @Test
    public void testGenerateBusinessTimeAsc_case4() {
        LocalTime now = LocalTime.of(23, 30); // 23:30
        LocalTime startTime = LocalTime.of(1, 0); // 01:00
        LocalTime endTime = LocalTime.of(23, 0); // 23:00

        BusinessTime businessTime = timeUtils.generateBusinessTime(now, startTime, endTime);

        ZonedDateTime expectedStart = getZonedDateTime(startTime, 1);
        ZonedDateTime expectedEnd =  getZonedDateTime(endTime,1);
        assertEquals(expectedStart.toInstant(), businessTime.getStartInstant());
        assertEquals(expectedEnd.toInstant(), businessTime.getEndInstant());
    }
    @Test
    public void testGenerateBusinessTimeAsc_case5() {
        LocalTime now = LocalTime.of(23, 0); // 23:00
        LocalTime startTime = LocalTime.of(1, 0); // 01:00
        LocalTime endTime = LocalTime.of(23, 0); // 23:00

        BusinessTime businessTime = timeUtils.generateBusinessTime(now, startTime, endTime);

        ZonedDateTime expectedStart = getZonedDateTime(startTime, 1);
        ZonedDateTime expectedEnd =  getZonedDateTime(endTime,1);
        assertEquals(expectedStart.toInstant(), businessTime.getStartInstant());
        assertEquals(expectedEnd.toInstant(), businessTime.getEndInstant());
    }


    private ZonedDateTime getZonedDateTime(LocalTime localTime , int plusDays){
        return ZonedDateTime.now(ZoneId.of(zonedId))
                .withHour(localTime.getHour())
                .withMinute(localTime.getMinute())
                .withSecond(0)
                .withNano(0)
                .plusDays(plusDays);

    }
}
