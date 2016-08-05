package hu.lamsoft.books.webadmin.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import hu.lamsoft.books.service.book.BookService;
import hu.lamsoft.books.service.book.impl.vo.BookVO;

@Controller
@RequestMapping("/book")
public class BookAdminController {

  @Autowired
  private BookService bookService;

  @RequestMapping(value = "/create", method = RequestMethod.POST)
  public String createBook(@Valid BookVO book, BindingResult result, Model model) {

    if (result.hasErrors()) {
      model.addAttribute("book", book);
      model.addAttribute("message", "Failed operation.");
    } else {
      bookService.createBook(book);
      model.addAttribute("book", new BookVO());
      model.addAttribute("message", "Success operation.");
    }
    return "book";
  }

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String bookForm(Model model) {
    model.addAttribute("book", new BookVO());
    return "book";
  }

}
