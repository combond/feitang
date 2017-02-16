package com.feitang.dto;

import com.feitang.constant.ReturnCode;
import com.feitang.constant.ReturnCode.CodeTypeEnum;
import com.feitang.constant.ReturnCode.ModuleEnum;
import com.feitang.exception.LmsException;

public class ReturnItemDto<T>  {
	ModuleEnum module;
	CodeTypeEnum codeType;
	String code;
	String extra;
	Boolean state = false;
	T item;

	public ReturnItemDto(ReturnCode returnCode) {
		this.module = returnCode.getModule();
		this.codeType = returnCode.getCodeType();
		this.code = returnCode.getCode();
		this.extra = returnCode.getMessage();
		if ("000".equals(code)) state = true;
	}

	public ReturnItemDto(ReturnCode returnCode,String message) {
		this.module = returnCode.getModule();
		this.codeType = returnCode.getCodeType();
		this.code = returnCode.getCode();
		this.extra = message;
		if ("000".equals(code)) state = true;
	}
	
	
	public ReturnItemDto(ReturnCode returnCode,T item) {
		this.module = returnCode.getModule();
		this.codeType = returnCode.getCodeType();
		this.code = returnCode.getCode();
		this.extra = returnCode.getMessage();
		this.item = item;
		if ("000".equals(code)) state = true;
	}
	
	public ReturnItemDto(ReturnCode returnCode, String message, T item) {
		this.module = returnCode.getModule();
		this.codeType = returnCode.getCodeType();
		this.code = returnCode.getCode();
		this.extra = message;
		this.item = item;
		if ("000".equals(code)) state = true;
	}

	public ReturnItemDto(ReturnCode returnCode, Exception ex) {
		LmsException pe = new LmsException(returnCode,ex);
		this.module = returnCode.getModule();
		this.codeType = returnCode.getCodeType();
		this.code = returnCode.getCode();
		this.extra = pe.getDetails();
		this.item = null;
		if ("000".equals(code)) state = true;
		/*
	    Marker fatal = MarkerFactory.getMarker("FATAL");
		Logger logger = LoggerFactory.getLogger(getClass());
		logger.error(fatal, "["+returnCode.getModule()+":"+returnCode.getCodeType()+":"+returnCode.getCode()+"]",ex);
		*/
	}

	public ReturnItemDto(LmsException pex) {
		ReturnCode returnCode = pex.getReturnCode();
//		String logMsg="";
		if (returnCode!=null) {
			this.module = returnCode.getModule();
			this.codeType = returnCode.getCodeType();
			this.code = returnCode.getCode();
			this.extra = pex.getDetails();
			if ("000".equals(code)) state = true;
//			logMsg = "["+returnCode.getModule()+":"+returnCode.getCodeType()+":"+returnCode.getCode()+"]";
		}
		else {
			this.extra = pex.getMessage();
		}
		this.item = null;
// error should be logged at lower level, no need to log again		
//		logger.error(logMsg,pex);
	}

	public ReturnItemDto(LmsException pex, T message) {
		ReturnCode returnCode = pex.getReturnCode();
		if (returnCode!=null) {
			this.module = returnCode.getModule();
			this.codeType = returnCode.getCodeType();
			this.code = returnCode.getCode();
			this.extra = pex.getDetails();
			if ("000".equals(code)) state = true;
		}
		else {
			this.extra = pex.getMessage();
		}
		this.item = message;
	}

	public ModuleEnum getModule() {
		return module;
	}

	public void setModule(ModuleEnum module) {
		this.module = module;
	}

	public CodeTypeEnum getCodeType() {
		return codeType;
	}

	public void setCodeType(CodeTypeEnum codeType) {
		this.codeType = codeType;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return extra;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}

	public T getItem() {
		return item;
	}

	public void setItem(T item) {
		this.item = item;
	}
			
}
