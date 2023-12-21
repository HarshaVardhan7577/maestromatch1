package com.stackroute.usermanagementservice.repository;

import com.stackroute.usermanagementservice.model.TeacherProfile;
import com.stackroute.usermanagementservice.model.UserProfile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherProfileRepository extends MongoRepository<TeacherProfile,Integer> {
    TeacherProfile findByMailIdAndPassword(String mailId, String password);

}
