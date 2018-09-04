package com.sapient.trading.models;

import org.mindrot.jbcrypt.BCrypt;

public class EncryptedPass  {
	
	public String hashPassword(String plainTextPassword){
		String password = BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
		System.out.println("login" + password);
		return password;
	}

	public boolean checkPass(String plainPassword, String hashedPassword) {
		if (BCrypt.checkpw(plainPassword, hashedPassword))
			return true;
		else
			return false;
	}
}
	