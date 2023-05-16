package com.MotelDuParc.MotelManagementSystem.Repo;

import com.MotelDuParc.MotelManagementSystem.Model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends JpaRepository<Guest,Long> {

}
