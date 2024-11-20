package pe.edu.i202221402.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202221402.entity.City;
import pe.edu.i202221402.entity.Country;
import pe.edu.i202221402.entity.CountryLanguage;


import java.util.ArrayList;
import java.util.List;

public class JPAPersist {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("world");
        EntityManager em = emf.createEntityManager();


        Country country = new Country("MMM", "MMontoya", "Asia",
                "RegionMarcelo", 5000.99, 99, 720000, 79.99,
                49.99, 50.99, "MontoyaFLORES",
                "Republic", "Marcelo", 1, "A1", new ArrayList<>(), new ArrayList<>());

        City ciudad1 = new City(4080, "Castanios310", "MMM", "Distrito1", 100000, country);
        City ciudad2 = new City(4081, "EstadosU", "MMM", "Distrito2", 200000, country);
        City ciudad3 = new City(4082, "CiprianoDulanto", "MMM", "Distrito3", 300000, country);

        country.getCities().add(ciudad1);
        country.getCities().add(ciudad2);
        country.getCities().add(ciudad3);

        CountryLanguage language1 = new CountryLanguage("MMM", "lennat1", "T",50.0);
        CountryLanguage language2 = new CountryLanguage("MMM", "lennat2", "F", 30.0);

        language1.setCountry(country);
        language2.setCountry(country);

        country.getCountryLanguages().add(language1);
        country.getCountryLanguages().add(language2);


        em.getTransaction().begin();
        em.persist(country);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}