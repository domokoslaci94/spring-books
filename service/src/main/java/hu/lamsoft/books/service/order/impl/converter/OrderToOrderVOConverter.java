package hu.lamsoft.books.service.order.impl.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import hu.lamsoft.books.persistence.order.entity.Order;
import hu.lamsoft.books.service.book.impl.converter.BookToBookVOConverter;
import hu.lamsoft.books.service.order.impl.vo.OrderVO;
import hu.lamsoft.books.service.user.impl.converter.UserToUserVOConverter;

@Component
public class OrderToOrderVOConverter implements Converter<Order, OrderVO> {
  @Autowired
  UserToUserVOConverter userToUserVOConverter;

  @Autowired
  BookToBookVOConverter bookToBookVOConverter;

  @Override
  public OrderVO convert(Order order) {
    OrderVO result = new OrderVO();
    result.setId(order.getId());
    result.setReturnedDate(order.getReturnedDate());
    result.setCreatedDate(order.getCreatedDate());
    result.setUser(userToUserVOConverter.convert(order.getUser()));
    result.setBookVO(bookToBookVOConverter.convert(order.getBook()));

    return result;
  }
}
