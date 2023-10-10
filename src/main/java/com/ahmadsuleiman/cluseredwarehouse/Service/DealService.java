package com.ahmadsuleiman.cluseredwarehouse.Service;

import com.ahmadsuleiman.cluseredwarehouse.Dao.DealRepository;
import com.ahmadsuleiman.cluseredwarehouse.Model.Deal;
import org.springframework.stereotype.Service;

@Service
public class DealService {
    private final DealRepository dealRepository;

    public DealService(DealRepository dealRepository) {
        this.dealRepository = dealRepository;
    }

    public Deal saveDeal(Deal deal){
        return dealRepository.save(deal);
    }
}
