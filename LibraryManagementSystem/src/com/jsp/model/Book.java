package com.jsp.model;

public class Book {
	private String bookName;
	private String bookAuthor;
	private double bookPrice;
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName=bookName;
	}
	public String getBookAuther() {
		return bookAuthor;
	}
	public void setBookAuther(String bookAuther) {
		this.bookAuthor=bookAuther;
	}
	public double getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(double bookPrice) {
		this.bookPrice=bookPrice;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Book Name ="+bookName+ "\nAuthor Name = "+bookAuthor+"\nBook Price = "+bookPrice;
	}
}
