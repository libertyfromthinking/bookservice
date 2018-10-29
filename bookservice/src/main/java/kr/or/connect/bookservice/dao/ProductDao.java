package kr.or.connect.bookservice.dao;



import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.connect.bookservice.dto.Product;

@Repository
public class ProductDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<Product> rowMapper = BeanPropertyRowMapper.newInstance(Product.class);
	private String SELECT_PAGING = "SELECT id, category_id, description, content, event, create_date, modify_date FROM product";
	private String SELECT_COUNT = "SELECT count(*) FROM product";
	private String SELECT_CATEGORY = "SELECT id, category_id, description, content, event, create_date, modify_date FROM product WHERE category_id = :cn"; 
	
	public ProductDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("product").usingGeneratedKeyColumns("id");

	}
	
	public List<Product> selectAll() {
//		Map<String, Integer> params = new HashMap<>();
//		params.put("start", start);
//		params.put("limit", limit);
		return jdbc.query(SELECT_PAGING, rowMapper);
	}
	
	public List<Product> selectCategory(Integer cn) {
		Map<String, Integer> params = new HashMap<>();
		params.put("cn", cn);
		return jdbc.query(SELECT_CATEGORY, params, rowMapper);
	}
	
	public int selectCount() {
		return jdbc.queryForObject(SELECT_COUNT, Collections.emptyMap(), Integer.class);
	}

}
