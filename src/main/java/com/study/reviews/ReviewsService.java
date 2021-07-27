package com.study.reviews;

import java.util.List;
import java.util.Map;

import com.study.contents.ContentsDTO;
import com.study.reviews.ReviewsDTO;

public interface ReviewsService {

	int create(ReviewsDTO dto);

	int total(Map map);

	List<ReviewsDTO> list(Map map);
	
	ReviewsDTO read(int reviewno);
	
	List<Map> getCategory();
	
	List<Map> getOption();
	
	Map<String, String> findContentsno(ReviewsDTO dto);
	
	Map<String, String> findPname(int reviewno);
	
	void upViewcnt(int reviewno);
	
	int update(ReviewsDTO dto);

	int checkRefnum(int reviewno);

	int passCheck(Map map);

	void delete(int reviewno);
	
	
	

}