package com.MotelDuParc.MotelManagementSystem.Controller;

import com.MotelDuParc.MotelManagementSystem.Model.Guest;
import com.MotelDuParc.MotelManagementSystem.Service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guest")
@CrossOrigin("*")
public class GuestController {
    @Autowired
    GuestService guestService;

    @GetMapping("/all")
    public ResponseEntity<List<Guest>> findAllGuest(){
        try{
            List<Guest> findAllGuest = guestService.guestList();
            return new ResponseEntity<>(findAllGuest,HttpStatus.OK);
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("find/{id}")
    public ResponseEntity<Guest> findAGuest(@PathVariable("id") Long id){
        try{
            Guest findAGuest = guestService.findOneGuest(id);
            return new ResponseEntity<>(findAGuest,HttpStatus.OK);
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Guest> addGuest(@RequestBody Guest guest){
        try {
            Guest newGuest = guestService.addGuest(guest);
            return new ResponseEntity<>(newGuest,HttpStatus.CREATED);
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Guest> updateGuest(@PathVariable Long id, @RequestBody Guest guest){
        try {
            Guest updateGuest = guestService.updateGuest(id,guest);
            return new ResponseEntity<>(updateGuest,HttpStatus.CREATED);
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Guest> deleteGuest(@PathVariable("id") Long id){
        try {
            guestService.deleteGuest(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
