package com.workshop2.entity;

public class Movie {
	private String title;
	private String director; 
	private String genre;
	private String actor;
	private int releaseYear;
	private int runTime;
	private String rating;
	
	
	public Movie(String title,String director, String genre,String actor, String rating)
	{
		this.title = title;
		this.director = director;
		this.genre = genre;
		this.actor = actor;
		this.rating = rating;
	}
	
	public Movie(String title,String director, String genre,String actor, int releaseYear,int runTime) 
	{
		this.title = title;
		this.director = director;
		this.genre = genre;
		this.actor = actor;
		this.releaseYear=releaseYear;
		this.runTime=runTime;
	}

	public Movie(String title,String director, String genre,String actor, int releaseYear,int runTime, String rating) 
	{
		this(title,director,genre,actor,releaseYear,runTime);
		this.rating = rating;
	}

	public String getTitle() {
		return title;
	}

	public String getDirector() {
		return director;
	}

	public String getGenre() {
		return genre;
	}

	public String getActor() {
		return actor;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public int getRunTime() {
		return runTime;
	}

	public String getRating() {
		return rating;
	}

	public void printTitle() {
		System.out.println("----------------------------------------------------------------------");
		System.out.printf("%15s %18s %15s %15s %10s %7s %7s","제목","감독","장르","주연","개봉년도","런타임","등급\n");
		System.out.println("----------------------------------------------------------------------");
	}
	
	public void printContent(Movie A) {
			//printf("%-20s\t%-7s\t%-7s\t%-7s\t,title,director,genre,actor)
			// ,releaseYear,runTime,rating를 if문으로 뺌 (선생님답)
			
			//String str = String.formate(format, args) // 투스트링 기본형
			//String str = String.formate("%-20s\t%-7s\t%-7s\t%-7s\t",title,director,genre,actor)
		
			System.out.printf("%-20s %-10s %-10s %-10s ",A.getTitle(),A.getDirector(),A.getGenre(),A.getActor());
			
			if(A.getReleaseYear()!=0)System.out.printf("%6d년",A.getReleaseYear());
			else System.out.printf("%8s","N/A");
			
			if(A.getRunTime()!=0)System.out.printf("%5d분",A.getRunTime());
			else System.out.printf("%8s","N/A");
			
			if(A.getRating()!=null)System.out.printf("%10s",A.getRating());
			else System.out.printf("%8s","N/A");
			
			
				
			System.out.println();
			
			
			
	}
	
	
}
