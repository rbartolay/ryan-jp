package com.ryan.beans;

import com.ryan.core.bom.Crypt;

public class Users {
	public long user_id;
	public String email;
	public String password;

	public Users() {
		super();
	}
	public Users(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	public Users(long user_id, String email, String password) {
		super();
		this.user_id = user_id;
		this.email = email;
		this.password = password;
	}
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean validateLogin(String password) {
		return this.getPassword().equals(Crypt.md5(password));
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (user_id ^ (user_id >>> 32));
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
		Users other = (Users) obj;
		if (user_id != other.user_id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Users [user_id=" + user_id + ", email=" + email
				+ ", password=" + password + "]";
	}
}
