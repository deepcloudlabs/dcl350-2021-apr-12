package com.example.hr.example;

public class ImmutableClass {
   // -Djava.lang.Integer.IntegerCache.high=2048
	public static void main(String[] args) {
		Integer i = Integer.valueOf(42); // auto-boxing
		Integer j = 42;
		Integer x = 549;
		Integer y = 549;
		System.out.println("i==j? : "+(i==j));
		System.out.println("x==y? : "+(x==y));

	}

}
