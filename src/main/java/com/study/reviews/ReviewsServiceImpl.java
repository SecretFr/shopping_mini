package com.study.reviews;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.contents.ContentsDTO;
import com.study.reviews.ReviewsDTO;
import com.study.reviews.ReviewsMapper;

@Service("com.study.reviews.ReviewsServiceImpl")
public class ReviewsServiceImpl implements ReviewsService {
	@Autowired
	private ReviewsMapper mapper;

	@Override
	public int create(ReviewsDTO dto) {
		// TODO Auto-generated method stub
		return mapper.create(dto);
	}


	@Override
	public int total(Map map) {
		// TODO Auto-generated method stub
		return mapper.total(map);
	}

	@Override
	public List<ReviewsDTO> list(Map map) {
		// TODO Auto-generated method stub
		return mapper.list(map);
	}

	@Override
	public ReviewsDTO read(int reviewno) {
		// TODO Auto-generated method stub
		return mapper.read(reviewno);
	}

	@Override
	public List<Map> getCategory() {
		// TODO Auto-generated method stub
		return mapper.getCategory();
	}


	@Override
	public List<Map> getOption() {
		// TODO Auto-generated method stub
		return mapper.getOption();
	}





	@Override
	public Map<String, String> findContentsno(ReviewsDTO dto) {
		// TODO Auto-generated method stub
		return mapper.findContentsno(dto);
	}


	@Override
	public void upViewcnt(int reviewno) {
		// TODO Auto-generated method stub
		
		mapper.upViewcnt(reviewno);
		
	}


	@Override
	public int update(ReviewsDTO dto) {
		// TODO Auto-generated method stub
		return mapper.update(dto);
	}


	@Override
	public Map<String, String> findPname(int reviewno) {
		// TODO Auto-generated method stub
		return mapper.findPname(reviewno);
	}


	@Override
	public int checkRefnum(int reviewno) {
		// TODO Auto-generated method stub
		return mapper.checkRefnum(reviewno);
	}


	@Override
	public int passCheck(Map map) {
		// TODO Auto-generated method stub
		return mapper.passCheck(map);
	}


	@Override
	public void delete(int reviewno) {
		// TODO Auto-generated method stub
		mapper.delete(reviewno);
	}








}