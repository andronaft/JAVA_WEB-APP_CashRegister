package com.zuk.zuk.service;

import com.zuk.zuk.entity.WorkerEntity;

import java.util.List;

public interface WorkerService {

    String findAll();
    String save(WorkerEntity workerEntity);
    String findByLogin(String login);
    String login(WorkerEntity workerEntity);
    String register(WorkerEntity workerEntity);
}
