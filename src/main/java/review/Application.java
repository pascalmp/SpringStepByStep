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

	@Bean
	public CommandLineRunner populateReviews() {
		return new ReviewPopulatorRunner();
	}

	public class ReviewPopulatorRunner implements CommandLineRunner {
		@Override
		public void run(String... args) throws Exception {
			/*
			 * Since it's the first Review being created, the generated id for this Review will be 1 (specifically, 1L since it's long).
			 */
			reviewRepository.save(new Review("title", "author", "content", new Date()));
		}
	}
    
    
}




