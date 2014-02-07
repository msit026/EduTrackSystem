package com.ets.classes;

import java.util.Random;

public final class PasswordGenerator {
	static final String AB = "A0B1C2D3E4F5G6H7I8J9K0L@M#N$O%P&QaRbScTdUeVfWgXhYiZj";
	static Random rnd = new Random();

	public String randomString( int len ) 
	{
	   StringBuilder sb = new StringBuilder( len );
	   for( int i = 0; i < len; i++ ) 
	      sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
	   return sb.toString();
	}
	
    public String generatedPasswordIs() 
    {
    	PasswordGenerator rg=new PasswordGenerator();
		String passw=rg.randomString(8);
		return passw;
    }

}