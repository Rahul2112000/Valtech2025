package com.example.registerservicenetflix.vos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.example.registerservicenetflix.entities.Subscription;


public record SubscriptionVO(long id,int amount,String subscriptionStart,String subscriptionEnd) {
	public static final DateTimeFormatter FORMATTER=DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	public static SubscriptionVO from(Subscription sub) {
		String startDate=sub.getSubscriptionStart().format(FORMATTER);
		String endDate=sub.getSubscriptionEnd().format(FORMATTER);
		
		return new SubscriptionVO(sub.getId(),sub.getAmount(),startDate,endDate);
	
	}
	
	public Subscription to() {
		LocalDate start= LocalDate.parse(subscriptionStart, FORMATTER);
		LocalDate end= LocalDate.parse(subscriptionEnd, FORMATTER);
		return new Subscription(id,amount, start, end);
	}

}
