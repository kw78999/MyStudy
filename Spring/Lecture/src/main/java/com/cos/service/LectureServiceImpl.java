package com.cos.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.cos.domain.LectureVO;
import com.cos.persistence.LectureDAO;

@Service
public class LectureServiceImpl implements LectureService{

	@Inject
	private LectureDAO dao;

	@Override
	public void insert(LectureVO lecture) throws Exception {
		dao.insert(lecture);
	}

	@Override
	public List<LectureVO> selectTitle(int ctNum) throws Exception {
		return dao.selectTitle(ctNum);
	}

	@Override
	public LectureVO selectMaxNum(int ctNum) throws Exception {
		return dao.selectMaxNum(ctNum);
	}
	
	@Override
	public LectureVO selectMinNum(int ctNum) throws Exception {
		return dao.selectMinNum(ctNum);
	}

	@Override
	public LectureVO select(int lcNum) throws Exception {
		return dao.select(lcNum);
	}

	@Override
	public void delete(int lcNum) throws Exception {
		dao.delete(lcNum);
	}

	@Override
	public void update(LectureVO lecture) throws Exception {
		dao.update(lecture);
	}

	@Override
	public void updateReadCount(int lcNum) throws Exception {
		dao.updateReadCount(lcNum);	
	}
}
