package com.it.util;

import com.it.entity.User;

public final class UtilApp {
	private User user;
	private static UtilApp instance;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	public static UtilApp getInstance() {
		if (instance == null) {
			instance = new UtilApp();
		}
		return instance;
	}

	
}
