package com.dev.hardikshah.SpringBootSecurity.repository;

import com.dev.hardikshah.SpringBootSecurity.entity.Attempts;
import com.dev.hardikshah.SpringBootSecurity.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttemptsRepository extends MongoRepository<Attempts, Long> {
    Attempts findAttemptsByUsername(String userName);
}
