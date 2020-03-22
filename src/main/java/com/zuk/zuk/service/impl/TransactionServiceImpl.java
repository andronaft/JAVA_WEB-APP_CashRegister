package com.zuk.zuk.service.impl;

import com.zuk.zuk.JsonStringMaker;
import com.zuk.zuk.entity.TransactionEntity;
import com.zuk.zuk.repository.TransactionRepository;
import com.zuk.zuk.service.TransactionService;
import org.assertj.core.util.Lists;
import org.hibernate.query.criteria.internal.expression.function.CurrentDateFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.List;

@Service("TransactionServiceImpl")
@Repository
@Transactional
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final JsonStringMaker jsonStringMaker;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository,JsonStringMaker jsonStringMaker)
    {
        this.transactionRepository = transactionRepository;
        this.jsonStringMaker = jsonStringMaker;
    }

    @Override
    public String findAll() {
        return jsonStringMaker.listToJson(Lists.newArrayList(transactionRepository.findAll()));
    }

    @Override
    public String save(TransactionEntity transactionEntity) {
        transactionEntity.setDateandtime(new Timestamp(System.currentTimeMillis()));
        return jsonStringMaker.objectToJson(transactionRepository.save(transactionEntity));
    }

}
