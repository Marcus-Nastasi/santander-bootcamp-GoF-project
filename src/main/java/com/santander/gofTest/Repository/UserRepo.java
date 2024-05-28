package com.santander.gofTest.Repository;

import com.santander.gofTest.Models.Users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    @Query(value = "SELECT u.*, a.* FROM users u " +
                    "INNER JOIN address a " +
                    "ON u.address_id = a.id", nativeQuery = true)
    List<Object[]> findAddressFromUser(int id);
}



