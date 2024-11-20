package pe.edu.i202221402.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "city")
public class City {

    @Id
    private Integer ID;
    private String Name;
    private String District;
    private Integer Population;

    @ManyToOne
    @JoinColumn(name = "CountryCode")
    private Country country;

    public City() {
    }

    public City(Integer ID, String name, String countryCode, String district, Integer population, Country country) {
        this.ID = ID;
        Name = name;
        District = district;
        Population = population;
        this.country = country;
    }

    @Override
    public String toString() {
        return "City{" +
                "ID=" + ID +
                ", Name='" + Name + '\'' +
                ", District='" + District + '\'' +
                ", Population=" + Population +
                '}';
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDistrict() {
        return District;
    }

    public void setDistrict(String district) {
        District = district;
    }

    public Integer getPopulation() {
        return Population;
    }

    public void setPopulation(Integer population) {
        Population = population;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}