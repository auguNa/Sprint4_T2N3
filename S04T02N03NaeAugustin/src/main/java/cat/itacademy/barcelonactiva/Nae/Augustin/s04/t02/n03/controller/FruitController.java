package cat.itacademy.barcelonactiva.Nae.Augustin.s04.t02.n03.controller;

import cat.itacademy.barcelonactiva.Nae.Augustin.s04.t02.n03.model.domain.Fruit;
import cat.itacademy.barcelonactiva.Nae.Augustin.s04.t02.n03.services.FruitServImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/fruits")
public class FruitController {
	
	@Autowired
    private FruitServImpl fruitService;

    @PostMapping("/add")
    public ResponseEntity<?> addFruit(@Valid @RequestBody Fruit fruit, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(fruitService.createFruit(fruit));
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateFruit(@RequestBody Fruit fruit){
        return ResponseEntity.ok().body(fruitService.updateFruit(fruit));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteFruit(@PathVariable("id") Long fruitId){
        fruitService.deleteFruit(fruitId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<?> getOneFruit(@PathVariable("id") Long fruitId){
        return ResponseEntity.ok().body(fruitService.getOneFruit(fruitId));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Fruit>> getAllFruits(){
        return ResponseEntity.ok().body(fruitService.getAllFruits());
    }

}

