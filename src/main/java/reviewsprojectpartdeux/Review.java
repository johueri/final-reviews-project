package reviewsprojectpartdeux;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Review { // Model Class

	@Id
	@GeneratedValue
	private Long reviewId;

	private String title;
	private String imageUrl;
	private String content;

	@ManyToOne
	private Category category;
	
	@ManyToMany
	private Set<Tag> tagsInReview = new HashSet<Tag>();

	protected Review() {
	}

	public Review(String title, String imageUrl, Category category, String content, Tag... tag) {
		this.title = title;
		this.imageUrl = imageUrl;
		this.category = category;
		this.content = content;
		this.tagsInReview = new HashSet<Tag>(Arrays.asList(tag));
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

	public Set<Tag> getTagsInReview() {
		return tagsInReview;
	}


	public void setTagsInReview(Set<Tag> tagsInReview) {
		this.tagsInReview = tagsInReview;
	}
	
	public void addTag(Tag newTag) {
		tagsInReview.add(newTag);
	}

	public void removeTag(Tag newTag) {
		tagsInReview.remove(newTag);
	}

	@Override
	public String toString() {
		return String.format("Review[title='%s', imageUrl='%s', category='%s', content='%s', tagsInReview='%s']", title, imageUrl,
				category, content, tagsInReview);
	}

}
