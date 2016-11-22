package review;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReviewController {

	@Resource
	private ReviewRepository myReviewRepository;
	
	@Resource 
	private CategoryRepository myCategoryRepository;

	@RequestMapping("/review")
	public String displayReview(@RequestParam("id") long id, Model model) {
		Review review = myReviewRepository.findOne(id);
		model.addAttribute("selectedReview", review);
		return "review-view";
	}
	
	@RequestMapping("/all")
	public String displayAll(Model model){
	Iterable<Review> reviews = myReviewRepository.findAll();
	model.addAttribute("reviews", reviews);
	Iterable<Category> categories = myCategoryRepository.findAll();
	model.addAttribute("categories", categories);
	return "all-reviews";
	}
	
	@RequestMapping("/categories")
	public String displayCategories(Model model){
		Iterable<Category> categories = myCategoryRepository.findAll();
		model.addAttribute("categories", categories);
		return "all-categories";
	}

}
