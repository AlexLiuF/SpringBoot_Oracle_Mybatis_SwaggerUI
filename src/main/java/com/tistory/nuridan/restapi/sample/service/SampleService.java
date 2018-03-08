package com.tistory.nuridan.restapi.sample.service;

import com.tistory.nuridan.restapi.sample.model.SampleVO;

public interface SampleService {

	public SampleVO get(SampleVO vo) throws Exception;
	
	public int insert(SampleVO vo) throws Exception;
	
	public int update(SampleVO vo) throws Exception;
	
	public int delete(SampleVO vo) throws Exception;
}
