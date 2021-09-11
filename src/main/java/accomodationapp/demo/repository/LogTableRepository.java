package accomodationapp.demo.repository;

import accomodationapp.demo.entity.LogTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogTableRepository extends JpaRepository<LogTable, Integer> {

}
