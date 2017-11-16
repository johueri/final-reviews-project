package reviewsprojectpartdeux;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {

	@Id
	@GeneratedValue
	private Long categoryId;
	
	private String categoryTitle;
	
	@OneToMany (mappedBy = "category")
	private Set<Review> reviewInCategory;
	
	protected Category() {
	}

	public Category(String categoryTitle) {
		this.categoryTitle = categoryTitle;
	}

	public Long getCategoryId() {
		return categoryId;
	}


	public String getCategoryTitle() {
		return categoryTitle;
	}

	public Set<Review> getReviewInCategory() {
		return reviewInCategory;
	}
	@Override
	public String toString() {
		return String.format("Category[categoryTitle='%s']", categoryTitle);
}
}