package com.respotech.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class EventManagment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int eventId;
	private String eventType;
	private String desHeader;
	private String desTitle;
	private String img;
    private String img2;
    private String img3;
	private String desFirstLine;
	private String desSecondLine;
	private String desThirdLine;
	private String desFourthLine;
	

}
