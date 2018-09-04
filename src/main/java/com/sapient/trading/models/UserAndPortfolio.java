package com.sapient.trading.models;

public class UserAndPortfolio {
	String portfolio_id;
	String user_id;
	@Override
	public String toString() {
		return "Portfolios [portfolio_id=" + portfolio_id + ", user_id=" + user_id + "]";
	}
	public UserAndPortfolio(String portfolio_id, String user_id) {
		super();
		this.portfolio_id = portfolio_id;
		this.user_id = user_id;
	}
	public String getPortfolio_id() {
		return portfolio_id;
	}
	public void setPortfolio_id(String portfolio_id) {
		this.portfolio_id = portfolio_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((portfolio_id == null) ? 0 : portfolio_id.hashCode());
		result = prime * result + ((user_id == null) ? 0 : user_id.hashCode());
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
		UserAndPortfolio other = (UserAndPortfolio) obj;
		if (portfolio_id == null) {
			if (other.portfolio_id != null)
				return false;
		} else if (!portfolio_id.equals(other.portfolio_id))
			return false;
		if (user_id == null) {
			if (other.user_id != null)
				return false;
		} else if (!user_id.equals(other.user_id))
			return false;
		return true;
	}
	
}
