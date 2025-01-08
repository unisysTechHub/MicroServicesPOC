package com.poc.banking.UserService.stripe;

import java.util.List;

public class PaymentMethodModel {
   List<PaymentMethodAPIResponse.Card> cards;

public List<PaymentMethodAPIResponse.Card> getCards() {
	return cards;
}

public void setCards(List<PaymentMethodAPIResponse.Card> cards) {
	this.cards = cards;
}
   
   
}
