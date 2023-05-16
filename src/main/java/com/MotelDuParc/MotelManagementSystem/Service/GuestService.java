package com.MotelDuParc.MotelManagementSystem.Service;

import com.MotelDuParc.MotelManagementSystem.Model.Guest;
import com.MotelDuParc.MotelManagementSystem.Repo.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestService {
    @Autowired
    GuestRepository guestRepository;

    public List<Guest> guestList(){
        List<Guest> showAll = guestRepository.findAll();
        return showAll;
    }

    public Guest findOneGuest(Long guestId){
        Guest findOne = guestRepository.findById(guestId).orElse(null);
        return findOne;
    }

    public Guest addGuest(Guest requestBody){
        Guest addNewOne = guestRepository.save(requestBody);
        return addNewOne;
    }

    public boolean deleteGuest(Long guestId){
        guestRepository.deleteById(guestId);
        return true;
    }

    public Guest updateGuest(Long guestId, Guest requestBody){
        Guest findOne = findOneGuest(guestId);
        if (findOne == null) return null;

        if (requestBody.getFirstName() != null & requestBody.getFirstName() != ""){
            findOne.setFirstName(requestBody.getFirstName());
        }
        if (requestBody.getLastName() != null & requestBody.getLastName() != ""){
            findOne.setLastName(requestBody.getLastName());
        }
        if (requestBody.getAddress() != null & requestBody.getAddress() != ""){
            findOne.setAddress(requestBody.getAddress());
        }
        if (requestBody.getPhoneNumber() != null & requestBody.getPhoneNumber() != ""){
            findOne.setPhoneNumber(requestBody.getPhoneNumber());
        }
        if (requestBody.getGender() != null & requestBody.getGender() != ""){
            findOne.setGender(requestBody.getGender());
        }


        Guest updateOne = saveGuest(findOne);
        return updateOne;
    }

    public Guest saveGuest(Guest guest){
        return guestRepository.save(guest);
    }
}
