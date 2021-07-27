package com.study.reviews;

import java.util.List;
import java.util.Map;

import com.study.contents.ContentsDTO;

public interface ReviewsMapper {

	int create(ReviewsDTO dto);

	int update(ReviewsDTO dto);

	int total(Map map);

	List<ReviewsDTO> list(Map map);

	int updateFile(Map map);
	
	ReviewsDTO read(int reviewno);
	
	List<Map> getCategory();
	
	List<ReviewsDTO> mainlist(Map map);
	
	ReviewsDTO detail(int reviewno);

	List<Map> getOption();
	
	Map<String, String> findContentsno(ReviewsDTO dto);
	
	Map<String, String> findPname(int reviewno);
	
	void upViewcnt(int reviewno);
	
	int checkRefnum(int reviewno);
	
	int passCheck(Map map);
	
	void delete(int reviewno);

	

}