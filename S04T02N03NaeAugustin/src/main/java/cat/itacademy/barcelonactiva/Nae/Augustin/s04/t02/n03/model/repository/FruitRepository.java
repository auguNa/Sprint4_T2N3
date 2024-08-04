package cat.itacademy.barcelonactiva.Nae.Augustin.s04.t02.n03.model.repository;

import cat.itacademy.barcelonactiva.Nae.Augustin.s04.t02.n03.model.domain.Fruit;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FruitRepository extends MongoRepository<Fruit, Long> {
	Optional<Fruit> findByName(String name);
}
