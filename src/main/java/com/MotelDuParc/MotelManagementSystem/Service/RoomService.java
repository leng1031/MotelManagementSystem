package com.MotelDuParc.MotelManagementSystem.Service;

import com.MotelDuParc.MotelManagementSystem.Model.Room;
import com.MotelDuParc.MotelManagementSystem.Repo.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    @Autowired
    RoomRepository roomRepository;

    public List<Room> roomList (){
        List<Room> roomList = roomRepository.findAll();
        return roomList;
    }

    public Room findOneRoom (Long roomId){
        Room findOneRoom = roomRepository.findById(roomId).orElse(null);
        return findOneRoom;
    }

    public Room addANewRoom(Room requestBody){
        Room addNewOne = roomRepository.save(requestBody);
        return addNewOne;
    }

    public Boolean deleteARoom(Long roomId){
        roomRepository.deleteById(roomId);
        return true;
    }

    public Room updateARoom (Long roomId, Room requestBody){
        Room findOne = findOneRoom(roomId);
        if (findOne == null) return null;

        if (requestBody.getRoomType() != null && requestBody.getRoomType() !=""){
            findOne.setRoomType(requestBody.getRoomType());
        }
        if (requestBody.getPrice() != null && requestBody.getPrice() !=""){
            findOne.setPrice(requestBody.getPrice());
        }
        if (requestBody.getStatus() != null && requestBody.getStatus() !=""){
            findOne.setStatus(requestBody.getStatus());
        }
        Room updateOneRoom = roomRepository.save(findOne);
        return updateOneRoom;
    }

    public Room saveRoom(Room room){
        return roomRepository.save(room);
    }
}
