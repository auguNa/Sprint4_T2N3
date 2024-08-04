package cat.itacademy.barcelonactiva.Nae.Augustin.s04.t02.n03.services;

import cat.itacademy.barcelonactiva.Nae.Augustin.s04.t02.n03.model.domain.Fruit;

import java.util.List;

public interface FruitService {
	Fruit createFruit(Fruit fruit);

	Fruit updateFruit(Fruit fruit);

	void deleteFruit(long fruitId);

	Fruit getOneFruit(long fruitId);

	List<Fruit> getAllFruits();

}
