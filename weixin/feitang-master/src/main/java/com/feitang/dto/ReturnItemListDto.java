package com.feitang.dto;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.feitang.constant.ReturnCode;
import com.feitang.constant.ReturnCode.CodeTypeEnum;
import com.feitang.constant.ReturnCode.ModuleEnum;
import com.feitang.exception.LmsException;


public class ReturnItemListDto<T> {
	ModuleEnum module;
	CodeTypeEnum codeType;
	String code;
	String extra;
	List<T> items;
	
	public ReturnItemListDto(ReturnCode returnCode) {
		this.module = returnCode.getModule();
		this.codeType = returnCode.getCodeType();
		this.code = returnCode.getCode();
		this.extra = returnCode.getMessage();
	}

	public ReturnItemListDto(ReturnCode returnCode,String message) {
		this.module = returnCode.getModule();
		this.codeType = returnCode.getCodeType();
		this.code = returnCode.getCode();
		this.extra = message;
	}
	
	public ReturnItemListDto(ReturnCode returnCode,List<T> items) {
		this.module = returnCode.getModule();
		this.codeType = returnCode.getCodeType();
		this.code = returnCode.getCode();
		this.extra = returnCode.getMessage();
		this.items = items;
	}

	public ReturnItemListDto(ReturnCode returnCode, List<T> items, String message) {
		this.module = returnCode.getModule();
		this.codeType = returnCode.getCodeType();
		this.code = returnCode.getCode();
		this.extra = message;
		this.items = items;
	}

	public ReturnItemListDto(ReturnCode returnCode, Exception ex) {
		this.module = returnCode.getModule();
		this.codeType = returnCode.getCodeType();
		this.code = returnCode.getCode();
		this.extra = ex.getMessage();
		this.items = null;
		Logger logger = LoggerFactory.getLogger(getClass());
		logger.error("["+returnCode.getModule()+":"+returnCode.getCodeType()+":"+returnCode.getCode()+"]",ex);
	}

	public ReturnItemListDto(LmsException pex) {
		ReturnCode returnCode = pex.getReturnCode();
		if (returnCode!=null) {
			this.module = returnCode.getModule();
			this.codeType = returnCode.getCodeType();
			this.code = returnCode.getCode();
			this.extra = pex.getDetails();
		}
		else {
			this.extra = pex.getMessage();
		}
		this.items = null;
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

	public List<T> getItems() {
		return items;
	}

	public void setItems(List<T> items) {
		this.items = items;
	}
			
}
