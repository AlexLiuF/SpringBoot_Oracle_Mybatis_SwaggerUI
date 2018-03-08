package com.tistory.nuridan.restapi.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tistory.nuridan.restapi.config.version.ApiVersion;
import com.tistory.nuridan.restapi.sample.model.SampleVO;
import com.tistory.nuridan.restapi.sample.service.SampleService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(description = "샘플관련")
@RestController
public class SampleController {
	
	@Autowired
	private SampleService service;
	

	@ApiVersion(1)
	@ApiOperation(value = "샘플등록", notes = "<pre>샘플을 신규로 등록</pre>")
	@RequestMapping(value = "/samples/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public SampleVO postSample(
			@ApiParam(required = false, name="샘플정보", value="샘플정보를 JSON형태의 파라미터<br/>(우측 스키마 클릭)") @RequestBody SampleVO vo
	) throws Exception {
		
		int result = service.insert(vo);
		
		if (result > 0) {
			return vo;
		} else {
			throw new Exception("샘플등록 시 오류가 발생되었습니다.");
		}
	}

	@ApiVersion(1)
	@ApiOperation(value = "샘플수정", notes = "<pre>샘플정보를 수정</pre>")
	@RequestMapping(value = "/samples/{sampleId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public SampleVO putSample(
			@ApiParam(required = false, name="샘플정보", value="샘플정보를 JSON형태의 파라미터<br/>(우측 스키마 클릭)") @RequestBody SampleVO vo
			, @ApiParam(required = true, name = "sampleId", value = "조회할 샘플의 ID") @PathVariable String sampleId
	) throws Exception {
		
		vo.setSampleId(sampleId);
		
		int result = service.update(vo);
		
		if (result > 0) {
			return vo;
		} else {
			throw new Exception("샘플수정 시 오류가 발생되었습니다.");
		}
	}
	

	@ApiVersion(1)
	@ApiOperation(value = "샘플삭제", notes = "<pre>샘플정보를 삭제</pre>")
	@RequestMapping(value = "/samples/{sampleId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public SampleVO deleteSample(
			@ApiParam(required = true, name = "sampleId", value = "조회할 샘플의 ID") @PathVariable String sampleId
	) throws Exception {
		
		SampleVO vo = new SampleVO();
		vo.setSampleId(sampleId);
		
		int result = service.delete(vo);
		
		if (result > 0) {
			return vo;
		} else {
			throw new Exception("샘플삭제 시 오류가 발생되었습니다.");
		}
	}

	@ApiVersion(1)
	@ApiOperation(value = "샘플조회", notes = "<pre>샘플정보를 조회하여 응답</pre>")
	@RequestMapping(value = "/samples/{sampleId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public SampleVO getSample(
			@ApiParam(required = true, name = "sampleId", value = "조회할 샘플의 ID") @PathVariable String sampleId
	) throws Exception {
		
		SampleVO vo = new SampleVO();
		vo.setSampleId(sampleId);
		
		return service.get(vo);
	}
}
