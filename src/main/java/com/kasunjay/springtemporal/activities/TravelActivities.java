package com.kasunjay.springtemporal.activities;

import com.kasunjay.springtemporal.dto.TravelRequest;
import io.temporal.activity.ActivityInterface;

/**
 * @Author: kasun_t
 * @Package: com.kasunjay.springtemporal.activities
 * @Interface: TravelActivities
 * @Created on: 8/14/2025 at 11:42 AM
 */
@ActivityInterface
public interface TravelActivities {

    public void bookFlight(TravelRequest travelRequest);

    public void cancelFlight(TravelRequest travelRequest);

    public void bookHotel(TravelRequest travelRequest);

    public void cancelHotel(TravelRequest travelRequest);

    public void arrangeTransport(TravelRequest travelRequest);

    public void cancelTransport(TravelRequest travelRequest);

    public void cancelBooking(TravelRequest travelRequest);

    public void confirmBooking(TravelRequest travelRequest);
}
