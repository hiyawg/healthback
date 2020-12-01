package com.HospitalMangagmentSystem.demo.Exception;

import java.util.Date;

import lombok.Data;
import lombok.experimental.SuperBuilder;
@Data
@SuperBuilder
public class ErrorMessage {
	protected String detail;
    protected Date taimesmap;
    protected String message;
    protected String title;
    protected int status;
    
   	public ErrorMessage(String detail, Date taimesmap, String message, String title, int status) {
		this.detail = detail;
		this.taimesmap = taimesmap;
		this.message = message;
		this.title = title;
		this.status = status;
		
		
	}

	}
    
    



