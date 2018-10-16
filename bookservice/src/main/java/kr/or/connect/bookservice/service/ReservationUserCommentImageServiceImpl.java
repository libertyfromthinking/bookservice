package kr.or.connect.bookservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.bookservice.dao.ReservationUserCommentImageDao;
import kr.or.connect.bookservice.dto.ReservationUserCommentImage;

@Service
public class ReservationUserCommentImageServiceImpl {
	@Autowired
	ReservationUserCommentImageDao reservationUserCommentImageDao;

	@Transactional
	public List<ReservationUserCommentImage> getReservationUserCommentImage() {
		List<ReservationUserCommentImage> list = reservationUserCommentImageDao.selectAll();
		return list;
	}

	@Transactional(readOnly = false)
	public int deleteReservationUserCommentImage(Long id) {
		int deleteCount = reservationUserCommentImageDao.deleteById(id);
		return deleteCount;
	}

	@Transactional(readOnly = false)
	public ReservationUserCommentImage addReservationUserCommentImage(ReservationUserCommentImage reservationUserCommentImage) {
		reservationUserCommentImageDao.insert(reservationUserCommentImage);
		return reservationUserCommentImage;
	}

}
