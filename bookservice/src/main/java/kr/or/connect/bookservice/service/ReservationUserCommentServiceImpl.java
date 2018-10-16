package kr.or.connect.bookservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.bookservice.dao.ReservationUserCommentDao;
import kr.or.connect.bookservice.dto.ReservationUserComment;

@Service
public class ReservationUserCommentServiceImpl {
	@Autowired
	ReservationUserCommentDao reservationUserCommentDao;

	@Transactional
	public List<ReservationUserComment> getReservationUserComment() {
		List<ReservationUserComment> list = reservationUserCommentDao.selectAll();
		return list;
	}

	@Transactional(readOnly = false)
	public int deleteReservationUserComment(Long id) {
		int deleteCount = reservationUserCommentDao.deleteById(id);
		return deleteCount;
	}

	@Transactional(readOnly = false)
	public ReservationUserComment addReservationUserComment(ReservationUserComment reservationUserComment) {
		reservationUserCommentDao.insert(reservationUserComment);
		return reservationUserComment;
	}
}
