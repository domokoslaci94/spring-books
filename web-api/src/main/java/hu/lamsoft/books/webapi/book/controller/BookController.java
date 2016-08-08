package hu.lamsoft.books.webapi.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import hu.lamsoft.books.service.book.BookService;
import hu.lamsoft.books.service.book.impl.vo.BookVO;

@RestController
public class BookController {

  @Autowired
  private BookService bookService;

  @RequestMapping("/search")
  public List<BookVO> getBooks(@RequestParam(value = "title", required = true) String title) {
    return bookService.getBooks(title);
  }

  @RequestMapping("/book")
  public BookVO getBook(@RequestParam(value = "id", required = true) Integer id) {
    return bookService.getBook(id);
  }

  @RequestMapping("/books")
  public List<BookVO> getBooks(@RequestParam(value = "page", defaultValue = "0") Integer page,
                               @RequestParam(value = "page_size", defaultValue = "10") Integer pageSize) {
    return bookService.getBooks(page, pageSize);
  }

}
