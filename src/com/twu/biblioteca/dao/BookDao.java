package com.twu.biblioteca.dao;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.twu.biblioteca.model.BookModel;

import java.util.List;

public class BookDao {

    private List<BookModel> bookList;

    public BookDao() {
        bookList = Lists.newArrayList(
                new BookModel("Lord of the Rings", "J.R.R.Tolkien", 1954, 3),
                new BookModel("Jane Eyre", "Charlotte Brontë", 1847, 2),
                new BookModel("Gone with the Wind", "Margaret Mitchell", 1936, 2),
                new BookModel("Peter Pan", "James Barrie", 1904),
                new BookModel("A Tale of Two Cities", "Charles Dickens", 1859, 0)
        );
    }

    public List<BookModel> getBookList() {
        return bookList;
    }

    public List<BookModel> getAvailableBookList() {

        return Lists.newArrayList(Collections2.filter(bookList, new Predicate<BookModel>(){
            @Override
            public boolean apply(BookModel bookModel) {
                if( bookModel.getBookNumber().equals(0) )
                    return false;
                return true;
            }
        }));
    }

    public boolean checkoutBook(String bookName) {

        for ( BookModel book : bookList ) {
            if (book.getBookName().equals(bookName) && !book.getBookNumber().equals(0) ) {
                book.setBookNumber(book.getBookNumber()-1);
                return true;
            }
        }

        return false;
    }

    public boolean returnBook(String bookName) {

        for ( BookModel book : bookList ) {
            if (book.getBookName().equals(bookName) ) {
                book.setBookNumber(book.getBookNumber()+1);
                return true;
            }
        }

        return false;
    }

}
