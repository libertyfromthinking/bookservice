package kr.or.connect.bookservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.connect.bookservice.dao.ProductImageDao;
import kr.or.connect.bookservice.dto.ProductImage;

@Service
public class ProductImageServiceImpl implements ProductImageService {
	@Autowired
	ProductImageDao productImageDao;
	
	@Override
	public List<ProductImage> getProduct() {
		List<ProductImage> list = productImageDao.selectAll();
		return list;
	}

}
