package com.dev.hardikshah.SpringBootSecurity.entity;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Document
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Attempts {
    @MongoId
    private Long id;
    private String username;
    private int attempts;
}
