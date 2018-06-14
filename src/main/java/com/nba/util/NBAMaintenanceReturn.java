package com.nba.util;

public class NBAMaintenanceReturn {
	private String result;
	private String message;
	public static final String SUCCESS="success";
	public static final String FAILURE="failure";
	
	public NBAMaintenanceReturn() {
		result = "Initialized result, not yet set.";
		message = "Initialized message, not yet set.";
	}
	public NBAMaintenanceReturn(String result, String message) {
		super();
		this.result = result;
		this.message = message;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public static NBAMaintenanceReturn getMaintReturn(Object obj) {
		NBAMaintenanceReturn r = new NBAMaintenanceReturn();
		if (obj!=null) {
			r.setResult(SUCCESS);
			r.setMessage(obj.getClass().getSimpleName()+" maintenance success");
		}
		else {
			r.setResult(FAILURE);
			// Can't use obj.getClass() because obj is null
			r.setMessage("Not found");
		}
		return r;

	}

	public static NBAMaintenanceReturn getMaintReturnError(Object obj, String msg) {
		NBAMaintenanceReturn r = new NBAMaintenanceReturn();
		String errMsg = "";
		r.setResult(FAILURE);
		if (obj!=null) {
			errMsg = (obj.getClass().getSimpleName()+" maintenance error: ");
		}
		else {
			errMsg = "Maintenance error: ";			
		}
		errMsg+=msg;
		r.setMessage(errMsg);
		return r;

	}

}
