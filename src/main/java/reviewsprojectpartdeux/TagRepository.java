package reviewsprojectpartdeux;

import org.springframework.data.repository.CrudRepository;

public interface TagRepository extends CrudRepository<Tag, Long> {
	Tag getByTagName(String tagName);

}
