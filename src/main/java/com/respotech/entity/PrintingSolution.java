package com.respotech.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class PrintingSolution {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int printingId;
	private String printingTitle;
	private String desHeader;
	private String desTitle;
	private String printingImg;
	private String printingImg2;
	private String printingImg3;
	private String desFirstLine;
	private String desSecondLine;
	private String desThirdLine;
	private String desFourthLine;
	private Long price;
	private Long mininumOrder;
}
