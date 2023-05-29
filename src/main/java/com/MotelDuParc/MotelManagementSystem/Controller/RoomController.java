package com.MotelDuParc.MotelManagementSystem.Controller;

import com.MotelDuParc.MotelManagementSystem.Model.Guest;
import com.MotelDuParc.MotelManagementSystem.Model.Room;
import com.MotelDuParc.MotelManagementSystem.Service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")
@CrossOrigin("*")
public class RoomController {
    @Autowired
    RoomService roomService;

    @GetMapping("/all")
    public ResponseEntity<List<Room>> findAllRooms(){
        try{
            List<Room> findAllRoom = roomService.roomList();
            return new ResponseEntity<>(findAllRoom, HttpStatus.OK);
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/room/{id}")
    public ResponseEntity<Room> findARoom(@PathVariable("id") Long id){
        try{
            Room findARoom = roomService.findOneRoom(id);
            return new ResponseEntity<>(findARoom,HttpStatus.OK);
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Room> addRoom(@RequestBody Room room){
        try {
            Room newRoom = roomService.addANewRoom(room);
            return new ResponseEntity<>(newRoom,HttpStatus.CREATED);
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Room> updateRoom(@PathVariable Long id, @RequestBody Room room){
        try {
            Room updateRoom = roomService.updateARoom(id, room);
            return new ResponseEntity<>(updateRoom,HttpStatus.ACCEPTED);
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Room> deleteRoom(@PathVariable("id") Long id){
        try {
            roomService.deleteARoom(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
