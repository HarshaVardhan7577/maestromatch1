package com.stackroute.usermanagementservice.service;

import com.stackroute.usermanagementservice.model.TeacherProfile;
import com.stackroute.usermanagementservice.model.UserProfile;
import com.stackroute.usermanagementservice.repository.TeacherProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeacherService {
    @Autowired
    private TeacherProfileRepository teacherProfileRepository;

    @Autowired
	private KafkaTemplate<String, TeacherProfile> kafkaTemplate;
    
    public TeacherProfile registerTeacher(TeacherProfile profile) {
        profile.setUserName(profile.getFirstName()+" "+
        profile.getLastName());
        this.kafkaTemplate.send("teacher", profile);
        return teacherProfileRepository.save(profile);
    }


    public Optional<TeacherProfile> getTeacherById(int id){
        return teacherProfileRepository.findById(id);
    }

    public boolean validateUser(TeacherProfile profile) {
        TeacherProfile profile1 = teacherProfileRepository.findByMailIdAndPassword(profile.getMailId(), profile.getPassword());
        if(profile1 == null){
            return false;
        }
        else{
            return true;
        }
    }
}
