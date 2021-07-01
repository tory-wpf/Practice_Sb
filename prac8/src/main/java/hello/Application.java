package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class);
        CountryRepository repository = context.getBean(CountryRepository.class);
        RegionRepository regionRepository = context.getBean(RegionRepository.class);
        CityRepository cityRepository = context.getBean(CityRepository.class);

        CountryEntity country = new CountryEntity();
        country.setName("Россия");
        country.setActive(true);
        repository.save(country);

        RegionEntity region = new RegionEntity();
        region.setName("Вологодская обл");
        region.setActive(true);
        region.setCountry(country);
        regionRepository.save(region);

        CityEntity city = new CityEntity();
        city.setName("Вологда");
        city.setActive(true);
        city.setRegion(region);
        cityRepository.save(city);


        List<CountryEntity> countries = (List<CountryEntity>) repository.findAll();
        for (CountryEntity countryCnt : countries) {
            System.out.println(countryCnt.getName());
            Set<RegionEntity> regions = countryCnt.getRegion();
            for (RegionEntity regionCnt : regions) {
                System.out.println(regionCnt.getName());
                Set<CityEntity> cities = regionCnt.getCity();
                for (CityEntity cityCnt : cities) {
                    System.out.println(cityCnt.getName());
                }
            }
        }

        context.close();
    }
}