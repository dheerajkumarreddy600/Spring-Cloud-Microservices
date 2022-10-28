package com.cloud.ps.api.service;

import com.cloud.ps.api.entity.Payment;
import com.cloud.ps.api.repository.PaymentRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository repository;

	Logger logger = LoggerFactory.getLogger(PaymentService.class);

	public Payment doPayment(Payment payment) throws JsonProcessingException {
		payment.setPaymentStatus(paymentProcessing());
		payment.setTransactionId(UUID.randomUUID().toString());

		return repository.save(payment);
	}

	public String paymentProcessing() {
		return new Random().nextBoolean() ? "success" : "false";
	}

	public Payment findPaymentHistoryByOrderId(int orderId) throws JsonProcessingException {
		Payment payment = repository.findByOrderId(orderId);
		return payment;
	}
}
