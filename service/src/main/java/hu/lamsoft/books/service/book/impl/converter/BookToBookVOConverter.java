package hu.lamsoft.books.service.book.impl.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import hu.lamsoft.books.persistence.book.entity.Book;

@Component
public class BookToBookVOConverter implements Converter<Book, hu.lamsoft.books.service.book.impl.vo.BookVO> {

  @Override
  public hu.lamsoft.books.service.book.impl.vo.BookVO convert(Book book) {

    if (book == null) {
      return null;
    }

    hu.lamsoft.books.service.book.impl.vo.BookVO
        ret = new hu.lamsoft.books.service.book.impl.vo.BookVO();
    ret.setAuthor(book.getAuthor());
    ret.setTitle(book.getTitle());
    ret.setPrice(book.getPrice());
    ret.setId(book.getId());
    return ret;
  }

}
