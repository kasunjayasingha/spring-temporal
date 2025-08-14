package com.kasunjay.springtemporal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: kasun_t
 * @Package: com.kasunjay.springtemporal.dto
 * @Class: TravelRequest
 * @Created on: 8/14/2025 at 11:44 AM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TravelRequest {

    private String userId;
    private String destination;
    private String travelDate;
}
