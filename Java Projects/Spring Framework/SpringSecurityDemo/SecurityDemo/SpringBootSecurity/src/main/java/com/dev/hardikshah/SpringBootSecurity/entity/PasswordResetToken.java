package com.dev.hardikshah.SpringBootSecurity.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Calendar;
import java.util.Date;
@Data
@Document
@NoArgsConstructor
public class PasswordResetToken {
    private static  final int EXPIRATION_TIME = 10;
    private String token;
    private Date expirationTime;

    private User user;

    public PasswordResetToken(User user, String token){
        super();
        this.user=user;
        this.token =token;
        this.expirationTime = calculateExpirationDate(EXPIRATION_TIME);

    }
    public PasswordResetToken(String token){
        super();
        this.token = token;
        this.expirationTime = calculateExpirationDate(EXPIRATION_TIME);
    }

    private Date calculateExpirationDate(int expirationTime) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(new Date().getTime());
        calendar.add(Calendar.MINUTE, expirationTime);
        return new Date(calendar.getTime().getTime());
    }
}
