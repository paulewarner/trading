package com.sapient.trading.repos;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import com.sapient.trading.models.Authority;
import com.sapient.trading.models.User;

@Component
@Scope(value = "session",  proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserSession {
	
	private Authority authorities;

	public Authority getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Authority authorities) {
		this.authorities = authorities;
	}

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
