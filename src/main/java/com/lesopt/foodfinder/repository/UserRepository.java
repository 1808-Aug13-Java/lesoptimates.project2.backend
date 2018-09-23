package com.lesopt.foodfinder.repository;
import com.lesopt.foodfinder.models.User;
import org.springframework.data.repository.CrudRepository;
import java.util.*;
public interface UserRepository extends CrudRepository<User, Integer> {
  List<User> findByIsChef(Integer isChef);
	List<User> findByUserIdAndIsChef(Integer userId, Integer isChef);
}
