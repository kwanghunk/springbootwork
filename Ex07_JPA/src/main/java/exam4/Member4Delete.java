package exam4;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Member4Delete {

	public static void main(String[] args) {
		EntityManagerFactory emf =Persistence.createEntityManagerFactory("JpaEx01"); 
		EntityManager entityManager = emf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();

		try {
			transaction.begin();
			
			Member4 user = entityManager.find(Member4.class, "daum@naver.com");
			
			if(user == null) {
				System.out.println("존재하지 않습니다.");
				return;
			}
			entityManager.remove(user);
			
			transaction.commit();
			System.out.println("user name :" + user.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		entityManager.close();
		emf.close();
	}

}
