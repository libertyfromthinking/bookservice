package kr.or.connect.bookservice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.connect.bookservice.dto.Category;
import kr.or.connect.bookservice.dto.FileInfo;
import kr.or.connect.bookservice.dto.Product;
import kr.or.connect.bookservice.dto.ProductImage;
import kr.or.connect.bookservice.service.CategoryServiceImpl;
import kr.or.connect.bookservice.service.FileInfoServiceImpl;
import kr.or.connect.bookservice.service.ProductImageService;
import kr.or.connect.bookservice.service.ProductService;

import com.google.gson.Gson;

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

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String products(Model model) {
		int count = productService.getCount();
		System.out.println("요청이 들어왔습니다");
		List<Product> product = productService.getProduct();
		List<ProductImage> productImage = productImageService.getProduct();
		List<Category> category = categoryServiceImpl.getProduct();
		List<FileInfo> fileInfo = fileInfoServiceImpl.getFileInfo();
		model.addAttribute("product", product);
		model.addAttribute("productImage", productImage);
		model.addAttribute("category", category);
		model.addAttribute("count", count);
		model.addAttribute("fileInfo", fileInfo);
		System.out.println("요청을 리턴했습니다");
		return "products";
	}

	@RequestMapping(value = "/category", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public void category(@RequestParam(value = "cn", required = false, defaultValue = "0") int cn, Model model,
			HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("utf-8");
		
		System.out.println("카테고리 요청이 들어왔습니다");
		List<Product> product;
		if(cn==0) {
			product = productService.getProduct();
		}else {
			product = productService.getCategory(cn);
		}
		List<ProductImage> productImage = productImageService.getProduct();
		JSONArray jArray = new JSONArray();// 배열이 필요할때
		JSONArray jArray2 = new JSONArray();// 배열이 필요할때
		
		for (int i = 0; i < product.size(); i++)// 배열
		{
			JSONObject sObject = new JSONObject();// 배열 내에 들어갈 json
			sObject.put("id", product.get(i).getId());
			sObject.put("categoryId", product.get(i).getCategoryId());
			sObject.put("description", product.get(i).getDescription());
			sObject.put("content", product.get(i).getContent());
			
			
			jArray.add(sObject);
		}
		for (int i = 0; i < productImage.size(); i++)// 배열
		{		
			JSONObject sObject2 = new JSONObject();// 배열 내에 들어갈 json
			sObject2.put("productImageId", productImage.get(i).getId());
			sObject2.put("productId", productImage.get(i).getProductId());
			sObject2.put("type", productImage.get(i).getType());
			jArray.add(sObject2);
		}

		response.getWriter().print(jArray);
//		response.getWriter().print(jArray2);

		System.out.println("카테고리 요청을 리턴했습니다");
		

	}
}
