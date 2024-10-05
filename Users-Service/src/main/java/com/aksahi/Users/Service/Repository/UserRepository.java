package com.aksahi.Users.Service.Repository;

import com.aksahi.Users.Service.Model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserDetails,Long> {

    Optional<UserDetails> findByUserName(String userName);
    void deleteByUserName(String userName);
}
