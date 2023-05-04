package com.dev.hardikshah.SpringBootSecurity.repository;

import com.dev.hardikshah.SpringBootSecurity.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, Long> {
}
