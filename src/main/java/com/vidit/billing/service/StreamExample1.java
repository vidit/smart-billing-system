package com.vidit.billing.service;

import java.util.ArrayList;
import java.util.List;

public class StreamExample1 {

	public static void main(String[] args) {

		List<String> names = new ArrayList<>();
		names.add("Rahul");
		names.add("Ratan");
		names.add("Ramlala");
		names.add("Shinku");
		names.add("Ji");
		names.add("Maharaj");
		
		names.stream()
		.forEach(name -> System.out.println(name));
	}
}
