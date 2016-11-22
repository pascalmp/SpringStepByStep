package review;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long>{
	
	List<Review> findById(long id);

}
