package com.poc.banking.UserService.stripe.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.poc.banking.UserService.ApiTemplate;
import com.poc.banking.UserService.stripe.PaymentMethodAPI;
import com.poc.banking.UserService.stripe.PaymentMethodAPIResponse;
import com.poc.banking.UserService.stripe.PaymentMethodModel;

@Service
public class StripePaymentServiceImpl implements StripePaymentService {
	 private final Log log = LogFactory.getLog(getClass());
	@Override
	public PaymentMethodModel callPaymentmethodApi(Optional<Map<String, Object>> requestBody) {
		log.debug("@Ramesh payemntMethodAPI");
		// TODO Auto-generated method stub
		 RestTemplate restTemplate = new RestTemplate();
		  ApiTemplate<PaymentMethodAPIResponse> PaymentMethod = new PaymentMethodAPI(restTemplate);
		  PaymentMethodAPIResponse paymentMethodRespose = PaymentMethod.callApi();
		 List<PaymentMethodAPIResponse.Card> cards = paymentMethodRespose.getData().stream().map((pyamentMethod) -> pyamentMethod.getCard() ).toList();
		 PaymentMethodModel paymentMethodModel = new PaymentMethodModel();
		 paymentMethodModel.setCards(cards);
		return paymentMethodModel;
	}

}
