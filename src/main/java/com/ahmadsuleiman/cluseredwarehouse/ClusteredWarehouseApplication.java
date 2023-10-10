package com.ahmadsuleiman.cluseredwarehouse;

import com.ahmadsuleiman.cluseredwarehouse.Dao.DealRepository;
import com.ahmadsuleiman.cluseredwarehouse.Model.Deal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/deal")
public class ClusteredWarehouseApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClusteredWarehouseApplication.class, args);
    }

    @Autowired
    private DealRepository dealRepository;

    @PostMapping
    public Deal saveDeal(@RequestBody Deal deal){
        return dealRepository.save(deal);
    }

    @GetMapping
    public List<Deal> getDeals(){
        return dealRepository.findAll();
    }
}
