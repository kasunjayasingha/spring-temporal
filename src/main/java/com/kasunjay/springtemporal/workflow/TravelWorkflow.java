package com.kasunjay.springtemporal.workflow;

import com.kasunjay.springtemporal.dto.TravelRequest;
import io.temporal.workflow.SignalMethod;
import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

/**
 * @Author: kasun_t
 * @Package: com.kasunjay.springtemporal.workflow
 * @Interface: TravelWorkflow
 * @Created on: 8/14/2025 at 12:01 PM
 */
@WorkflowInterface
public interface TravelWorkflow {

    @WorkflowMethod
    void bookTrip(TravelRequest travelRequest);


    @SignalMethod
    public void sendConfirmationSignal();

}
