package com.ahmadsuleiman.cluseredwarehouse.Model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collation = "deals")
public class Deal {
    @Id
    private String id;
    private String fromCurrency;
    private String toCurrency;
    private Date timestamp;
    private BigDecimal amount;
}
