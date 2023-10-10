package com.ahmadsuleiman.cluseredwarehouse.Controllers;

import com.ahmadsuleiman.cluseredwarehouse.Model.Deal;
import com.ahmadsuleiman.cluseredwarehouse.Service.DealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/deals")
public class DealController {

    private final DealService dealService;

    @Autowired
    public DealController(DealService dealService) {
        this.dealService = dealService;
    }

    @PostMapping("/save-deal")
    public ResponseEntity<?> saveDeal(@RequestBody Deal deal){
        return dealService.saveDeal(deal);
    }

}
