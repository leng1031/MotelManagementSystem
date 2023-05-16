package com.MotelDuParc.MotelManagementSystem.Repo;

import com.MotelDuParc.MotelManagementSystem.Model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room,Long> {
}
