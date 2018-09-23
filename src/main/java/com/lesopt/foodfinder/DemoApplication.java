package com.lesopt.foodfinder;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.lesopt.foodfinder.repository.RecipeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import com.lesopt.foodfinder.models.User;
import com.lesopt.foodfinder.repository.UserRepository;
import com.lesopt.foodfinder.models.Recipe;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

  @Bean
  public CommandLineRunner demo(UserRepository rUserRepo, RecipeRepository recipeRepo) {
    return (args) -> {
      System.out.println("heyo");
      User rUser1 = rUserRepo.save(new User("username", "fullname", "email@", "pass", 0));
      String recipeJson = "{\"title\": \"recipe title\", \"publisher\": \"some publisher\" }";
      recipeRepo.save(new Recipe(recipeJson, rUser1));
      for(User u : rUserRepo.findAll()) {
        System.out.println(u);
      }
    };
  }
}
