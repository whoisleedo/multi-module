package com.example.apiserver;

import org.example.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("api")
public class StudentController {

    private final static Logger log = LoggerFactory.getLogger(StudentController.class);


    @GetMapping("student/{id}")
    public Student getStudentById(@PathVariable String id) {
        String url = "http://localhost:8081/v1/student/{id}";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Student> response = restTemplate.getForEntity(url, Student.class, id);
        return response.getBody();
    }
    @PostMapping("student")
    public Student postStudentById(@RequestBody StudentRequest request){
        String url = "http://localhost:8081/v1/student/{id}";
        int id = request.getId();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Student> response = restTemplate.getForEntity(url, Student.class, id);
        return response.getBody();

    }
}
