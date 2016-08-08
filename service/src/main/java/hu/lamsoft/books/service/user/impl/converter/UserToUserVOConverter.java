package hu.lamsoft.books.service.user.impl.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import hu.lamsoft.books.persistence.user.entity.User;
import hu.lamsoft.books.service.user.impl.vo.UserVO;

@Component
public class UserToUserVOConverter implements Converter<User, UserVO> {
  @Override
  public UserVO convert(User user) {
    UserVO result = new UserVO();
    result.setId(user.getId());
    result.setLoginName(user.getLoginName());
    result.setLoginPassword(user.getLoginPassword());
    result.setName(user.getName());
    return result;
  }
}
