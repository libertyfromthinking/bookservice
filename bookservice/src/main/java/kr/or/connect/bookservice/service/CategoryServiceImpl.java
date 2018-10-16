package kr.or.connect.bookservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.connect.bookservice.dao.CategoryDao;
import kr.or.connect.bookservice.dto.Category;

@Service
public class CategoryServiceImpl {
	@Autowired
	CategoryDao categoryDao;

	
	public List<Category> getProduct() {
		List<Category> list = categoryDao.selectAll();
		return list;
	}
}
