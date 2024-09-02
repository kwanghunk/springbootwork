package com.study.springboot.domain;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name="JPAPAGING")
public class Member {
	@Id
	@SequenceGenerator(
			name = "PAGINGSEQ",
			sequenceName = "jpaPaging_seq",
			initialValue = 1,
			allocationSize = 1
	)
	@GeneratedValue (generator="PAGINGSEQ")
	private Long id;
	private String name;
	private String email;

}