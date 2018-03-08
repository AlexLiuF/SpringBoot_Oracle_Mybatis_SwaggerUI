package com.tistory.nuridan.restapi.sample.mapper;

import org.springframework.stereotype.Repository;

import com.tistory.nuridan.restapi.sample.model.SampleVO;

@Repository
public interface SampleMapper {

	public SampleVO select(SampleVO vo) throws Exception;
	
	public int insert(SampleVO vo) throws Exception;

	public int update(SampleVO vo) throws Exception;
	
	public int delete(SampleVO vo) throws Exception;
}
