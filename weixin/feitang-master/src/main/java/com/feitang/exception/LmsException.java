package com.feitang.exception;

import java.text.MessageFormat;
import java.util.Random;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.feitang.constant.ReturnCode;

public class LmsException extends Exception {
	public static enum Type {
		SYSTEM("2001","system.exception"),
		BIZ("2002","biz.exception");

		private String code;
		private String value;

		private Type(String code, String value) {
			this.code = code;
			this.value = value;
		}
		
		public String getCode() {
			return code;
		}

		public String getValue() {
			return value;
		}
	}
	
	private static final long serialVersionUID = 1L;
	protected Logger logger = LogManager.getLogger(getClass());

	private ReturnCode returnCode;
	private String details=""; 

	
	public LmsException(ReturnCode returnCode) {
		super(new Throwable());
		this.returnCode = returnCode;
	}

	public LmsException(LmsException cause) {
		super(cause);
		this.returnCode = cause.getReturnCode();
		this.details = cause.getDetails();
	}

	public LmsException(ReturnCode returnCode, String details, Throwable cause) {
		super(cause);
		this.returnCode = returnCode;
		logMessage(details,cause);
	}

	public LmsException(ReturnCode returnCode, String details) {
		super(new Throwable());

		this.returnCode = returnCode;
		logMessage(details);
	}

	public LmsException(ReturnCode returnCode, Throwable cause) {
		super(cause);
		this.returnCode = returnCode;
		logMessage(cause);
	}


	public ReturnCode getReturnCode() {
		return returnCode;
	}

	public String getDetails() {
		return details;
	}
	
	private void logMessageUnchanged(String message) {
		Random rand = new Random();
		this.details = MessageFormat.format(message, String.valueOf(rand.nextInt(899999) + 100000)); 
		logger.fatal(this.details + ":" + message);
	}
	private void logMessage(String message) {
		Random rand = new Random();
		this.details = message; 
		logger.fatal(this.details + ":" + message);
	}
	private void logMessage(String message, Throwable cause) {
		Random rand = new Random();
		this.details = message; 
		logger.fatal(this.details + ":" + message, cause);
	}
	private void logMessage(Throwable cause) {
		Random rand = new Random();
		this.details = cause.getMessage(); 
		logger.fatal(cause.getMessage(),cause);
	}
}
