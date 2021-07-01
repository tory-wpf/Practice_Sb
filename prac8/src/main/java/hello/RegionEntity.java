package hello;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class RegionEntity {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ACTIVITY")
    private Boolean active;

    public RegionEntity() { }

    public RegionEntity(String name, Boolean active) {
        this.name = name;
        this.active = active;
    }


    @OneToMany(mappedBy = "region", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<CityEntity> city = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "COUNTRIES", nullable = false)
    private CountryEntity country;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Set<CityEntity> getCity() {
        return city;
    }

    public void setCity(Set<CityEntity> city) {
        this.city = city;
    }

    public CountryEntity getCountry() {
        return country;
    }

    public void setCountry(CountryEntity country) {
        this.country = country;
    }
}
