package pe.edu.i202221402.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202221402.entity.City;
import pe.edu.i202221402.entity.Country;

import java.util.List;

public class JPAFind {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("world");
        EntityManager em = emf.createEntityManager();

        Country country = em.find(Country.class, "PER");

        List<City> cities = country.getCities();
        cities.stream()
                .filter(city -> city.getPopulation() > 700000)
                .forEach(city -> System.out.println(city.getName()));

        em.close();
        emf.close();
    }
}
