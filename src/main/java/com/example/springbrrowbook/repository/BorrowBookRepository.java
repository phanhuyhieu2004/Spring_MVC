package com.example.springbrrowbook.repository;

import com.example.springbrrowbook.model.BorrowBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface BorrowBookRepository extends JpaRepository<BorrowBook,Long> {
    BorrowBook findByBorrowedCode(String borrowedCode);}
