package com.lesopt.foodfinder;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.lesopt.foodfinder.repository.RecipeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import com.lesopt.foodfinder.models.RUser;
import com.lesopt.foodfinder.repository.RUserRepository;
import com.lesopt.foodfinder.models.Recipe;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

  @Bean
  public CommandLineRunner demo(RUserRepository rUserRepo, RecipeRepository recipeRepo) {
    return (args) -> {
      System.out.println("heyo");
      RUser rUser1 = rUserRepo.save(new RUser("username", "fullname", "email@", "pass", 0));
      String recipeJson = "{\"title\": \"recipe title\", \"publisher\": \"some publisher\" }";
      recipeRepo.save(new Recipe(recipeJson, rUser1));
      for(RUser u : rUserRepo.findAll()) {
        System.out.println(u);
      }
    };
  }
}
