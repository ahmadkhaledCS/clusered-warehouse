package com.ahmadsuleiman.cluseredwarehouse.Dao;

import com.ahmadsuleiman.cluseredwarehouse.Model.Deal;
import com.ahmadsuleiman.cluseredwarehouse.Model.InvalidDeal;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InvalidDealRepository extends MongoRepository<InvalidDeal,String> {
}
