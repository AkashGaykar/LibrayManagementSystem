package com.jsp.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.jsp.model.Book;
import com.jsp.model.Library;
import com.jsp.view.View;

public class Controller {
	private Library library = View.getLibrary();

	public void addBook(Book book) { // for add book
		List<Book> books = library.getBooks();
		if (books == null) { //Booklist is empty
			books = new ArrayList<>();//we created new arrayList for BookList
		}
		books.add(book); //add book new temp
		library.setBooks(books); //book is added in main library list
	}
	
	public boolean removeBook(String bookName) { //For Delete Operation
		Book book = getBook(bookName);
		if (book != null) { //book list is not empty
			List<Book> books = library.getBooks();
			boolean remove = books.remove(book);
			library.setBooks(books); //delete the book and update in library bookList
			return true;
		}
		return false;
	}
	
	public Book getBook(String bookName) {  //For Fetching Book Details
		List<Book> books = library.getBooks();
		if (books != null) {// check book of list exist
			for (Book book : books) { // iterating books for searching book name
				if (book.getBookName().equalsIgnoreCase(bookName)) {
					return book;
				}
			}
		}
		return null;
	}

	public boolean update(Book bookExist, Book bookUpdate) { // For updation of Book
		List<Book> books = library.getBooks();
		for (Book book : books) {
			if (book.getBookName().equalsIgnoreCase(bookExist.getBookName())){
				books.remove(bookExist); //remove the existent book
				books.add(bookUpdate); //for updating book
				library.setBooks(books); //add updated book in list 
				return true;
			}
		}
		
		return false;
	}
}
