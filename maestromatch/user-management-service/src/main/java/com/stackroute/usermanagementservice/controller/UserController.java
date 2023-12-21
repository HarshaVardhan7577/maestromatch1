package com.stackroute.usermanagementservice.controller;

import com.stackroute.usermanagementservice.model.UserProfile;
import com.stackroute.usermanagementservice.repository.UserProfileRepository;
import com.stackroute.usermanagementservice.service.SequenceGeneratorService;
import com.stackroute.usermanagementservice.service.UserService;
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
@RequestMapping("/auth/user")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserService service;

    @Autowired
    private KafkaTemplate<String,UserProfile> userKafkaTemplate;

    @Autowired
    private KafkaTemplate<String,UserProfile> senderKafkaTemplate;

    @Autowired
  private SequenceGeneratorService DBservice;

@Autowired
private UserProfileRepository userProfileRepository;


    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserProfile profile){

         profile.setUserId(DBservice.getSequenceNumber(UserProfile.SEQUENCE_NAME));
         this.senderKafkaTemplate.send("userRegistration",profile);
        return new ResponseEntity<UserProfile>(service.registerUser(profile), HttpStatus.CREATED);
    }


@GetMapping("/{id}")
public Optional<UserProfile> getUserById(@PathVariable int id){
        return service.getUserById(id);
}

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserProfile profile){
//        boolean result = service.validateUser(profile);

        UserProfile profile1 = userProfileRepository.findByMailIdAndPassword(profile.getMailId(), profile.getPassword());
        if(profile1 == null){
             return new ResponseEntity<String>("Invalid Credentails", HttpStatus.UNAUTHORIZED);
        }
        else{
            String  token = generateToken(profile);
            System.out.println(token);
            HashMap hashMap = new HashMap();
            hashMap.put("token",token);
            hashMap.put("user",profile1);
            this.userKafkaTemplate.send("booking",profile1);
            return new ResponseEntity<HashMap>(hashMap,HttpStatus.OK);
        }

    }

    private String generateToken(UserProfile profile){
        return Jwts.builder().setSubject(profile.getUserName())
                .setAudience(profile.getMailId())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+30000))
                .signWith(SignatureAlgorithm.HS256,"JwtKey").compact();
    }


}
