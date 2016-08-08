package hu.lamsoft.books.service.order.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import hu.lamsoft.books.persistence.book.dao.BookDao;
import hu.lamsoft.books.persistence.order.dao.OrderDao;
import hu.lamsoft.books.persistence.order.entity.Order;
import hu.lamsoft.books.persistence.user.dao.UserDao;
import hu.lamsoft.books.service.order.OrderService;
import hu.lamsoft.books.service.order.impl.converter.OrderToOrderVOConverter;
import hu.lamsoft.books.service.order.impl.vo.OrderVO;

@Service
public class OrderServiceImpl implements OrderService {

  @Autowired
  private OrderDao orderDao;

  @Autowired
  private BookDao bookDao;

  @Autowired
  private UserDao userDao;

  @Autowired
  private OrderToOrderVOConverter orderToOrderVOConverter;

  @Override
  public void createOrder(OrderVO orderVO) {
    Order result = new Order();
    result.setId(orderVO.getId());
    result.setReturnedDate(orderVO.getReturnedDate());
    result.setUser(userDao.findOne(orderVO.getUser().getId()));
    result.setBook(bookDao.findOne(orderVO.getBookVO().getId()));
    orderDao.save(result);
  }

  @Override
  public void returnOrder(Integer id) {
    OrderVO orderVO = getOrder(id);
    orderVO.setReturnedDate(LocalDate.now());
    createOrder(orderVO);
  }

  @Override
  public List<OrderVO> getOrders(Integer page, Integer pageSize) {
    Page<Order> orders = orderDao.findAll(new PageRequest(page, pageSize));
    List<OrderVO> result = new ArrayList<>();

    for (Order order : orders) {
      result.add(orderToOrderVOConverter.convert(order));
    }

    return result;
  }

  @Override
  public OrderVO getOrder(Integer id) {
    return orderToOrderVOConverter.convert(orderDao.findOne(id));
  }
}
