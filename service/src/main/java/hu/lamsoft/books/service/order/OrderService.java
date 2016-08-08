package hu.lamsoft.books.service.order;

import java.util.List;
import hu.lamsoft.books.service.order.impl.vo.OrderVO;

public interface OrderService {

  void createOrder(OrderVO orderVO);

  void returnOrder(Integer id);

  List<OrderVO> getOrders(Integer page, Integer pageSize);

  OrderVO getOrder(Integer id);

}
