package exam1;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 							// 테이블 이름을 클래스명으로 생성(테이블명 == 클래스명)
@Table(name="Jpamember1")			// 테이블 이름을 지정
public class Member1 {
	@Id 							// @Id : primary key를 의미(식별자)
	@GeneratedValue 				// @GeneratedValue : 자동으로 Id를 생성해줌(시퀀스)
	private Long id;				// Long은 java wrapper 클래스로 id가 없을때 null값을 받을 수 있고 큰 수를 받을 수 있음
									// 별도의 초기과정이 없으면 null로 초기화 (기본자료형은 초기값이 0으로 초기화됨)
	private String username;		// 어노테이션 안달면 일반 필드로 컬럼이 됨
	
	@Column(name="create_date")		// @Column(name="") : 필드명과 다르게 컬럼명을 지정하고 싶을때
	private LocalDate createDate;

	public Member1() {}

	public Member1(String username, LocalDate createDate) {
		this.username = username;
		this.createDate = createDate;
	}
	
	
							
}
