package com.respotech.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class PropertySolution {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int propertyId;
	private String desHeader;
	private String desTitle;
    private String location;
    private String img;
    private String img2;
    private String img3;
    private String desFirstLine;
	private String desSecondLine;
	private String desThirdLine;
	private String desFourthLine;
    private String plotArea;
    private Long price;
    private String propertyType;
}
