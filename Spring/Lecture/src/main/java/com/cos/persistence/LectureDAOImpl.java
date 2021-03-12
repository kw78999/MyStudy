package com.cos.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import com.cos.domain.LectureVO;
import com.cos.util.MyUtil;

@Repository
public class LectureDAOImpl implements LectureDAO{

	@Inject
	private SqlSession session;
	private static final String namespace = "com.cos.domain.lecture";
	
	@Override
	public void insert(LectureVO lecture) throws Exception {
		session.insert(namespace+".insert", lecture);	
	}

	@Override
	public List<LectureVO> selectTitle(int ctNum) throws Exception {
		return session.selectList(namespace+".selectTitle", ctNum);
	}

	@Override
	public LectureVO select(int lcNum) throws Exception {
		LectureVO lecture = session.selectOne(namespace+".select", lcNum);
		if (lecture != null) {
			lecture.setLcContent(MyUtil.makeYoutube(lecture.getLcContent()));
		}	
		return lecture;
	}

	@Override
	public LectureVO selectMaxNum(int ctNum) throws Exception {
		return session.selectOne(namespace+".selectMaxNum", ctNum);
	}
	
	@Override
	public LectureVO selectMinNum(int ctNum) throws Exception {
		return session.selectOne(namespace+".selectMinNum", ctNum);
	}

	@Override
	public void delete(int lcNum) throws Exception {
		session.delete(namespace+".delete", lcNum);
	}

	@Override
	public void update(LectureVO lecture) throws Exception {
		session.update(namespace+".update", lecture);
	}

	@Override
	public void updateReadCount(int lcNum) throws Exception {
		session.update(namespace+".updateReadCount", lcNum);
	}
}
