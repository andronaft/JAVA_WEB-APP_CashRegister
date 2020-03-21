package com.zuk.zuk.service.impl;

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

    private final WorkerRepository workerRepository;

    @Autowired
    public WorkerServiceImpl(WorkerRepository workerRepository){this.workerRepository = workerRepository;}

    @Override
    public List<WorkerEntity> findAll() {
        return Lists.newArrayList(workerRepository.findAll());
    }

    @Override
    public void save(WorkerEntity workerEntity) {
        workerRepository.save(workerEntity);
    }

    @Override
    public String findByLogin(String login) {

        return workerRepository.findByLogin(login).getName();
    }
}
