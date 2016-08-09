package hu.lamsoft.books.service.order.impl.vo;

import java.time.LocalDate;
import hu.lamsoft.books.service.book.impl.vo.BookVO;
import hu.lamsoft.books.service.user.impl.vo.UserVO;

public class OrderVO {
  private Integer id;
  private UserVO userVO;
  private BookVO bookVO;
  private LocalDate createdDate;
  private LocalDate returnedDate;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public UserVO getUserVO() {
    return userVO;
  }

  public void setUserVO(UserVO user) {
    this.userVO = user;
  }

  public BookVO getBookVO() {
    return bookVO;
  }

  public void setBookVO(BookVO book) {
    this.bookVO = book;
  }

  public LocalDate getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(LocalDate createdDate) {
    this.createdDate = createdDate;
  }

  public LocalDate getReturnedDate() {
    return returnedDate;
  }

  public void setReturnedDate(LocalDate returnedDate) {
    this.returnedDate = returnedDate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    OrderVO orderVO = (OrderVO) o;

    if (!id.equals(orderVO.id)) {
      return false;
    }
    if (!userVO.equals(orderVO.userVO)) {
      return false;
    }
    if (!bookVO.equals(orderVO.bookVO)) {
      return false;
    }
    if (!createdDate.equals(orderVO.createdDate)) {
      return false;
    }
    return returnedDate != null ? returnedDate.equals(orderVO.returnedDate)
        : orderVO.returnedDate == null;

  }

  @Override
  public int hashCode() {
    int result = id.hashCode();
    result = 31 * result + userVO.hashCode();
    result = 31 * result + bookVO.hashCode();
    result = 31 * result + createdDate.hashCode();
    result = 31 * result + (returnedDate != null ? returnedDate.hashCode() : 0);
    return result;
  }
}
