package hu.lamsoft.books.webadmin.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import hu.lamsoft.books.persistence.book.dao.BookDao;
import hu.lamsoft.books.persistence.order.dao.OrderDao;
import hu.lamsoft.books.persistence.user.dao.UserDao;
import hu.lamsoft.books.service.order.OrderService;
import hu.lamsoft.books.service.order.impl.vo.OrderVO;

@Controller
@RequestMapping("/order")
public class OrderController {

  @Autowired
  OrderService orderService;

  @Autowired
  OrderDao orderDao;

  @Autowired
  UserDao userDao;

  @Autowired
  BookDao bookDao;

  @RequestMapping(value = "/create", method = RequestMethod.POST)
  public String createOrder(@Valid OrderVO orderVO, BindingResult bindingResult, Model model) {

    if (bindingResult.hasErrors() || userDao.findOne(orderVO.getUserVO().getId()) == null
        || bookDao.findOne(orderVO.getBookVO().getId()) == null) {
      model.addAttribute("order", new OrderVO());
      model.addAttribute("message", "Failed operation");
    } else {
      orderService.createOrder(orderVO);
      model.addAttribute("order", orderVO);
      model.addAttribute("message", "Succes operation");

    }
    return "order";
  }

  @RequestMapping(value = "/return", method = RequestMethod.POST)
  public String returnOrder(@Valid OrderVO orderVO, BindingResult bindingResult, Model model) {

    if (bindingResult.hasErrors() || orderDao.findOne(orderVO.getId()) == null) {
      model.addAttribute("order", new OrderVO());
      model.addAttribute("message", "Failed operation");
    } else {
      orderService.returnOrder(orderVO.getId());
      model.addAttribute("order", orderVO);
      model.addAttribute("message", "Succes operation");
    }

    return "order";
  }

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String orderForm(Model model) {
    model.addAttribute("order", new OrderVO());
    return "order";
  }
}
