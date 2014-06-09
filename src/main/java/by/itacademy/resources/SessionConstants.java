package main.java.by.itacademy.resources;

public enum SessionConstants 
{
	LANG_ATTRIBUTE("lang"),
	LOGIN_ATTRIBUTE("login"),
	PREVSESSIONID_COOKIE("prevsessionid"),
	;
	private String content;
	private SessionConstants(String content)
	{
		this.content = content;
	}
	
	public String getContent()
	{
		return content;
	}

}
