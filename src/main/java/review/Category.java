package review;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String name;
	
	
	@OneToMany(mappedBy = "category")
	
    Set<Review> reviewsByCategory;
	
	protected Category(){}
	
	public Category(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public Set<Review> getReviewsByCategory(){
			return reviewsByCategory;
		
	}

}
