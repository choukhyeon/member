package com.suflower.domain;

import lombok.Data;

@Data
public class ProductVO {
	
	private Long productId;
	private String productType;
	private String productName;
	private String productExplanation;
	private long productPrice;
}
