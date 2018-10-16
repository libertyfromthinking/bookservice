package kr.or.connect.bookservice.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.connect.bookservice.dto.DisplayInfoImage;

@Repository
public class DisplayInfoImageDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<DisplayInfoImage> rowMapper = BeanPropertyRowMapper.newInstance(DisplayInfoImage.class);
	private String SELECT_PAGING = "SELECT id, display_info_id, file_id FROM display_info_image";

	public DisplayInfoImageDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("display_info_image").usingGeneratedKeyColumns("id");

	}

	public List<DisplayInfoImage> selectAll() {
//		Map<String, Integer> params = new HashMap<>();
//		params.put("start", start);
//		params.put("limit", limit);
		return jdbc.query(SELECT_PAGING, rowMapper);
	}
}
