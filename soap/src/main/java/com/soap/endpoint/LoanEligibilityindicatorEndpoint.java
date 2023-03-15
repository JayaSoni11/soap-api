package com.soap.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.soap.service.LoanEligibilityService;
import com.soap.soap.Acknowledgement;
import com.soap.soap.CustomerRequest;

@Endpoint
public class LoanEligibilityindicatorEndpoint {

	private static final String NAMESPACE="http://soap.com/soap";
	@Autowired
	private LoanEligibilityService service;
	
	@PayloadRoot(namespace=NAMESPACE,localPart="CustomerRequest")
	@ResponsePayload
	public Acknowledgement getLoanStatus(@RequestPayload CustomerRequest request) {
		return service.checkLoanEligibility(request);		
	}
}
