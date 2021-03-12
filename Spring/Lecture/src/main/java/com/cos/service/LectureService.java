package com.cos.service;

import java.util.List;

import com.cos.domain.LectureVO;

public interface LectureService {
	public void insert(LectureVO lecture) throws Exception;
	public List<LectureVO> selectTitle(int ctNum) throws Exception;
	public LectureVO selectMaxNum(int ctNum) throws Exception;
	public LectureVO selectMinNum(int ctNum) throws Exception;
	public LectureVO select(int lcNum) throws Exception;
	public void delete(int lcNum) throws Exception;
	public void update(LectureVO lecture) throws Exception;
	public void updateReadCount(int lcNum) throws Exception;
}
