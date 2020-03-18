package com.zuk.zuk.service;

import com.zuk.zuk.entity.TransactionEntity;

import java.util.List;

public interface TransactionService {

    List<TransactionEntity> findAll();
    void save(TransactionEntity transactionEntity);
}
