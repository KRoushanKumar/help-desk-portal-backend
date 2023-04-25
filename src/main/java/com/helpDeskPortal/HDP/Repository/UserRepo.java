package com.helpDeskPortal.HDP.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.helpDeskPortal.HDP.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
