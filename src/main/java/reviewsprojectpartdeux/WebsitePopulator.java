package reviewsprojectpartdeux;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class WebsitePopulator implements CommandLineRunner {

	@Resource
	private ReviewRepository reviewRepo;

	@Resource
	private CategoryRepository categoryRepo;
	
	@Resource
	private TagRepository tagRepo;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Category tos = new Category("The Orginal Series");
		categoryRepo.save(tos);
		Category tng = new Category("The Next Generation");
		categoryRepo.save(tng);
		Tag kirk = new Tag ("Captain Kirk");
		tagRepo.save(kirk);
		Tag timeT = new Tag("Temporal Dilemmas");
		tagRepo.save(timeT);
		reviewRepo.save(
				new Review("Star Trek: The Motion Picture (1979)", "/images/StarTrek1large.jpg", tos, "lorem ipsum", kirk));
		reviewRepo.save(
				new Review("Star Trek II: The Wrath of Khan (1982)", "/images/StarTrek2Large.jpg", tos, "lorem ipsum", kirk));
		reviewRepo.save(
				new Review("Star Trek IV: The Voyage Home (1986)", "/images/StarTrek3Large.jpg", tos, "lorem ipsum", kirk));
		reviewRepo.save(new Review("Star Trek Generations (1994)", "/images/StarTrek4Large.jpg", tng, "lorem ipsum", kirk, timeT));
		reviewRepo
				.save(new Review("Star Trek: First Contact (1996)", "/images/StarTrek5Large.jpg", tng, "lorem ipusm", timeT));
		reviewRepo.save(new Review("Star Trek: Insurrection (1998)", "/images/StarTrek6Large.jpg", tng, "lorem ipsum", timeT));
	}
}