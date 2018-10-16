package kr.or.connect.bookservice.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.connect.bookservice.dto.ProductImage;

@Repository
public class ProductImageDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<ProductImage> rowMapper = BeanPropertyRowMapper.newInstance(ProductImage.class);
	private String SELECT_PAGING = "SELECT id, product_id, type, file_id FROM product_image";
//	private String SELECT_COUNT = "SELECT count(*) FROM product";
	
	public ProductImageDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("product_image").usingGeneratedKeyColumns("id");

	}
	
	public List<ProductImage> selectAll() {
//		Map<String, Integer> params = new HashMap<>();
//		params.put("start", start);
//		params.put("limit", limit);
		return jdbc.query(SELECT_PAGING, rowMapper);
	}
}
