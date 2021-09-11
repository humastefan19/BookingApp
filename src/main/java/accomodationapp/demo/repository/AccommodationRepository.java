package accomodationapp.demo.repository;

import accomodationapp.demo.entity.Accommodation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public interface AccommodationRepository extends JpaRepository<Accommodation,Integer> {

    Accommodation getAccommodationById(int id);

    default List<Accommodation> getAccommodationsByFilter(String name,String city, boolean descending){
        return this.findAll().stream()
                .filter(accommodation -> {
                    if(name != null){
                        return accommodation.getName().toLowerCase().contains(name.toLowerCase());
                    }else if(city != null){
                        return accommodation.getAddress().toLowerCase().contains(city.toLowerCase());
                    }else{
                        return true;
                    }
                })
                .sorted(descending ? Comparator.comparing(Accommodation::getName).reversed() : Comparator.comparing(Accommodation::getName))
                .collect(Collectors.toList());


    }
}
