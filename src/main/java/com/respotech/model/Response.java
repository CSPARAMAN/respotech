package com.respotech.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Response {
	@JsonProperty

	private String token;
	
	@JsonProperty 
	private int statuscode;
    @JsonProperty
    private String msg;
}
