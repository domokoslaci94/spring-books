package hu.lamsoft.books.webapi.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import hu.lamsoft.books.service.user.UserService;
import hu.lamsoft.books.service.user.impl.vo.UserVO;

/**
 * Created by ui2016 on 2016.08.08..
 */
@RestController
public class UserController {
  @Autowired
  UserService userService;

  @RequestMapping(name = "/user")
  public List<UserVO> showUsers(@RequestParam(name = "page") Integer page,
                                @RequestParam(name = "pageSize") Integer pageSize) {
    return userService.getUsers(page, pageSize);
  }
}
