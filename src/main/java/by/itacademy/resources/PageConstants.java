package main.java.by.itacademy.resources;

public enum PageConstants 
{
	MAINPAGE_DISPATCHER("mainpage.jsp"),
	ADMIN_DISPATCHER("admin.jsp"),
	SIGNIN_PAGE("signin.jsp"),
	END_DISPATCHER("end.jsp"),
	RESULT_DISPATCHER("result.jsp"),
	ERROR_DISPATCHER("/WEB-INF/error/error.jsp")
	;
	private String content;
	private PageConstants(String content)
	{
		this.content = content;
	}
	
	public String getContent()
	{
		return content;
	}

}
