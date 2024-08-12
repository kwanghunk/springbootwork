package exam4;

import java.time.LocalDate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Member4Insert {

	public static void main(String[] args) {
		EntityManagerFactory emf =Persistence.createEntityManagerFactory("JpaEx01"); 
		EntityManager entityManager = emf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		
		try {
			transaction.begin();
			
			Member4 user = new Member4("daum@naver.com", "다네이음버", LocalDate.now());
			System.out.println("sql : ");
			
			entityManager.persist(user);
			System.out.println("영속 컨텍스트에 반영 : ");
			
			transaction.commit();
			System.out.println("실제 DB에 반영 : ");
			System.out.println("가입 완료");
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} 
		entityManager.close();
		emf.close();

	}

}
