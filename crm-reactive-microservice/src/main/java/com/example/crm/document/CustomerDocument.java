package com.example.crm.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customers")
public class CustomerDocument {
	@Id
	private String identity;
	private String fullName;
	private String email;
	private String sms;
	private String photo;

	public CustomerDocument() {
	}

	public final String getIdentity() {
		return identity;
	}

	public final void setIdentity(String identity) {
		this.identity = identity;
	}

	public final String getFullName() {
		return fullName;
	}

	public final void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public final String getEmail() {
		return email;
	}

	public final void setEmail(String email) {
		this.email = email;
	}

	public final String getSms() {
		return sms;
	}

	public final void setSms(String sms) {
		this.sms = sms;
	}

	public final String getPhoto() {
		return photo;
	}

	public final void setPhoto(String photo) {
		this.photo = photo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((identity == null) ? 0 : identity.hashCode());
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
		CustomerDocument other = (CustomerDocument) obj;
		if (identity == null) {
			if (other.identity != null)
				return false;
		} else if (!identity.equals(other.identity))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CustomerDocument [identity=" + identity + ", fullName=" + fullName + ", email=" + email + ", sms=" + sms
				+ "]";
	}

}
