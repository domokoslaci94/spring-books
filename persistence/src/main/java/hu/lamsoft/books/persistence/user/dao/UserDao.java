package hu.lamsoft.books.persistence.user.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hu.lamsoft.books.persistence.user.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
  @Override
  Page<User> findAll(Pageable pageable);
}
