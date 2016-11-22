package review;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    
	@Resource
	private ReviewRepository reviewRepository;
	
	@Resource
	private CategoryRepository categoryRepository;

	@Bean
	public CommandLineRunner populateReviews() {
		return new ReviewPopulatorRunner();
	}

	public class ReviewPopulatorRunner implements CommandLineRunner {
		@Override
		public void run(String... args) throws Exception {
			
			
			//Populating the category repository.
			Category animals = createCategory("Animals");
			Category food = createCategory("Food");
			Category places = createCategory("Places");
			
			//Strings for the content in the reviews.
			final String content01 = "Hii ni content number zero moja.";
			final String content02 = "Hii ni content number zero mbili";
			final String content03 = "hii ni content number zero tatu";
			final String content04 = "Hii ni content number zero nne";
			final String content05 = "Hii ni content number zero tano";
			final String content06 = "Hii ni content number zero sita";
			final String content07 = "Hii ni content number zero saba";
			final String content08 = "Hii ni content number zero nane";
			final String content09 = "Hii ni content number zero tisa";
			
			//Populating the review repository.
			reviewRepository.save(new Review("All About CheeseBurgers", "Rick Ross", content01, new Date(), food));
			reviewRepository.save(new Review("Boss Dogg Chillin lookin like a million", "Snoop", content02, new Date(), animals));
			reviewRepository.save(new Review("Where my dogs at, woof woof", "DMX", content03, new Date(), animals ));
			reviewRepository.save(new Review("Birds flying, brrr", "Birdman", content04, new Date(), animals));
			reviewRepository.save(new Review("CheeseCake factory", "Drake", content05, new Date(), food));
			reviewRepository.save(new Review("New York State of mind", "Nas", content06, new Date(), places));
			reviewRepository.save(new Review("Rainy night in Georgia Rmx", "Dolla", content07, new Date(), places));
			reviewRepository.save(new Review("California Love", "2Pac", content08, new Date(), places));
			/*
			 * Since it's the first Review being created, the generated id for this Review will be 1 (specifically, 1L since it's long).
			 */
			//reviewRepository.save(new Review("title", "author", "content", new Date()));
		}
		
		private Category createCategory(String categoryName){
			Category category = categoryRepository.save(new Category(categoryName));
			return category;
		}
	}
    
    
}




