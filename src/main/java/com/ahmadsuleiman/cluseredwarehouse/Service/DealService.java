package com.ahmadsuleiman.cluseredwarehouse.Service;

import com.ahmadsuleiman.cluseredwarehouse.Dao.DealRepository;
import com.ahmadsuleiman.cluseredwarehouse.Dao.InvalidDealRepository;
import com.ahmadsuleiman.cluseredwarehouse.Model.Deal;
import com.ahmadsuleiman.cluseredwarehouse.Model.InvalidDeal;
import io.micrometer.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

@Slf4j
@Service
public class DealService {
    private final DealRepository dealRepository;
    private final InvalidDealRepository invalidDealRepository;

    public DealService(DealRepository dealRepository,InvalidDealRepository invalidDealRepository) {
        this.dealRepository = dealRepository;
        this.invalidDealRepository=invalidDealRepository;
    }

    public ResponseEntity<?> saveDeal(Deal deal) {
        log.info("received deal : "+ deal.toString());
        boolean isValid = true;
        String invalidReason = "";

        if (dealRepository.existsById(deal.getId())) {
            isValid = false;
            invalidReason = "Deal with the same id already exists";
        }
        else if (deal.getAmount() == null || deal.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            isValid = false;
            invalidReason = "Amount is invalid (null or not greater than zero)";
        } else if (StringUtils.isBlank(deal.getFromCurrency())) {
            isValid = false;
            invalidReason = "From Currency ISO Code is required";
        } else if (StringUtils.isBlank(deal.getToCurrency())) {
            isValid = false;
            invalidReason = "To Currency ISO Code is required";
        } else if (deal.getTimestamp() == null) {
            isValid = false;
            invalidReason = "Timestamp is required";
        } else if (deal.getTimestamp().after(new Date())) {
            isValid = false;
            invalidReason = "Timestamp cannot be in the future";
        }

        if (isValid) {
            dealRepository.save(deal);
            return ResponseEntity.ok("Deal saved successfully");
        } else {
            invalidDealRepository.save(convertToInvalidDeal(deal, invalidReason));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid deal: " + invalidReason);
        }
    }

    public static InvalidDeal convertToInvalidDeal(Deal deal,String invalidReason) {
        return InvalidDeal.builder()
                .requestId(deal.getId())
                .fromCurrency(deal.getFromCurrency())
                .toCurrency(deal.getToCurrency())
                .timestamp(deal.getTimestamp())
                .amount(deal.getAmount())
                .invalidReason(invalidReason)
                .build();
    }
}
