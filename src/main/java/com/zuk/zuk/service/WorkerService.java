package com.zuk.zuk.service;

import com.zuk.zuk.entity.WorkerEntity;

import java.util.List;

public interface WorkerService {

    List<WorkerEntity> findAll();
    void save(WorkerEntity workerEntity);
}
