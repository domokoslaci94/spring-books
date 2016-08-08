package hu.lamsoft.books.service.user.impl.vo;

import java.time.LocalDate;

/**
 * Created by ui2016 on 2016.08.08..
 */
public class UserVO {
  private Integer id;
  private String name;
  private String loginName;
  private String loginPassword;
  private LocalDate registrationDate;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLoginName() {
    return loginName;
  }

  public void setLoginName(String loginName) {
    this.loginName = loginName;
  }

  public String getLoginPassword() {
    return loginPassword;
  }

  public void setLoginPassword(String loginPassword) {
    this.loginPassword = loginPassword;
  }

  public LocalDate getRegistrationDate() {
    return registrationDate;
  }

  public void setRegistrationDate(LocalDate registrationDate) {
    this.registrationDate = registrationDate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    UserVO userVO = (UserVO) o;

    if (!id.equals(userVO.id)) {
      return false;
    }
    if (!name.equals(userVO.name)) {
      return false;
    }
    if (!loginName.equals(userVO.loginName)) {
      return false;
    }
    if (!loginPassword.equals(userVO.loginPassword)) {
      return false;
    }
    return registrationDate.equals(userVO.registrationDate);

  }

  @Override
  public int hashCode() {
    int result = id.hashCode();
    result = 31 * result + name.hashCode();
    result = 31 * result + loginName.hashCode();
    result = 31 * result + loginPassword.hashCode();
    result = 31 * result + registrationDate.hashCode();
    return result;
  }
}
