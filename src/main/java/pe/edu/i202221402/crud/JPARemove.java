package pe.edu.i202221402.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202221402.entity.Country;

public class JPARemove {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("world");
        EntityManager em = emf.createEntityManager();

        Country country = em.find(Country.class, "MMM");

        em.getTransaction().begin();
        em.remove(country);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}