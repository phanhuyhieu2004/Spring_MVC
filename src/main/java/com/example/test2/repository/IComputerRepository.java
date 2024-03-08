package com.example.test2.repository;


import com.example.test2.model.Computer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IComputerRepository extends PagingAndSortingRepository<Computer, Long> {

}
