package com.respotech.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.Data;

@Entity
@Data
public class SchoolSolution {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int batchId;
	private String schoolTitle;
	private String schoolType;
	private String desHeader;
	private String desTitle;
	private String schoolImg;
	private String schoolImg2;
	private String schoolImg3;
	private String desFirstLine;
	private String desSecondLine;
	private String desThirdLine;
	private String desFourthLine;
	private Long price;
	private Long mininumOrder;
	
	

}
