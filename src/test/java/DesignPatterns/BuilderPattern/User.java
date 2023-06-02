package DesignPatterns.BuilderPattern;

public class User {
	
	private String name;
	private String job;
	
	
	public User(String name,String job)
	{
		this.name=name;
		this.job=job;
		
	}
	
//	public User(UserBuilder builder)
//	{
//		this.name=builder.name;
//		this.job=builder.job;
//		
//	}


	
	public String getName() {
		return name;
	}

	public String getJob() {
		return job;
	}

	

}
