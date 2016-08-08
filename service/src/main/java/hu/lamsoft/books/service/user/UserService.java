package hu.lamsoft.books.service.user;

import java.util.List;
import hu.lamsoft.books.service.user.impl.vo.UserVO;

public interface UserService {
  List<UserVO> getUsers(Integer page, Integer pageSize);

  void createUser(UserVO userVO);
}
