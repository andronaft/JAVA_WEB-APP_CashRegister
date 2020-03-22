package com.zuk.zuk.service;

import com.zuk.zuk.entity.GoodEntity;

import java.util.List;

public interface GoodService {

    String findAll();
    void save(GoodEntity goodEntity);
}
