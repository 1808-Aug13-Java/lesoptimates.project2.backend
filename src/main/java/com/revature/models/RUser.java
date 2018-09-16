package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table
public class RUser {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="userIdSequence")
	@SequenceGenerator(name="userIdSequence", allocationSize=1, sequenceName="SQ_USERID_PK")
	@Column(name="USER_ID")
	private int userId;
	
	@Column(name="USER_NAME")
	private String uName;
	@Column(name="name")
	private String name;
	@Column(name="email")
	private String email;
	@Column(name="PSWD")
	private String pswd;
	@Column(name="IS_CHEF")
	private int isChef;
	
	//@Transient
		@ManyToOne
		@JoinColumn(name="RECIPE_ID")
		private Recipe recipe;

	public RUser() {
		super();
	}

	public int getUserId() {
		return userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPswd() {
		return pswd;
	}

	public void setPswd(String pswd) {
		this.pswd = pswd;
	}

	public int getIsChef() {
		return isChef;
	}

	public void setIsChef(int isChef) {
		this.isChef = isChef;
	}

	public Recipe getrecipe() {
		return recipe;
	}

	public void setrecipe(Recipe recipe) {
		this.recipe = recipe;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + isChef;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((pswd == null) ? 0 : pswd.hashCode());
		result = prime * result + ((recipe == null) ? 0 : recipe.hashCode());
		result = prime * result + ((uName == null) ? 0 : uName.hashCode());
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
		if (!(obj instanceof RUser)) {
			return false;
		}
		RUser other = (RUser) obj;
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
		if (pswd == null) {
			if (other.pswd != null) {
				return false;
			}
		} else if (!pswd.equals(other.pswd)) {
			return false;
		}
		if (recipe == null) {
			if (other.recipe != null) {
				return false;
			}
		} else if (!recipe.equals(other.recipe)) {
			return false;
		}
		if (uName == null) {
			if (other.uName != null) {
				return false;
			}
		} else if (!uName.equals(other.uName)) {
			return false;
		}
		if (userId != other.userId) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "RUser [userId=" + userId + ", uName=" + uName + ", name=" + name + ", email=" + email + ", pswd=" + pswd
				+ ", isChef=" + isChef + ", recipe=" + recipe + "]";
	}

	

	
}