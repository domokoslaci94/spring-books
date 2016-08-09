package hu.lamsoft.books.webapi.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import hu.lamsoft.books.service.order.OrderService;
import hu.lamsoft.books.service.order.impl.vo.OrderVO;

@RestController
public class OrderController {

  @Autowired
  OrderService orderService;

  @RequestMapping(value = "/order", method = RequestMethod.GET)
  public List<OrderVO> showOrders(@RequestParam(name = "page", defaultValue = "0") Integer page,
                                  @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
    return orderService.getOrders(page, pageSize);
  }

}
