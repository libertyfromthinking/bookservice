package kr.or.connect.bookservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.connect.bookservice.dao.ProductPriceDao;
import kr.or.connect.bookservice.dto.ProductPrice;

@Service
public class ProductPriceServiceImpl {
	@Autowired
	ProductPriceDao productPriceDao;
	
	public List<ProductPrice> getProductPrice(){
		List<ProductPrice> list = productPriceDao.selectAll();
		return list;
	}
}
