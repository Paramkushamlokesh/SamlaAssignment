package com.samla.model;

import java.util.Date;
import java.sql.Timestamp;

import lombok.Data;
@Data
public class ExceptionResponse {
	String msg;
	Timestamp timestamp;
	String path;
	public ExceptionResponse(String msg, String path) {
		this.msg = msg;
		this.timestamp = new Timestamp(new Date().getTime());
		this.path = path;
	}
	
}
