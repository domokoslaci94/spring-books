package hu.lamsoft.books.persistence.order.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import hu.lamsoft.books.persistence.book.entity.Book;
import hu.lamsoft.books.persistence.user.entity.User;

@Entity
@EntityListeners(AuditingEntityListener.class)

public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "USER_ID")
  private User user;
  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "BOOK_ID")
  private Book book;
  @CreatedDate
  private LocalDate createdDate;
  private LocalDate returnedDate;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Book getBook() {
    return book;
  }

  public void setBook(Book book) {
    this.book = book;
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
}
