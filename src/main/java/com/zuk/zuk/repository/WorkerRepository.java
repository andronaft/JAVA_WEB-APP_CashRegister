package com.zuk.zuk.repository;

import com.zuk.zuk.entity.WorkerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository extends CrudRepository<WorkerEntity, Integer> {
    WorkerEntity findByLogin(String login);
}
