package com.dev.hardik.modal;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class TaskListModal {
    private String taskId;
    private String taskName;
    private String createdDate;
    private String status;
    private  String finishTragetDate;
    private String taskDescription;
}
