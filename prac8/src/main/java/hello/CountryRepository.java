package hello;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountryRepository extends JpaRepository<CountryEntity, Long> {

    List<CountryEntity> findByName(String country);
}