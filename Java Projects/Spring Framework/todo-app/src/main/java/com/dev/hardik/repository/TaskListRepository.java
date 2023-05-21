package com.dev.hardik.repository;

import com.dev.hardik.entity.TaskList;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskListRepository extends MongoRepository<TaskList, String> {
}
