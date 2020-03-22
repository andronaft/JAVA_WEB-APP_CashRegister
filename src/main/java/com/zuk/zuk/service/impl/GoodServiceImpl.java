package com.zuk.zuk.service.impl;

import com.zuk.zuk.JsonStringMaker;
import com.zuk.zuk.entity.GoodEntity;
import com.zuk.zuk.repository.GoodRepository;
import com.zuk.zuk.service.GoodService;
import lombok.AllArgsConstructor;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("GoodServiceImpl")
@Repository
@Transactional
public class GoodServiceImpl implements GoodService {

    private final GoodRepository goodRepository;
    private final JsonStringMaker jsonStringMaker;


    @Autowired
    public GoodServiceImpl(GoodRepository goodRepository,JsonStringMaker jsonStringMaker){
        this.jsonStringMaker = jsonStringMaker;
        this.goodRepository = goodRepository;
    }

    @Override
    public String findAll() {
        return jsonStringMaker.listToJson(Lists.newArrayList(goodRepository.findAll()));
    }

    @Override
    public void save(GoodEntity goodEntity) {
        goodRepository.save(goodEntity);
    }

}
