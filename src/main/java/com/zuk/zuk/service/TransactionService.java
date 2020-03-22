package com.zuk.zuk.service;

import com.zuk.zuk.entity.TransactionEntity;

import java.util.List;

public interface TransactionService {

    String findAll();
    String save(TransactionEntity transactionEntity);
}
