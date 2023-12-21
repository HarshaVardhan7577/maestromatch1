package com.stackroute.usermanagementservice.repository;

import com.stackroute.usermanagementservice.model.UserProfile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepository extends MongoRepository<UserProfile,Integer> {
    UserProfile findByMailIdAndPassword(String mailId,String password);
}
