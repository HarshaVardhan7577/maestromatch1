package com.stackroute.usermanagementservice.controller;


import com.stackroute.usermanagementservice.model.TeacherProfile;
import com.stackroute.usermanagementservice.repository.TeacherProfileRepository;
import com.stackroute.usermanagementservice.service.SequenceGeneratorService;
import com.stackroute.usermanagementservice.service.TeacherService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Optional;

@RestController
@RequestMapping("/auth/teacher")
@CrossOrigin("*")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @Autowired
    private KafkaTemplate<String, TeacherProfile> kafkaTemplate;

    @Autowired
    private SequenceGeneratorService DBservice;

    @Autowired
    TeacherProfileRepository teacherProfileRepository;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody TeacherProfile profile){
        profile.setUserId(DBservice.getSequenceNumber(TeacherProfile.SEQUENCE_NAME));
        this.kafkaTemplate.send("teacherRegistration",profile);
        return new ResponseEntity<TeacherProfile>(teacherService.registerTeacher(profile), HttpStatus.CREATED);

    }

    @GetMapping("/{Id}")
    public Optional<TeacherProfile> getTeacherById(@PathVariable int Id){
        return teacherService.getTeacherById(Id);
    }


    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody TeacherProfile profile){
//        boolean result = teacherService.validateUser(profile);


        TeacherProfile profile1 = teacherProfileRepository.findByMailIdAndPassword(profile.getMailId(), profile.getPassword());
        if(profile1 == null){
            return new ResponseEntity<String>("Invalid Credentails", HttpStatus.UNAUTHORIZED);
        }
        else{
            String  token = generateToken(profile);
            System.out.println(token);
            HashMap hashMap = new HashMap();
            hashMap.put("token",token);
            hashMap.put("user",profile1);

            this.kafkaTemplate.send("course", profile1);
            return new ResponseEntity<HashMap>(hashMap,HttpStatus.OK);
        }
    }
    private String generateToken(TeacherProfile profile){
        return Jwts.builder().setSubject(profile.getUserName())
                .setAudience(profile.getMailId())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+30000))
                .signWith(SignatureAlgorithm.HS256,"JwtKey").compact();
    }
}
