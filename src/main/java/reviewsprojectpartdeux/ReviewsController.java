package reviewsprojectpartdeux;

import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReviewsController {

	@Resource
	ReviewRepository reviewRepo;

	@Resource
	CategoryRepository categoryRepo;

	@Resource
	TagRepository tagRepo;

	@RequestMapping("/")
	public String redirectToReviews(Model model) {
		return "redirect:/reviews";
	}

	@RequestMapping("/reviews")
	public String getAllReviews(Model model) {
		model.addAttribute("reviews", reviewRepo.findAll());
		return "reviews";
	}

	@RequestMapping("/review")
	public String getOneReview(@RequestParam Long id, Model model) {
		model.addAttribute("review", reviewRepo.findOne(id));
		return "review";
	}

	@RequestMapping("/categories")
	public String getAllCategories(Model model) {
		model.addAttribute("categories", categoryRepo.findAll());
		return "categories";
	}

	@RequestMapping("/category")
	public String getOneCategory(@RequestParam Long id, Model model) {
		model.addAttribute("category", categoryRepo.findOne(id));
		return "category";
	}

	@RequestMapping("/tags")
	public String getAllTags(Model model) {
		model.addAttribute("tags", tagRepo.findAll());
		return "tags";
	}

	@RequestMapping("/tag")
	public String getOneTag(@RequestParam Long id, Model model) {
		model.addAttribute("tag", tagRepo.findOne(id));
		return "category";
	}

	@RequestMapping("/add-tag")
	public String addTag(@RequestParam Long id, String tagName) {
		Tag newTag = tagRepo.getByTagName(tagName);
		if (newTag == null) {
			newTag = new Tag(tagName);
			tagRepo.save(newTag);
		}
		Review taggedReview = reviewRepo.findOne(id);
		Set<Tag> currentTags = taggedReview.getTagsInReview();
		if (!currentTags.contains(newTag)) {
			taggedReview.addTag(newTag);
			reviewRepo.save(taggedReview);
		}
		return "redirect:/review?id=" + id;
	}

	@RequestMapping("/remove-tag")
	public String removeTag(@RequestParam Long id, String tagName) {
		Tag tagBeingRemoved = tagRepo.getByTagName(tagName);
		if (tagBeingRemoved != null) {
			Review review = reviewRepo.findOne(id);
			Set<Tag> tagsOnReview = review.getTagsInReview();
			if (tagsOnReview.contains(tagBeingRemoved)) {
				review.removeTag(tagBeingRemoved);
				reviewRepo.save(review);
			}
		}
		return "redirect:/review?id=" + id;
	}
}
