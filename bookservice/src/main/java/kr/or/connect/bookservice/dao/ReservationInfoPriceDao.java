package kr.or.connect.bookservice.dao;



import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.connect.bookservice.dto.ReservationInfoPrice;

@Repository
public class ReservationInfoPriceDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<ReservationInfoPrice> rowMapper = BeanPropertyRowMapper.newInstance(ReservationInfoPrice.class);
	private String SELECT_PAGING = "SELECT id, reservation_info_id, product_price_id, count FROM reservation_info_price";
	private String DELETE_BY_ID = "DELETE FROM reservation_info_id WHERE id = :id";

	public ReservationInfoPriceDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("reservation_info_price")
				.usingGeneratedKeyColumns("id");

	}

	public List<ReservationInfoPrice> selectAll() {
//		Map<String, Integer> params = new HashMap<>();
//		params.put("start", start);
//		params.put("limit", limit);
		return jdbc.query(SELECT_PAGING, rowMapper);
	}

	public Long insert(ReservationInfoPrice reservationInfoPrice) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(reservationInfoPrice);
		return insertAction.executeAndReturnKey(params).longValue();
	}

	public int deleteById(Long id) {
		Map<String, ?> params = Collections.singletonMap("id", id);
		return jdbc.update(DELETE_BY_ID, params);
	}
}
