package hello;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class CountryEntity {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ACTIVITY")
    private Boolean active;

    public CountryEntity() { }

    public CountryEntity(String name, Boolean active) {
        this.name = name;
        this.active = active;
    }

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<RegionEntity> region = new HashSet<>();

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

    public Set<RegionEntity> getRegion() {
        return region;
    }

    public void setRegion(Set<RegionEntity> region) {
        this.region = region;
    }
}
