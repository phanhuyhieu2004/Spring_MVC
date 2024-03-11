package com.example.test2.controller;



import com.example.test2.model.Computer;
import com.example.test2.service.IComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/computers")
public class ComputerController {

    @Autowired
    private IComputerService iComputerService;

    @GetMapping
    public ResponseEntity<Iterable<Computer>> findAllComputer() {
        List<Computer> computers = (List<Computer>) iComputerService.findAll();
        if (computers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(computers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Computer> findComputerById(@PathVariable Long id) {
        Optional<Computer> computerOptional = iComputerService.findById(id);
        if (!computerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(computerOptional.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Computer> saveComputer(@RequestBody Computer computer) {
        return new ResponseEntity<>(iComputerService.save(computer), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Computer> updateComputer(@PathVariable Long id, @RequestBody Computer computer) {
        Optional<Computer> computerOptional = iComputerService.findById(id);
        if (!computerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        computer.setId(computerOptional.get().getId());
        return new ResponseEntity<>(iComputerService.save(computer), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Computer> deleteComputer(@PathVariable Long id) {
        Optional<Computer> computerOptional = iComputerService.findById(id);
        if (!computerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iComputerService.remove(id);
        return new ResponseEntity<>(computerOptional.get(), HttpStatus.OK);
    }


}
