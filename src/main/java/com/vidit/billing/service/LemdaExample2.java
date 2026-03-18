package com.vidit.billing.service;

import java.util.List;

public class LemdaExample2 {

	public static void main(String[] args) {
		
		List<Integer> numbes = List.of(10,20,30,40,50);
	
		numbes.stream()
		.filter(n -> n > 10)
		.findFirst()
		.ifPresent(System.out::println);
		
	}
}
