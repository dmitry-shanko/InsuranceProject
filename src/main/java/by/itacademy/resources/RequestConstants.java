package main.java.by.itacademy.resources;

public enum RequestConstants 
{
	PASSWORD_PARAMETER("pass"),
	EMAIL_PARAMETER("email"),
	COMMAND_PARAMETER("command"),
	YEAR_PARAMETER("year"),
	PRICE_PARAMETER("price"),
	TYPE_PARAMETER("type"),
	LANG_PARAMETER("lang"),
	PAGE_PARAMETER("page"),
	ID_PARAMETER("id"),
	PREVID_PARAMETER("previd"),
	INSURANCES_ATTRIBUTE("insurances"),
	CARTYPE_PARAMETER("cartype"),
	CARCOUNTRY_PARAMETER("carcountry"),
	CARVALUE_PARAMETER("carvalue"),
	TERM_PARAMETER("term"),
	PROPISKA_PARAMETER("propiska"),
	DRIVERAGE_PARAMETER("driveage"),
	ERRORMASSAGE_ATTRIBUTE("errormassage"),
	FIO_PARAMETER("fio"),
	ADRESS_PARAMETER("adress"),
	NAMECAR_PARAMETER("namecar"),
	VIN_PARAMETER("vin"),
	REGNUM_PARAMETER("regnum"),
	ONFIRST_PARAMETER("onfirst"),
	DTP_PARAMETER("dtp"),
	K3_PARAMETER("k3"),
	INSURANCECALC_ATTRIBUTE("insurancecalcutalor"),
	OPTIONRADIOS_PARAMETER("optionsRadios"),
	IDCOMPANY_PARAMETER("idcompany"),
	IDINSURANCE_PAREMETER("idinsurance"),
	SEARCHINSURANCE_ATTRIBUTE("searchinsurance"),
	PRICE1_ATTRIBUTE("price1"),
	PRICE2_ATTRIBUTE("price2"),
	PRICE3_ATTRIBUTE("price3"),
	;
	private String content;
	private RequestConstants(String s)
	{
		this.content = s;
	}
	
	public String getContent()
	{
		return content;
	}

}
