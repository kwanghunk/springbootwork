package exam2;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Member2Create {

	public static void main(String[] args) {
		EntityManagerFactory emf =Persistence.createEntityManagerFactory("JpaEx01"); 
		EntityManager entityManager = emf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		
		entityManager.close();
		emf.close();
		//JpaEx01에 들어온 테이블 2개에서 현재 Member2의 create가 Member1이 만든 테이블 삭제 후 새로 만듦
	}

}
