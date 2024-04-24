package com.example.springbrrowbook.service;

import com.example.springbrrowbook.model.Book;
import com.example.springbrrowbook.model.BorrowBook;
import com.example.springbrrowbook.repository.BookRepository;
import com.example.springbrrowbook.repository.BorrowBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BorrowBookRepository borrowBookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();

    }

    public Book getBook(Long id) {
        id=null;
        return bookRepository.findById(id).orElse(null);
    }
    public String borrowBook(Long bookId){
        Book book=bookRepository.findById(bookId).orElse(null);
        if (book != null && book.getQuantity()>0) {
            book.setQuantity(book.getQuantity()-1);
            bookRepository.save(book);
            String borrowedCode=generateBorrowedCode();
            BorrowBook borrowBook=new BorrowBook();
            borrowBook.setBook(book);
            borrowBook.setBorrowedCode(borrowedCode);
            borrowBookRepository.save(borrowBook);
            return borrowedCode;
            
        }
        return null;
    }
public Boolean returnBook(String borrowCode){
        BorrowBook borrowBook=borrowBookRepository.findByBorrowedCode(borrowCode);
        if(borrowBook!=null){
            Book book=borrowBook.getBook();
            book.setQuantity(book.getQuantity()+1);
            bookRepository.save(book);
            borrowBookRepository.delete(borrowBook);
            return true;
        }
        return false;
}
    public String generateBorrowedCode() {
        int size = 5;;
        String character = "ABCDEFGHabcdefgh12345";
        Random random = new Random();
//        tạo đối tượng StringBuilder để thao tác xử lý chuối
        StringBuilder codeBuilder = new StringBuilder();
        for (int i = 0; i < size; i++) {
//            trả về 1 vị trí ngẫu nhiên
            int randomIndex = random.nextInt(character.length());
//trả về giá trị Char của chuỗi tại vị trí có chỉ số index được chỉ định
            char randomChar = character.charAt(randomIndex);
//            nối chuỗi
            codeBuilder.append(randomChar);
        }
        return codeBuilder.toString();

    }



}
