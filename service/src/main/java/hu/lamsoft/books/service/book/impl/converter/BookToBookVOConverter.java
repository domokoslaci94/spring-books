package hu.lamsoft.books.service.book.impl.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import hu.lamsoft.books.persistence.book.entity.Book;
import hu.lamsoft.books.service.book.impl.vo.BookVO;

@Component
public class BookToBookVOConverter implements Converter<Book, BookVO> {

  @Override
  public BookVO convert(Book book) {

    if (book == null) {
      return null;
    }

    BookVO ret = new BookVO();
    ret.setAuthor(book.getAuthor());
    ret.setTitle(book.getTitle());
    ret.setPrice(book.getPrice());
    ret.setId(book.getId());
    return ret;
  }

}
