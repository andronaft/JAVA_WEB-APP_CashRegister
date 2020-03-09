package com.zuk.zuk.service.impl;

import com.zuk.zuk.entity.TransactionEntity;
import com.zuk.zuk.repository.TransactionRepository;
import com.zuk.zuk.service.TransactionService;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("TransactionServiceImpl")
@Repository
@Transactional
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository){this.transactionRepository = transactionRepository;}

    @Override
    public List<TransactionEntity> findAll() {
        return Lists.newArrayList(transactionRepository.findAll());
    }
}
