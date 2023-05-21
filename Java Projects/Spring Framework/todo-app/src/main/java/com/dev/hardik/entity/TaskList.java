package com.dev.hardik.entity;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "TaskList")
public class TaskList {
    @MongoId
    private String taskId;
    private String taskName;
    private String createdDate;
    private String status;
    private  String finishTragetDate;
    private String taskDescription;
}
