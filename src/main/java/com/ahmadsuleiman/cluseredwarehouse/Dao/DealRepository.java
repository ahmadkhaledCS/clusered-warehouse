package com.ahmadsuleiman.cluseredwarehouse.Dao;

import com.ahmadsuleiman.cluseredwarehouse.Model.Deal;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DealRepository extends MongoRepository<Deal,Integer> {
}
