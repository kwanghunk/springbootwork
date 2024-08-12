package exam1;

import java.time.LocalDate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class MemberUse {
	
	public static void main(String[] args) {
		EntityManagerFactory emf =Persistence.createEntityManagerFactory("JpaEx01"); //<persistence-unit name="">의 값과 같게 
		EntityManager entityManager = emf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction(); // 위 3줄까지가 기본 세팅
		
		try {
		transaction.begin(); //transaction 시작
		Member1 user = new Member1("홍길동1", LocalDate.now());
		
		
		entityManager.persist(user); // .persist()는 영속성으로 객체에 데이터 입력(메모리에 insert해주는 부분)
		transaction.commit();//transaction 종료
		} catch(Exception e) {
			e.printStackTrace();
			transaction.rollback();	// commit전 오류날 경우 rollback 시키기
		} finally {
			entityManager.close();
			emf.close();
		}
	}

}
