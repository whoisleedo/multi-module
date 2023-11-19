package com.example.mockserver;

import org.example.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("v1")
public class StudentMockController {

    private final static Logger log = LoggerFactory.getLogger(StudentMockController.class);
    private Map<String,Student> studentMap ;

    @GetMapping("student/{id}")
    public Student getStudent(@PathVariable int id , HttpServletRequest request){
        int localPort = request.getLocalPort();
        System.out.println(localPort);
        System.out.println();
        Student student = studentMap.get(String.valueOf(id));


        return student;
    }
    @PostConstruct
    public void initStudentMap(){
        Student mary = new Student("Mary", 18 , "female" ,1,"art");
        Student wilson = new Student("Wilson", 30 , "male" ,2,"finance");
        Student sarah = new Student("Sarah", 28 , "female" ,3,"language");
        Student peter = new Student("Peter", 58 , "male" ,4,"computer");
        Student david = new Student("David" , 30 , "male" , 5 , "computer");
        List<Student> students = Arrays.asList(mary, wilson, sarah, peter, david);
        studentMap =students.stream().collect(Collectors.toMap(student -> String.valueOf(student.getStudentId()),
                student -> student));

    }



}
