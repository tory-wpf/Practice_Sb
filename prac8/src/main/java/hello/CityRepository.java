package hello;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<CityEntity, Long> {

    List<CityEntity> findByName(String city);
}