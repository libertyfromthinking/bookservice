package kr.or.connect.bookservice.service;

import java.util.List;

import kr.or.connect.bookservice.dto.Product;

public interface ProductService {
	public List<Product> getProduct();
	public int getCount();
	public List<Product> getCategory(Integer cn);
}
