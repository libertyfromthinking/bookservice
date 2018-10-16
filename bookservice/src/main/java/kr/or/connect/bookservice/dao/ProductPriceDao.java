package kr.or.connect.bookservice.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.connect.bookservice.dto.ProductPrice;

@Repository
public class ProductPriceDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<ProductPrice> rowMapper = BeanPropertyRowMapper.newInstance(ProductPrice.class);
	private String SELECT_PAGING = "SELECT id, product_id, price_type_name, price, discount_rate, create_date, modify_date FROM product_price";

	public ProductPriceDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("product_price").usingGeneratedKeyColumns("id");

	}

	public List<ProductPrice> selectAll() {
//		Map<String, Integer> params = new HashMap<>();
//		params.put("start", start);
//		params.put("limit", limit);
		return jdbc.query(SELECT_PAGING, rowMapper);
	}

}
