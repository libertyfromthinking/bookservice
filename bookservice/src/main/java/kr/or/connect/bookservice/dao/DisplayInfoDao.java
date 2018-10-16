package kr.or.connect.bookservice.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.connect.bookservice.dto.DisplayInfo;

@Repository
public class DisplayInfoDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<DisplayInfo> rowMapper = BeanPropertyRowMapper.newInstance(DisplayInfo.class);
	private String SELECT_PAGING = "SELECT id, product_id, opening_hours, place_name, place_lot, place_street, tel, homepage, email, create_date, modify_date FROM display_info";

	public DisplayInfoDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("display_info").usingGeneratedKeyColumns("id");

	}

	public List<DisplayInfo> selectAll() {
//		Map<String, Integer> params = new HashMap<>();
//		params.put("start", start);
//		params.put("limit", limit);
		return jdbc.query(SELECT_PAGING, rowMapper);
	}

}
