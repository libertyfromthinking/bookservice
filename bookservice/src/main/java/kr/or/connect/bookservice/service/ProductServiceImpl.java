package kr.or.connect.bookservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.connect.bookservice.dao.ProductDao;
import kr.or.connect.bookservice.dto.Product;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductDao productDao;
	
	@Override
	public List<Product> getProduct() {
		List<Product> list = productDao.selectAll();
		return list;
	}
	
	
	public List<Product> getCategory(Integer cn){
		List<Product> list = productDao.selectCategory(cn);
		return list;
	}

	@Override
	public int getCount() {
		return productDao.selectCount();
	}
}
