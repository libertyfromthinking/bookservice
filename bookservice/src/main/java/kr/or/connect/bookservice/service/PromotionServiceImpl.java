package kr.or.connect.bookservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.connect.bookservice.dao.PromotionDao;
import kr.or.connect.bookservice.dto.Promotion;

@Service
public class PromotionServiceImpl {
@Autowired
PromotionDao promotionDao;

public List<Promotion> getPromotions(){
	List<Promotion> list = promotionDao.selectAll();
	return list;
}
}
