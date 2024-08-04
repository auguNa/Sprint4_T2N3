package cat.itacademy.barcelonactiva.Nae.Augustin.s04.t02.n03.services;

import cat.itacademy.barcelonactiva.Nae.Augustin.s04.t02.n03.model.domain.Fruit;
import cat.itacademy.barcelonactiva.Nae.Augustin.s04.t02.n03.model.repository.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;


@Service
public class FruitServImpl implements FruitService {
	private FruitRepository fruitRepository;

    @Autowired
    public FruitServImpl(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    @Override
    public Fruit createFruit(Fruit fruit){
        if(fruitRepository.findByName(fruit.getName()).isPresent()||fruitRepository.findById(fruit.getId()).isPresent()){
            throw new EntityExistsException("Create new Fruit Failed: Invalid fruit name: "+ fruit.getName()+
                    " or ID: "+fruit.getId()+" -> ALREADY EXISTS in DataBase");
        }

        return fruitRepository.save(fruit);
    }

    @Override
    public Fruit updateFruit(Fruit fruit){
        if(!fruitRepository.findById(fruit.getId()).isPresent()){
            throw new EntityNotFoundException("Update Fruit Failed: Invalid fruit id: "+ fruit.getId()+
                    " -> DOESN'T EXIST in DataBase");
        }

        return fruitRepository.save(fruit);
    }

    @Override
    public void deleteFruit(long fruitId){
        if(!fruitRepository.findById(fruitId).isPresent()){
            throw new EntityNotFoundException("Delete Fruit Failed: Invalid fruit id: "+ fruitId+
                    " -> DOESN'T EXIST in DataBase");
        }

        fruitRepository.deleteById(fruitId);
    }

    @Override
    public Fruit getOneFruit(long fruitId){
        return fruitRepository.findById(fruitId)
                .orElseThrow(() -> new EntityNotFoundException("Get One Fruit Failed: Invalid fruit id: "+ fruitId+
                        " -> DOESN'T EXIST in DataBase"));
    }

    @Override
    public List<Fruit> getAllFruits(){
        return fruitRepository.findAll();
    }

}