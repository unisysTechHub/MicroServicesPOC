package com.poc.banking.UserService.stripe.service;

import java.util.Map;
import java.util.Optional;

import com.poc.banking.UserService.stripe.PaymentMethodModel;

public interface StripePaymentService {

	PaymentMethodModel callPaymentmethodApi(Optional<Map<String, Object>> requestBody);
}
