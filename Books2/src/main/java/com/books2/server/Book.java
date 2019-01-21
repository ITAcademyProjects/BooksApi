package com.books2.server;

public class Book {
	
	private String title;
	private int numPages;
	private String id;
	
	private static int counter=0;
	//Constructor vacío para integrar con base de datos
	public Book() {
		this.id="B" + counter;
		counter++;
	
	}
	//Constructor Book
	public Book(String title, int numPages)throws Exception {
		if(title.equals("")) throw new Exception();
		if(numPages<=0) throw new Exception();
		
		this.title=title;
		this.numPages=numPages;
		this.id="B" + counter;
		counter++;
	
	}

	public String getId() {
		return id;
	}
}
