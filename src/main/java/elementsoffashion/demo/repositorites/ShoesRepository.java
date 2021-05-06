package elementsoffashion.demo.repositorites;

import elementsoffashion.demo.models.Shoes;
import org.springframework.data.repository.CrudRepository;

public interface ShoesRepository extends CrudRepository<Shoes, Long> {
}
