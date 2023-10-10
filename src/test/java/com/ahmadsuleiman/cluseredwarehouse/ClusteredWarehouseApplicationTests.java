package com.ahmadsuleiman.cluseredwarehouse;

import com.ahmadsuleiman.cluseredwarehouse.Dao.DealRepository;
import com.ahmadsuleiman.cluseredwarehouse.Dao.InvalidDealRepository;
import com.ahmadsuleiman.cluseredwarehouse.Model.Deal;
import com.ahmadsuleiman.cluseredwarehouse.Model.DealResponse;
import com.ahmadsuleiman.cluseredwarehouse.Model.InvalidDeal;
import com.ahmadsuleiman.cluseredwarehouse.Service.DealService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class ClusteredWarehouseApplicationTests {

    @Mock
    private DealRepository dealRepository;

    @Mock
    private InvalidDealRepository invalidDealRepository;

    @InjectMocks
    private DealService dealService;

    @Test
    public void testSaveValidDeal() {
        Deal validDeal = Deal.builder()
                .id("da62108a-6794-11ee-8c99-0242ac120003")
                .fromCurrency("USD")
                .toCurrency("EUR")
                .timestamp(new Date())
                .amount(new BigDecimal("100.00"))
                .build();

        when(dealRepository.existsById(validDeal.getId())).thenReturn(false);
        ResponseEntity<DealResponse> response = dealService.saveDeal(validDeal);
        verify(dealRepository).save(validDeal);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Success", Objects.requireNonNull(response.getBody()).getStatus());
        assertEquals("Deal saved successfully", response.getBody().getDescription());
        assertEquals(validDeal.getId(), response.getBody().getRequestId());
    }

    @Test
    public void testSaveInvalidDealDuplicateId() {

        Deal duplicateDeal = Deal.builder()
                .id("da62108a-6794-11ee-8c99-0242ac120003")
                .build();

        when(dealRepository.existsById(duplicateDeal.getId())).thenReturn(true);
        ResponseEntity<DealResponse> response = dealService.saveDeal(duplicateDeal);
        verify(dealRepository, never()).save(any(Deal.class));
        verify(invalidDealRepository).save(any(InvalidDeal.class));


        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Failed", Objects.requireNonNull(response.getBody()).getStatus());
        assertTrue(response.getBody().getDescription().contains("Deal with the same id already exists"));

        assertNotNull(response.getBody().getRequestId());
    }
}