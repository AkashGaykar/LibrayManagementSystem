package com.jsp.view;

import java.util.Scanner;

import com.jsp.controller.Controller;
import com.jsp.model.Book;
import com.jsp.model.Library;

public class View {
	static private Library library = new Library();

	public static Library getLibrary() {
		return library;
	}

	public static void setLibrary(Library library) {
		View.library = library;
	}

	static Controller controller = new Controller();

	// static Library library = new Library();
	static Scanner myInput = new Scanner(System.in);
	static {
		System.out.println("--- Welcome LMS ---");
		System.out.print("Enter name of Library : ");
		String libraryName = myInput.nextLine();
		library.setLibraryName(libraryName);
		System.out.print("Enter Address of library : ");

		library.setLibraryAddress(myInput.nextLine());
		System.out.println("Enter Pincode : ");
		library.setPincode(myInput.nextInt());
		myInput.nextLine();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println("Name ="+library.getLibraryName());
//		System.out.println("Address= "+library.getLibraryAddress());
//		System.out.println("Pin Code= "+library.getPincode());
		do {
			System.out.println("Select Option to Perform");
			System.out.println("1.Add Book \n2.Remove Book \n3.Update Book \n4.View Book \n0.Exit");
			System.out.print("Enter digit respective to desired option: ");
			byte userChoice = myInput.nextByte();
			myInput.nextLine();
			switch (userChoice) {
			case 1:
				Book book = new Book();
				System.out.print("Enter name of Book : ");
				book.setBookName(myInput.nextLine());
				System.out.print("Enter Author Name : ");
				book.setBookAuther(myInput.nextLine());
				System.out.print("Enter Price of book : ");
				book.setBookPrice(myInput.nextDouble());
				myInput.nextLine();
				controller.addBook(book);
				System.out.println("Book added successfully");
				break;
			case 2:
				
				System.out.println("Enter book name you want to remove");
				String bookToRemove = myInput.nextLine();
				if (controller.removeBook(bookToRemove)) {
					System.out.println("Requested book has been deleted");
				} else {
					System.out.println("Book does not Exists");
				}
				break;
			case 3:
				System.out.println("Enter Book name to update");
				Book bookExist = controller.getBook(myInput.nextLine());
				if (bookExist != null) {
					Book bookToUpdate=bookExist;
					System.out.println("what to update");
					System.out.println("1.Book Name \n2.Author Name\n3.Author Name");
					System.out.print("Enter digit respective to desired option");
					byte updateChoice = myInput.nextByte();
					myInput.nextLine();
					switch (updateChoice) {
					case 1:
						System.out.println("Enter Book Name to Update");
//						String newBookName = myInput.nextLine();
						bookToUpdate.setBookName(myInput.nextLine());
						break;
					case 2:
						System.out.println("Enter Book Author name to update");
//						String newAuthorName = myInput.nextLine();
						bookToUpdate.setBookName(myInput.nextLine());
						break;
					case 3:
						System.out.println("Enter Book Price to update");
						double newBookPrice = myInput.nextDouble();
						myInput.nextLine();
						bookToUpdate.setBookPrice(newBookPrice);
						break;
					default:
						System.out.println("---Invalid Selection ---");
						break;
					}
					if (controller.update(bookExist,bookToUpdate)) {
						System.out.println("Updated");
					} else {
						System.out.println("Not Updated");
					}
				} else {
					System.out.println("Book does not exist");
				}
				break;
			case 4:
				System.out.print("Enter Book name you are looking for :");
				Book fetchBook = controller.getBook(myInput.nextLine());
				if (fetchBook != null) {
					System.out.println("Book is available:");
					System.out.println("Details:");
					System.out.println(fetchBook);
				} else {
					System.out.println("Book is not Available");
				}
				break;
			case 0:
				myInput.close();
				System.out.println("---- EXITED ----");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid Selection");
				break;
			}
		} while (true);

	}

}
