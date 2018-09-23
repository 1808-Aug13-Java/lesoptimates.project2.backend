package com.lesopt.foodfinder.repository;
import com.lesopt.foodfinder.models.User;
import org.springframework.data.repository.CrudRepository;
import java.util.*;
public interface UserRepository extends CrudRepository<User, Integer> {
  List<User> findByIsChef(boolean isChef);
	List<User> findByUserIdAndIsChef(Integer userId, boolean isChef);
  User findByUsername(String username);
  boolean existsByUsername(String username);
  void deleteByUsername(String username);
}
