package com.crud_springboot3_jpa.repository;

import com.crud_springboot3_jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}
