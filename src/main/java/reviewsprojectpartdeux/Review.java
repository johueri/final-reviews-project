package reviewsprojectpartdeux;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Review { //Model Class

	@Id
	@GeneratedValue
	private Long reviewId;
	
	private String title;
	private String imageUrl;
	private String content;
	
	@ManyToOne
	private Category category;
	
	protected Review () {
	}
	
	
	public Review(String title, String imageUrl, Category category, String content) {
		this.title = title;
		this.imageUrl = imageUrl;
		this.category = category;
		this.content = content;
	}

	public Long getReviewId() {
		return reviewId;
	}


	public String getTitle() {
		return title;
	}

	public String getImageUrl() {
		return imageUrl;
	}


	public Category getCategory() {
		return category;
	}

	
	public String getContent() {
		return content;
	}

	@Override
	public String toString() {
		return String.format("Review[title='%s', imageUrl='%s', category='%s', content='%s']", title, imageUrl, category, content);
}
	

}
