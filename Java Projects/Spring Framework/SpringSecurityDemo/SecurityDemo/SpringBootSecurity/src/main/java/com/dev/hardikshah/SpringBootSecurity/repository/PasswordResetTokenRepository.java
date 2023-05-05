package com.dev.hardikshah.SpringBootSecurity.repository;

import com.dev.hardikshah.SpringBootSecurity.entity.PasswordResetToken;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasswordResetTokenRepository extends MongoRepository<PasswordResetToken, Long> {
    PasswordResetToken findByToken(String token);
}
