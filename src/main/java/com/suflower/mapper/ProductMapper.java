package com.suflower.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.suflower.domain.ProductVO;

public interface ProductMapper {
	@Select("select * from product where productId > 0")
	public List<ProductVO> productList();
}
