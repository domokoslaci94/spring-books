package hu.lamsoft.books.service.order.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import hu.lamsoft.books.persistence.book.entity.Book;
import hu.lamsoft.books.persistence.order.dao.OrderDao;
import hu.lamsoft.books.persistence.order.entity.Order;
import hu.lamsoft.books.persistence.user.entity.User;
import hu.lamsoft.books.service.order.OrderService;
import hu.lamsoft.books.service.order.impl.converter.OrderToOrderVOConverter;
import hu.lamsoft.books.service.order.impl.vo.OrderVO;

@Service
public class OrderServiceImpl implements OrderService {

  @Autowired
  OrderDao orderDao;

  @Autowired
  OrderToOrderVOConverter orderToOrderVOConverter;

  @Override
  public void createOrder(OrderVO orderVO) {
    Order result = new Order();
    result.setId(orderVO.getId());
    result.setCreatedDate(orderVO.getCreatedDate());
    result.setReturnedDate(orderVO.getReturnedDate());

    User user = new User();
    user.setId(orderVO.getUser().getId());
    user.setName(orderVO.getUser().getName());
    user.setLoginName(orderVO.getUser().getLoginName());
    user.setRegistrationDate(orderVO.getUser().getRegistrationDate());

    result.setUser(user);

    Book book = new Book();
    book.setId(orderVO.getBookVO().getId());
    book.setAuthor(orderVO.getBookVO().getAuthor());
    book.setTitle(orderVO.getBookVO().getTitle());
    book.setPrice(orderVO.getBookVO().getPrice());

    result.setBook(book);

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
