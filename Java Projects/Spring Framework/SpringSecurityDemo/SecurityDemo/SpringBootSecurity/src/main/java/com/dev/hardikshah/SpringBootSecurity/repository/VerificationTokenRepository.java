package com.dev.hardikshah.SpringBootSecurity.repository;

import com.dev.hardikshah.SpringBootSecurity.entity.VerificationToken;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerificationTokenRepository extends MongoRepository<VerificationToken, Long> {
    VerificationToken findByToken(String token);
}
