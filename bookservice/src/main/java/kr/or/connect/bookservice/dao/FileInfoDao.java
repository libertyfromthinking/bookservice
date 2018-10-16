package kr.or.connect.bookservice.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.connect.bookservice.dto.FileInfo;

@Repository
public class FileInfoDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<FileInfo> rowMapper = BeanPropertyRowMapper.newInstance(FileInfo.class);
	private String SELECT_PAGING = "SELECT id, file_name, save_file_name, content_type, delete_flag, create_date, modify_date FROM file_info";

	public FileInfoDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		

	}

	public List<FileInfo> selectAll() {
//		Map<String, Integer> params = new HashMap<>();
//		params.put("start", start);
//		params.put("limit", limit);
		return jdbc.query(SELECT_PAGING, rowMapper);
	}

}
