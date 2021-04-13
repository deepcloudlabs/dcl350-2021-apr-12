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

	public Employee(Builder builder) {
		this.tcKimlikNo = builder.tcKimlikNo;
		this.fullName = builder.fullName;
		this.iban = builder.iban;
		this.salary = builder.salary;
		this.birthYear = builder.birthYear;
		this.department = builder.department;
		this.jobStyle = builder.jobStyle;
		this.photo = builder.photo;
	}

	// Builder: DSL -> Flow API -> Method Chain
	public static class Builder {
		private TcKimlikNo tcKimlikNo;
		private FullName fullName;
		private Iban iban;
		private Money salary;
		private BirthYear birthYear;
		private Department department;
		private JobStyle jobStyle;
		private Photo photo;

		public Builder(TcKimlikNo tcKimlikNo) {
			this.tcKimlikNo = tcKimlikNo;
		}

		public Builder fullname(String firstName, String lastName) {
			this.fullName = FullName.of(firstName, lastName);
			return this;
		}

		public Builder iban(String value) {
			this.iban = Iban.valueOf(value);
			return this;
		}

		public Builder salary(double value, FiatCurrency currency) {
			this.salary = Money.of(value, currency);
			return this;
		}

		public Builder salary(double value) {
			return salary(value, FiatCurrency.TL);
		}

		public Builder department(String department) {
			this.department = Department.valueOf(department);
			return this;
		}

		public Builder birthYear(int value) {
			this.birthYear = BirthYear.of(value);
			return this;
		}

		public Builder jobStyle(String style) {
			this.jobStyle = JobStyle.valueOf(style);
			return this;
		}

		public Builder photo(byte[] data) {
			this.photo = Photo.valueOf(data);
			return this;
		}

		public Builder photo(String data) {
			this.photo = Photo.valueOf(data);
			return this;
		}

		public Employee build() {
			// validation
			// business rule
			return new Employee(this);
		}
	}

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
