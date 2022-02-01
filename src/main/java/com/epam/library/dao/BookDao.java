package com.epam.library.dao;

import com.epam.library.entity.Book;

import java.util.Optional;

public interface BookDao {

    boolean create(Book book) throws DaoException;

    int update(Book book) throws DaoException;

    Optional<Book> getBookById(long bookId) throws DaoException;

    long getCountBooks() throws DaoException;

}
