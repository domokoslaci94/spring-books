package hu.lamsoft.books.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import hu.lamsoft.books.persistence.user.dao.UserDao;
import hu.lamsoft.books.persistence.user.entity.User;
import hu.lamsoft.books.service.user.UserService;
import hu.lamsoft.books.service.user.impl.converter.UserToUserVOConverter;
import hu.lamsoft.books.service.user.impl.vo.UserVO;

@Service
public class UserServiceImpl implements UserService {
  @Autowired
  private UserDao userDao;

  @Autowired
  private UserToUserVOConverter userToUserVOConverter;

  @Override
  public List<UserVO> getUsers(Integer page, Integer pageSize) {
    List<UserVO> result = new ArrayList<>();
    Page<User> userList = userDao.findAll(new PageRequest(page, pageSize));

    for (User user : userList) {
      result.add(userToUserVOConverter.convert(user));
    }

    return result;
  }

  @Override
  public void createUser(UserVO userVO) {
    User user = new User();
    user.setId(userVO.getId());
    user.setName(userVO.getName());
    user.setLoginName(userVO.getLoginName());
    user.setLoginPassword(userVO.getLoginPassword());
    userDao.save(user);
  }
}
