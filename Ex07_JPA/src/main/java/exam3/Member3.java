package exam3;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="JpaMember3")// 테이블 명을 클래스 명과 다르게 설정
public class Member3 {
	@Id
	@SequenceGenerator(							// 시퀀스 설정 변경해보자
			name="mySequence01",
			sequenceName="seq_JpaMem3",			// 시퀀스 이름 지정
			initialValue=1,						// 시퀀스 초기값
			allocationSize=5					// 시퀀스 증가값
			)
	@GeneratedValue(generator="mySequence01")	// 시퀀스 자동생성
	private Long id;
	
	@Access(AccessType.FIELD)					// FIELD(기본값) : 필드(멤버변수)를 통해 데이터에 접근
	private String username;
	
	@Access(AccessType.PROPERTY)				// PROPERTY : getter|setter메소드를 통해 데이터 접근
	private String password;
	
	@Transient									// *영속성에서 제외시키는 방법
	private long timestamp1;					// @Transient : 실제 DB와 데이터 교환없이 해당 작업공간에서만 사용
	transient private long timestamp2;			// 필드 앞에 transient를 넣어 위와 동일한 방법임
	
	
	public Member3() {}


	public Member3(String username, String password) {
		this.username = username;
		this.password = password;
	}


	// password에 접근할 get/set 메소드
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
	
}
