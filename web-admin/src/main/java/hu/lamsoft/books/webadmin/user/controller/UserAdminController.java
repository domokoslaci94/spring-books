package hu.lamsoft.books.webadmin.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import hu.lamsoft.books.service.book.BookService;

@Controller
@RequestMapping("/user")
public class UserAdminController {
  @Autowired
  BookService bookService;
}
