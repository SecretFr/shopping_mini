package com.study.notice;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 - Service 인터페이스와 ServiceImpl클래스를 만들어 사용한다.
- 인터페이스와 구현클래스로 분리하는 장점
 ① 느스한 결합(loose coupling)으로 기능간의 의존관계 최소화
 ② 기능변화에 대한 최소한의 수정에 따른 유연성 최대화
 ③ 모듈화를 통한 높은 재사용성
 ④ 스프링의 IOC/DI 사용의 활용의 극대화

 */

@Service("com.study.notice.NoticeServiceImpl")
public class NoticeServiceImpl implements NoticeService {
	@Autowired
	private NoticeMapper mapper;

	@Override
	public int create(NoticeDTO dto) {
		// TODO Auto-generated method stub
		return mapper.create(dto);
	}

	@Override
	public List<NoticeDTO> list(Map map) {
		// TODO Auto-generated method stub
		return mapper.list(map);
	}

	@Override
	public int total(Map map) {
		// TODO Auto-generated method stub
		return mapper.total(map);
	}

	@Override
	public NoticeDTO read(int noticeno) {
		// TODO Auto-generated method stub
		return mapper.read(noticeno);
	}

	@Override
	public int passwd(Map map) {
		// TODO Auto-generated method stub
		return mapper.passwd(map);
	}

	@Override
	public int update(NoticeDTO noticeDTO) {
		// TODO Auto-generated method stub
		return mapper.update(noticeDTO);
	}

	@Override
	public int delete(int noticeno) {
		// TODO Auto-generated method stub
		return mapper.delete(noticeno);
	}

	@Override
	public void upCnt(int noticeno) {

		mapper.upCnt(noticeno);

	}

}
