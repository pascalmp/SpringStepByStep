package review;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReviewController {

	@Resource
	private ReviewRepository myRepository;

	@RequestMapping("/review")
	public String displayReview(@RequestParam("id") long id, Model model) {
		Review review = myRepository.findById(id);
		model.addAttribute("selectedReview", review);
		return "review-view";
	}
	
	@RequestMapping("/all")
	public String displayAll(Model model){
	Collection<Review> reviews = myRepository.findAll();
	model.addAttribute("reviews", reviews);
	return "all-reviews";
	}

}
