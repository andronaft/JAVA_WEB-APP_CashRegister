package com.zuk.zuk.service.impl;

import com.zuk.zuk.JsonStringMaker;
import com.zuk.zuk.entity.WorkerEntity;
import com.zuk.zuk.repository.WorkerRepository;
import com.zuk.zuk.service.WorkerService;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service("WorkerServiceImpl")
@Repository
@Transactional
public class WorkerServiceImpl implements WorkerService {

    private final JsonStringMaker jsonStringMaker;
    private final WorkerRepository workerRepository;

    @Autowired
    public WorkerServiceImpl(WorkerRepository workerRepository,JsonStringMaker jsonStringMaker){
        this.jsonStringMaker = jsonStringMaker;
        this.workerRepository = workerRepository;
    }

    @Override
    public String findAll() {
        return jsonStringMaker.listToJson(Lists.newArrayList(workerRepository.findAll()));
    }

    @Override
    public String save(WorkerEntity workerEntity) {
        return jsonStringMaker.objectToJson(workerRepository.save(workerEntity));
    }

    @Override
    public String findByLogin(String login) {
        return workerRepository.findByLogin(login).getName();
    }

    @Override
    public String login(WorkerEntity workerEntity) {
        System.out.println(workerEntity.getLogin() + " " + workerEntity.getPassword());
        WorkerEntity findWorker = workerRepository.findByLogin(workerEntity.getLogin());
        System.out.println(findWorker.getLogin() + " " + findWorker.getPassword());
        if(findWorker!=null){
            if(findWorker.getPassword().equals(workerEntity.getPassword()))
            if(findWorker.getPassword().hashCode() == workerEntity.getPassword().hashCode()){
                System.out.println("login OK");
                return jsonStringMaker.objectToJson(findWorker);
            }
        }
        return null;
    }

    @Override
    public String register(WorkerEntity workerEntity) {
        WorkerEntity findWorker = workerRepository.findByLogin(workerEntity.getLogin());
        if(findWorker==null){
            workerRepository.save(workerEntity);
            return jsonStringMaker.objectToJson(workerRepository.findByLogin(workerEntity.getLogin()));
        }
        else {
            return jsonStringMaker.objectToJson("This login is unavailable");
        }
    }
}
