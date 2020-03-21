package com.zuk.zuk.service.impl;

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

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository){this.transactionRepository = transactionRepository;}

    @Override
    public List<TransactionEntity> findAll() {
        return Lists.newArrayList(transactionRepository.findAll());
    }

    @Override
    public String save(TransactionEntity transactionEntity) {
        //temporary
        transactionEntity.setId(1);
        transactionEntity.setDateandtime(new Timestamp(System.currentTimeMillis()));
        transactionEntity.setGoods("1,2");
        transactionEntity.setIdworker(11);
        //temporary

        transactionRepository.save(transactionEntity);
        return "good";
    }

}
