package com.rollforinitiative.campaignmgr.repository;

import com.rollforinitiative.campaignmgr.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository {
    Optional<Users> findByUsername(String username);

}
