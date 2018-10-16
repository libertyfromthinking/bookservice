package kr.or.connect.bookservice.dto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.connect.bookservice.dao.DisplayInfoDao;

@Service
public class DisplayInfoServiceImpl {
@Autowired
DisplayInfoDao displayInfoDao;

public List<DisplayInfo> getDisplayInfo(){
	List<DisplayInfo> list = displayInfoDao.selectAll();
	return list;
}

}
