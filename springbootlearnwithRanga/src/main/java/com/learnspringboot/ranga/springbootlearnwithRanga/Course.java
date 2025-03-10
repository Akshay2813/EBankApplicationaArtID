package com.learnspringboot.ranga.springbootlearnwithRanga;

public class Course {
	private int id;
	private String bookName;
	private String authorName;
	
	public Course(int id, String bookName, String authorName)
	{
		super();
		this.id=id;
		this.bookName=bookName;
		this.authorName=authorName;
	}
	



	public int getId() {
		return id;
	}
	public String getBookName() {
		return bookName;
	}
	public String getAuthorName() {
		return authorName;
	}


	@Override
	public String toString() {
		return "Course [id=" + id + ", bookName=" + bookName + ", authorName=" + authorName + "]";
	}
	
	

}
