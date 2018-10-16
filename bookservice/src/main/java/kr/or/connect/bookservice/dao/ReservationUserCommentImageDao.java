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

import kr.or.connect.bookservice.dto.ReservationUserCommentImage;
@Repository
public class ReservationUserCommentImageDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<ReservationUserCommentImage> rowMapper = BeanPropertyRowMapper.newInstance(ReservationUserCommentImage.class);
	private String SELECT_PAGING = "SELECT id, reservation_info_id, reservation_user_comment_id, file_id FROM reservation_user_comment_image";
	private String DELETE_BY_ID = "DELETE FROM reservation_user_comment_image WHERE id = :id";

	public ReservationUserCommentImageDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("reservation_user_comment_image")
				.usingGeneratedKeyColumns("id");

	}

	public List<ReservationUserCommentImage> selectAll() {
//		Map<String, Integer> params = new HashMap<>();
//		params.put("start", start);
//		params.put("limit", limit);
		return jdbc.query(SELECT_PAGING, rowMapper);
	}

	public Long insert(ReservationUserCommentImage reservationUserCommentImage) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(reservationUserCommentImage);
		return insertAction.executeAndReturnKey(params).longValue();
	}

	public int deleteById(Long id) {
		Map<String, ?> params = Collections.singletonMap("id", id);
		return jdbc.update(DELETE_BY_ID, params);
	}


}
