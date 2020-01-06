package br.com.feedev.jdt.util;

import java.util.Properties;

public class Constants {

	public static final String MAIL_JDT_DEFAULT_USERNAME = "feedev.jdt@gmail.com";
	public static final String MAIL_JDT_DEFAULT_PASSWORD = "@jdt12345678";
	public static Properties MAIL_JDT_DEFAULT_PROPERTIES = new Properties();
	
	static {

		MAIL_JDT_DEFAULT_PROPERTIES.put("mail.smtp.auth", "true"); // autorização
		MAIL_JDT_DEFAULT_PROPERTIES.put("mail.smtp.starttls", "true"); // autenticacao
		MAIL_JDT_DEFAULT_PROPERTIES.put("mail.smtp.host", "smtp.gmail.com"); // servidor gmail google
		MAIL_JDT_DEFAULT_PROPERTIES.put("mail.smtp.port", "465"); // porta do servidor
		MAIL_JDT_DEFAULT_PROPERTIES.put("mail.smtp.socketFactory.port", "465"); // porta do socket
		MAIL_JDT_DEFAULT_PROPERTIES.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); // classe socket de conexão ao SMTP
	}

}
