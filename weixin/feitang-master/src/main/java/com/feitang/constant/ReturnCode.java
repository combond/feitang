package com.feitang.constant;


public enum ReturnCode {

	N_APP(ModuleEnum.APPLICATION, CodeTypeEnum.INFO, "000", ""),
	N_APP_FAIL(ModuleEnum.APPLICATION, CodeTypeEnum.ERROR, "001", "Application Fail"),
	N_APP_NEED_LOGIN(ModuleEnum.APPLICATION, CodeTypeEnum.ERROR, "002", "Please Login"),
	N_APP_NEED_UPGRADE(ModuleEnum.APPLICATION, CodeTypeEnum.ERROR, "003", "Please Upgrade"),
	F_SERVICE(ModuleEnum.SERVICE, CodeTypeEnum.FATAL, "004", "System Error"),
	E_SERVICE(ModuleEnum.SERVICE, CodeTypeEnum.ERROR, "007", "System Error"),
	E_DAL(ModuleEnum.DAL, CodeTypeEnum.ERROR, "008", "System Error"),
	E_CONTROLLER( ModuleEnum.CONTROLLER, CodeTypeEnum.ERROR,"006", "System Error"),
	E_POS( ModuleEnum.APPLICATION, CodeTypeEnum.ERROR,"005", "System Error"), 
	E_SESSION(ModuleEnum.USER, CodeTypeEnum.ERROR, "010", "Application Error");
	
	ModuleEnum module;
	CodeTypeEnum codeType;
	String code;
	String message;

	private ReturnCode(ModuleEnum module, CodeTypeEnum codeType, String code, String message) {
		this.module = module;
		this.codeType = codeType;
		this.code = code;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
	public ModuleEnum getModule() {
		return module;
	}

	public CodeTypeEnum getCodeType() {
		return codeType;
	}

	public String getCode() {
		return code;
	}

	public enum CodeTypeEnum {
		INFO("I"), ERROR("E"), FATAL("F");
		String value;
		private CodeTypeEnum(String value) {
			this.value = value;
		}
	}

	public enum ModuleEnum {
		APPLICATION("APP"),
		CONTROLLER("CTL"),
		SERVICE("SRV"),
		DAL("DAL"),
		TASK("TSK"),
		ARTICLE("ART"),
		ORDER("ORD"),
		FORECAST("FOR"),
		SCHEDULE("SCH"),
		USER("USR");
		

		String value;

		private ModuleEnum(String value) {
			this.value = value;
		}
	}

	@Override
	public String toString() {
		return codeType.value + "-" + module.value + "-" + code + " " + message;
	}
}
