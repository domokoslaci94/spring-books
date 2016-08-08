package hu.lamsoft.books.service.book;

import java.util.List;
import hu.lamsoft.books.service.book.impl.vo.BookVO;

public interface BookService {

	List<BookVO> getBooks(Integer page, Integer pageSize);
	
	List<BookVO> getBooks(String title);
	
	BookVO getBook(Integer id);
	
	void createBook(BookVO book);
	
}

