package main.java.by.itacademy.resources;

public enum Constants 
{
//	MAINPAGE("/InsuranceProject/mainpage.jsp"),
//	LOGIN_ATTRIBUTE("login"),
//	SIGNIN_PAGE("/signin.jsp"),
//	ADMIN_PAGE("/InsuranceProject/admin.jsp"),
//	FILTER_SIGNIN_PAGE_REDIRECT("/InsuranceProject/signin.jsp"),
//	INSURER_ATTIBUTE("insurer"),
//	INSUR_PAGE("insur.jsp"),
//	INSURANCE_TYPES("types"),
//	LANG_ATTRIBUTE("lang");
	;
	private String content;
	private Constants(String s)
	{
		this.content = s;
	}
	
	public String getContent()
	{
		return content;
	}

}
