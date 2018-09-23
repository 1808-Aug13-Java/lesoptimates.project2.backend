package com.lesopt.foodfinder.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class User {
  public static final Integer IS_NOT_CHEF = 0; //more descriptive than TRUE 
  public static final Integer IS_CHEF = 1;    // or FALSE
  
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId; //int cannot be passed as a Generic Type argument (for extending CrudRepository)
	private String username;
	private String name;
	private String email;
	private String passw;
	private Integer isChef; //Integer, for consistency

	public User() {
	}
  
  public User(String username, String name, String email, String passw, Integer isChef) {
    this.username = username;
    this.name = name;
    this.email = email;
    this.passw = passw;
    this.isChef = isChef;
  }

	public Integer getUserId() {
		return userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassw() {
		return passw;
	}

	public void setPassw(String passw) {
		this.passw = passw;
	}

	public Integer getIsChef() {
		return isChef;
	}

	public void setIsChef(Integer isChef) {
		this.isChef = isChef;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + isChef;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((passw == null) ? 0 : passw.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		result = prime * result + userId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof User)) {
			return false;
		}
		User other = (User) obj;
		if (email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!email.equals(other.email)) {
			return false;
		}
		if (isChef != other.isChef) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (passw == null) {
			if (other.passw != null) {
				return false;
			}
		} else if (!passw.equals(other.passw)) {
			return false;
		}
		if (username == null) {
			if (other.username != null) {
				return false;
			}
		} else if (!username.equals(other.username)) {
			return false;
		}
		if (userId != other.userId) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", " + (username != null ? "username=" + username + ", " : "")
				 + "isChef=" + isChef + "]";
	}


}
