package hello;

import javax.persistence.*;

@Entity
public class CityEntity {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ACTIVITY")
    private Boolean active;

    public CityEntity() { }

    public CityEntity(String name, Boolean active) {
        this.name = name;
        this.active = active;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "REGION", nullable = false)
    private RegionEntity region;

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

    public RegionEntity getRegion() {
        return region;
    }

    public void setRegion(RegionEntity region) {
        this.region = region;
    }
}
