package tradingz.firstproject.repositories;

import tradingz.firstproject.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

}
