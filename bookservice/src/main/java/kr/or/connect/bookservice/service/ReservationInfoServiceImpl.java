package kr.or.connect.bookservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.bookservice.dao.ReservationInfoDao;
import kr.or.connect.bookservice.dto.ReservationInfo;
@Service
public class ReservationInfoServiceImpl {

	@Autowired
	ReservationInfoDao reservationInfoDao;

	@Transactional
	public List<ReservationInfo> getReservationInfo() {
		List<ReservationInfo> list = reservationInfoDao.selectAll();
		return list;
	}

	@Transactional(readOnly = false)
	public int deleteReservationInfo(Long id) {
		int deleteCount = reservationInfoDao.deleteById(id);
		return deleteCount;
	}

	@Transactional(readOnly = false)
	public ReservationInfo addReservationInfo(ReservationInfo reservationInfo) {
		reservationInfoDao.insert(reservationInfo);
		return reservationInfo;
	}

}
