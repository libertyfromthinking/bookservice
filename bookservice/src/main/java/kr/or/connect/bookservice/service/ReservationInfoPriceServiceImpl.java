package kr.or.connect.bookservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.bookservice.dao.ReservationInfoPriceDao;
import kr.or.connect.bookservice.dto.ReservationInfoPrice;

@Service
public class ReservationInfoPriceServiceImpl {
	
	@Autowired
	ReservationInfoPriceDao reservationInfoPriceDao;

	@Transactional
	public List<ReservationInfoPrice> getReservationInfoPrice() {
		List<ReservationInfoPrice> list = reservationInfoPriceDao.selectAll();
		return list;
	}

	@Transactional(readOnly = false)
	public int deleteReservationInfoPrice(Long id) {
		int deleteCount = reservationInfoPriceDao.deleteById(id);
		return deleteCount;
	}

	@Transactional(readOnly = false)
	public ReservationInfoPrice addReservationInfoPrice(ReservationInfoPrice reservationInfoPrice) {
		reservationInfoPriceDao.insert(reservationInfoPrice);
		return reservationInfoPrice;
	}
}
