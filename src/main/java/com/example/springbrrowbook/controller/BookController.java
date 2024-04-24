package com.example.springbrrowbook.controller;

import com.example.springbrrowbook.model.Book;
import com.example.springbrrowbook.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public String getAllBooks(Model model, @CookieValue (value="views",defaultValue = "0")long views, HttpServletResponse response) {
        Cookie cookie=new Cookie("views",String.valueOf(views+1));
        cookie.setMaxAge(30);
        response.addCookie(cookie);


        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        model.addAttribute("list","List sách");
        model.addAttribute("cookie",cookie.getValue());
        return "/bookList";

    }
    @GetMapping("/remove")
    public  String remove(HttpServletResponse response){
        Cookie cookie=new Cookie("views","");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return "redirect:/books";

    }

    @GetMapping("/book/{id}")
    public String getBook(@PathVariable Long id, Model model) {
        Book book = bookService.getBook(id);
        model.addAttribute("book", book);
        model.addAttribute("info", "Thông tin sách");
        return "/detail";

    }

    @PostMapping("/borrow/{id}")
    public String borrowBook(@PathVariable Long id, Model model) {
        String borrowCode = bookService.borrowBook(id);
        if (borrowCode != null) {
            model.addAttribute("borrowCode", borrowCode);
            model.addAttribute("borrow","Mã mượn sách");
        } else {
            model.addAttribute("error", "Loi rui hu hu");

        }
        return "/borrowResult";
    }

    @GetMapping("/return")
    public String showReturnForm(Model model) {
        model.addAttribute("return", "Trả sách");

        return "/result";
    }

    @PostMapping("/returns")
    public String returnBook(@RequestParam("borrowedCode") String borrowedCode, Model model) {
        boolean returned = bookService.returnBook(borrowedCode);
        if (returned) {
            model.addAttribute("message", "Thanh công rùi hi hi");
            model.addAttribute("result", "Kết qủa");


        } else {
            model.addAttribute("errors", "Sai rùi hu hu");
        }
        return "/returnBook";
    }
}
