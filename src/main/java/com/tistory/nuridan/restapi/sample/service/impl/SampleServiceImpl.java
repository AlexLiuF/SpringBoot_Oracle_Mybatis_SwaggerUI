package com.tistory.nuridan.restapi.sample.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tistory.nuridan.restapi.sample.mapper.SampleMapper;
import com.tistory.nuridan.restapi.sample.model.SampleVO;
import com.tistory.nuridan.restapi.sample.service.SampleService;

@Service
public class SampleServiceImpl implements SampleService {

	@Autowired
	private SampleMapper dao; 
	
	@Override
	public SampleVO get(SampleVO vo) throws Exception { 
		
		SampleVO result = dao.select(vo);
		return result; 
	}

	@Override
	public int insert(SampleVO vo) throws Exception {
		// TODO Auto-generated method stub
		return dao.insert(vo);
	}


	@Override
	public int update(SampleVO vo) throws Exception {
		// TODO Auto-generated method stub
		return dao.update(vo);
	}


	@Override
	public int delete(SampleVO vo) throws Exception {
		// TODO Auto-generated method stub
		return dao.delete(vo);
	}

}
