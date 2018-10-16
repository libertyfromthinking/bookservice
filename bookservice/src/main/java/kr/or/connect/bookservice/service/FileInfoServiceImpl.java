package kr.or.connect.bookservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.connect.bookservice.dao.FileInfoDao;
import kr.or.connect.bookservice.dto.FileInfo;


@Service
public class FileInfoServiceImpl {
	@Autowired
	FileInfoDao fileInfoDao;

	
	public List<FileInfo> getFileInfo() {
		List<FileInfo> list = fileInfoDao.selectAll();
		return list;
	}
}
