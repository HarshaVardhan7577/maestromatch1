package com.stackroute.usermanagementservice.service;

import com.stackroute.usermanagementservice.model.UserProfile;
import com.stackroute.usermanagementservice.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserProfileRepository repo;
    public UserProfile registerUser(UserProfile profile) {

        profile.setUserName(profile.getFirstName()+" "+profile.getLastName());
        return repo.save(profile);
    }


   public Optional<UserProfile> getUserById(int id){
        return repo.findById(id);
   }

    public boolean validateUser(UserProfile profile) {
        UserProfile profile1 = repo.findByMailIdAndPassword(profile.getMailId(), profile.getPassword());
        if(profile1 == null){
            return false;
        }
        else{
            return true;
        }
    }
}
