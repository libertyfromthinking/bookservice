package kr.or.connect.bookservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.connect.bookservice.dto.Category;
import kr.or.connect.bookservice.dto.FileInfo;
import kr.or.connect.bookservice.dto.Product;
import kr.or.connect.bookservice.dto.ProductImage;
import kr.or.connect.bookservice.service.CategoryServiceImpl;
import kr.or.connect.bookservice.service.FileInfoServiceImpl;
import kr.or.connect.bookservice.service.ProductImageService;
import kr.or.connect.bookservice.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	ProductService productService;
	@Autowired
	ProductImageService productImageService;
	@Autowired
	CategoryServiceImpl categoryServiceImpl;
	@Autowired
	FileInfoServiceImpl fileInfoServiceImpl;
	
	
	@RequestMapping(value="/products", method=RequestMethod.GET)
	public String products(Model model) {
		int count = productService.getCount(); 
		System.out.println("요청이 들어왔습니다");
		List<Product> product = productService.getProduct();
		List<ProductImage> productImage = productImageService.getProduct();
		List<Category> category = categoryServiceImpl.getProduct();
		List<FileInfo> fileInfo = fileInfoServiceImpl.getFileInfo();
		model.addAttribute("product",product);
		model.addAttribute("productImage",productImage);
		model.addAttribute("category",category);
		model.addAttribute("count",count);
		model.addAttribute("fileInfo",fileInfo);
		System.out.println("요청을 리턴했습니다");
		return "products";
	}
}
