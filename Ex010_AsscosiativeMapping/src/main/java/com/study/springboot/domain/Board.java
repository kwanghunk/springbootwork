package com.study.springboot.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Entity
@ToString
@Getter
@Setter
public class Board {

	@Id
	@GeneratedValue
	private Long bno;
	private String title;
	private String content;

	@ManyToOne  // 다 대 일의 관계
	@JoinColumn(name="writer")	// board테이블에 writer컬럼을 추가하고 외래키로 지정! 외래키 컬럼을 명시적으로 지정할 때 사용
	private Member member;		// Member member가 Long이면 @JoinColumn(name="writer")에 Long이 String이면 여기도 String임
}
