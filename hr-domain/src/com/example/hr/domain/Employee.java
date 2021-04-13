package com.example.hr.domain;

import com.example.hr.ddd.Entity;

// Entity -> i) Identity ii) Mutable Class
// Domain Objects: Entity, Entity Root -> Aggregate, Value Object
// Ubiquitous Language, Bounded Context
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

	public Employee(TcKimlikNo tcKimlikNo, FullName fullName, BirthYear birthYear) {
		this.tcKimlikNo = tcKimlikNo;
		this.fullName = fullName;
		this.birthYear = birthYear;
	}

	// Builder
	
	public FullName getFullName() {
		return fullName;
	}

	public void setFullName(FullName fullName) {
		this.fullName = fullName;
	}

	public Iban getIban() {
		return iban;
	}

	public void setIban(Iban iban) {
		this.iban = iban;
	}

	public Money getSalary() {
		return salary;
	}

	public void setSalary(Money salary) {
		this.salary = salary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public JobStyle getJobStyle() {
		return jobStyle;
	}

	public void setJobStyle(JobStyle jobStyle) {
		this.jobStyle = jobStyle;
	}

	public Photo getPhoto() {
		return photo;
	}

	public void setPhoto(Photo photo) {
		this.photo = photo;
	}

	public TcKimlikNo getTcKimlikNo() {
		return tcKimlikNo;
	}

	public BirthYear getBirthYear() {
		return birthYear;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tcKimlikNo == null) ? 0 : tcKimlikNo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (tcKimlikNo == null) {
			if (other.tcKimlikNo != null)
				return false;
		} else if (!tcKimlikNo.equals(other.tcKimlikNo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [tcKimlikNo=" + tcKimlikNo + ", fullName=" + fullName + ", iban=" + iban + ", salary=" + salary
				+ ", birthYear=" + birthYear + ", department=" + department + ", jobStyle=" + jobStyle + "]";
	}

}
