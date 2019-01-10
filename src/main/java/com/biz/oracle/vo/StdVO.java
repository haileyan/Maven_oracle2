package com.biz.oracle.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// 원하는 것만 지정해서 만들 수 있음(순서는 관계없음)
// @Data 전체 다 생성 
@Getter
@Setter
@ToString
//@Builder	 			   멤버변수 초기화 생성자를 만들고 기본생성자는 감춰버린다.
@AllArgsConstructor		// 멤버변수 생성자
@NoArgsConstructor		// 기본 super 생성자
			
public class StdVO {

	private String st_num;
	private String st_name;
	private String st_grade;
	private String st_tel;
	
}
