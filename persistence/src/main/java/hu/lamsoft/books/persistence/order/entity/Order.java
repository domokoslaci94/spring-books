package hu.lamsoft.books.persistence.order.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import hu.lamsoft.books.persistence.book.entity.Book;
import hu.lamsoft.books.persistence.user.entity.User;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Order {
  User user;
  Book book;
}
