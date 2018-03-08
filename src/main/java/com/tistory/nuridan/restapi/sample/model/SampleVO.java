package com.tistory.nuridan.restapi.sample.model;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@Alias("sampleVO")
@Data
@ToString(callSuper = true, includeFieldNames = true)
@ApiModel(value = "샘플등록 및 수정용 파라미터")
public class SampleVO implements Serializable {

	private static final long serialVersionUID = -8393820430601561718L;

	//회원ID
	@ApiModelProperty(value = "샘플ID", example = "nuridan")
	private String sampleId;
	
	//회원명
	@ApiModelProperty(value = "샘플명", required = true, example = "숙취")
	private String sampleNm;
}
