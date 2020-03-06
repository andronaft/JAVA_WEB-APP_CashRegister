package com.zuk.zuk.repository;

import com.zuk.zuk.entity.GoodEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodRepository extends CrudRepository<GoodEntity, Integer> {

}
