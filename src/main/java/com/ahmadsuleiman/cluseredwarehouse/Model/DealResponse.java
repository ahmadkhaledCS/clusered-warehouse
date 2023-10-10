package com.ahmadsuleiman.cluseredwarehouse.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DealResponse {
    private String requestId;
    private String description;
    private String status;
}
