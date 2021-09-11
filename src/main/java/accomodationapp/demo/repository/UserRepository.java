package accomodationapp.demo.repository;

import accomodationapp.demo.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
    User findByUserName(String username);

    User findByEmail(String email);
}
