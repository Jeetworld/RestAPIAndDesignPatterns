package DesignPatterns.BuilderPattern;

public class UserBuilder {
	
//	String name;
//	String job;
	
	private String name;
	private String job;
	
	
	
	public static UserBuilder builder()
	{
		return new UserBuilder();
		
	}
	
	public UserBuilder setName(String name)
	{
		this.name=name;
		return this;
	}
	
	public UserBuilder setJob(String job)
	{
		this.job=job;
		return this;
	}
	
	
	public User build()
	{
		return new User(name,job);
	}
	
//	public User build()
//	{
//		return new User(this);
//	}

}
