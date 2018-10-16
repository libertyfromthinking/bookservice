package kr.or.connect.bookservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.connect.bookservice.dao.DisplayInfoImageDao;
import kr.or.connect.bookservice.dto.DisplayInfoImage;

@Service
public class DisplayInfoImageServiceImpl {
@Autowired
DisplayInfoImageDao displayInfoImageDao;

public List<DisplayInfoImage> getDisplayInfoImages(){
	List<DisplayInfoImage> list = displayInfoImageDao.selectAll();
	return list;
	
}
}
