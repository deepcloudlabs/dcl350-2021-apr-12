package com.example.hr.domain;

import com.example.hr.ddd.Entity;

// Entity -> i) Identity ii) Mutable
// Domain Objects: Entity, Entity Root -> Aggregate, Value Object
@Entity(identity = "tcKimlikNo")
public class Employee {
	private TcKimlikNo tcKimlikNo;
	private FullName fullName;
	private Iban iban;
	private Money salary;
	private BirthYear birthYear;
	private Department department;
	private JobStyle jobStyle;
	private Photo photo;
}
