package hu.lamsoft.books.service.book.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import hu.lamsoft.books.persistence.book.dao.BookDao;
import hu.lamsoft.books.persistence.book.entity.Book;
import hu.lamsoft.books.service.book.BookService;
import hu.lamsoft.books.service.book.impl.converter.BookToBookVOConverter;
import hu.lamsoft.books.service.book.impl.vo.BookVO;

@Service
public class BookServiceImpl implements BookService {

  @Autowired
  private BookDao bookDao;

  @Autowired
  private BookToBookVOConverter converter;

  @Override
  public List<BookVO> getBooks(Integer page, Integer pageSize) {
    Page<Book> bookPage = bookDao.findAll(new PageRequest(page, pageSize));
    List<BookVO> ret = new ArrayList<>(bookPage.getSize());

    for (Book book : bookPage) {
      ret.add(converter.convert(book));
    }

    return ret;
  }

  @Override
  public List<BookVO> getBooks(String title) {
    List<Book> books = bookDao.findByTitle(title);
    List<BookVO> ret = new ArrayList<>(books.size());

    for (Book book : books) {
      ret.add(converter.convert(book));
    }

    return ret;
  }

  @Override
  public BookVO getBook(Integer id) {
    return converter.convert(bookDao.findOne(id));
  }

  @Override
  public void createBook(BookVO book) {
    Book bookEntity = new Book();
    bookEntity.setAuthor(book.getAuthor());
    bookEntity.setTitle(book.getTitle());
    bookEntity.setPrice(book.getPrice());
    bookDao.save(bookEntity);
  }

}
