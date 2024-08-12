package exam4;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Member4Select {

	public static void main(String[] args) {
		EntityManagerFactory emf =Persistence.createEntityManagerFactory("JpaEx01"); 
		EntityManager entityManager = emf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		
		try {
			transaction.begin();
			
			Member4 user = entityManager.find(Member4.class, "daum@naver.com");
			System.out.println("user find : " + user.getName());
			
			if(user != null) {
				System.out.println("user name : " + user.getName());
			} else {
				System.out.println("DB조회 실패");
			}
			
			transaction.commit();
			System.out.println("user commit : " + user.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		entityManager.close();
		emf.close();
	}

}
