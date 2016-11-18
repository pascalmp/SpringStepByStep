package review;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;


@Component
public class ReviewRepository {

	private Map<Long, Review> reviewsById;

	public ReviewRepository() {

		reviewsById = new HashMap<Long, Review>();

		Review review1 = new Review(1, "JavaScript for biginners", "Pasical M", "Lorem ipsum and so on",
				new Date(2016, 10, 11));

		Review review2 = new Review(2, "Spring MVC guide", "Seth Dolman", "Lorem ipsum and so on", new Date(2016, 11, 25));

		Review review3 = new Review(3, "Coding Basics", "Kierra Westmoreland", "Lorem ipsum and so on",
				new Date(2016, 10, 24));

		reviewsById.put(review1.getId(), review1);
		reviewsById.put(review2.getId(), review2);
		reviewsById.put(review3.getId(), review3);

	}
	
	
	

	public Review findById(long id) {
		return reviewsById.get(id);
	}




	public Collection<Review> findAll() {
		return reviewsById.values();
	}
	
	

}
