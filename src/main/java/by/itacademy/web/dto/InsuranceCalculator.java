package main.java.by.itacademy.web.dto;

import java.math.BigDecimal;
import java.math.RoundingMode;

import main.java.by.itacademy.pojo.Insurance;
import main.java.by.itacademy.web.dto.exception.LogicException;

public class InsuranceCalculator 
{
	private int cartype_int;
	private int carcountry_int;
	private int carvalue_int;
	private int term_int;
	private int propiska_int;
	private int driverage_int;
	private String vin;
	private String regnum;
	private int onfirst_int;
	private int dtp_int;
	private int k3_int;
	private String fio;
	private String adress;
	private String namecar;
	private double price;
	private double price1;
	private double price2;
	private double price3;
	private int idcompany;
	private boolean flag1;
	private boolean flag2;
	private boolean flag3;
	private boolean flag4;
	private long idinsurance;
	
	public InsuranceCalculator()
	{
		
	}

	public Insurance calculatedInsurance() throws LogicException
	{
		return new Insurance();
	}

	/**
	 * @return the cartype_int
	 */
	public int getCartype_int() {
		return cartype_int;
	}

	/**
	 * @param cartype_int the cartype_int to set
	 */
	public void setCartype_int(int cartype_int) {
		this.cartype_int = cartype_int;
	}

	/**
	 * @return the carcountry_int
	 */
	public int getCarcountry_int() {
		return carcountry_int;
	}

	/**
	 * @param carcountry_int the carcountry_int to set
	 */
	public void setCarcountry_int(int carcountry_int) {
		this.carcountry_int = carcountry_int;
	}

	/**
	 * @return the carvalue_int
	 */
	public int getCarvalue_int() {
		return carvalue_int;
	}

	/**
	 * @param carvalue_int the carvalue_int to set
	 */
	public void setCarvalue_int(int carvalue_int) {
		this.carvalue_int = carvalue_int;
	}

	/**
	 * @return the term_int
	 */
	public int getTerm_int() {
		return term_int;
	}

	/**
	 * @param term_int the term_int to set
	 */
	public void setTerm_int(int term_int) {
		this.term_int = term_int;
	}

	/**
	 * @return the propiska_int
	 */
	public int getPropiska_int() {
		return propiska_int;
	}

	/**
	 * @param propiska_int the propiska_int to set
	 */
	public void setPropiska_int(int propiska_int) {
		this.propiska_int = propiska_int;
	}

	/**
	 * @return the driverage_int
	 */
	public int getDriverage_int() {
		return driverage_int;
	}

	/**
	 * @param driverage_int the driverage_int to set
	 */
	public void setDriverage_int(int driverage_int) {
		this.driverage_int = driverage_int;
	}

	/**
	 * @return the onfirst_int
	 */
	public int getOnfirst_int() {
		return onfirst_int;
	}

	/**
	 * @param onfirst_int the onfirst_int to set
	 */
	public void setOnfirst_int(int onfirst_int) {
		this.onfirst_int = onfirst_int;
	}

	/**
	 * @return the dtp_int
	 */
	public int getDtp_int() {
		return dtp_int;
	}

	/**
	 * @param dtp_int the dtp_int to set
	 */
	public void setDtp_int(int dtp_int) {
		this.dtp_int = dtp_int;
	}

	/**
	 * @return the k3_int
	 */
	public int getK3_int() {
		return k3_int;
	}

	/**
	 * @param k3_int the k3_int to set
	 */
	public void setK3_int(int k3_int) {
		this.k3_int = k3_int;
	}

	/**
	 * @return the fio
	 */
	public String getFio() {
		return fio;
	}

	/**
	 * @param fio the fio to set
	 */
	public void setFio(String fio) {
		this.fio = fio;
	}

	/**
	 * @return the adress
	 */
	public String getAdress() {
		return adress;
	}

	/**
	 * @param adress the adress to set
	 */
	public void setAdress(String adress) {
		this.adress = adress;
	}

	/**
	 * @return the namecar
	 */
	public String getNamecar() {
		return namecar;
	}

	/**
	 * @param namecar the namecar to set
	 */
	public void setNamecar(String namecar) {
		this.namecar = namecar;
	}

	/**
	 * @return the regnum
	 */
	public String getRegnum() {
		return regnum;
	}

	/**
	 * @param regnum the regnum to set
	 */
	public void setRegnum(String regnum) {
		this.regnum = regnum;
	}

	/**
	 * @return the vin
	 */
	public String getVin() {
		return vin;
	}

	/**
	 * @param vin the vin to set
	 */
	public void setVin(String vin) {
		this.vin = vin;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	public boolean calculate()
	{
		this.price = (70 * (Math.random() + 1));
		double price1 = price * (Math.random() + 1);
		double price2 = price * (Math.random() + 1);
		double price3 = price * (Math.random() + 1);
		this.setPrice1(new BigDecimal(price1).setScale(2, RoundingMode.UP).doubleValue());
		this.setPrice2(new BigDecimal(price2).setScale(2, RoundingMode.UP).doubleValue());
		this.setPrice3(new BigDecimal(price3).setScale(2, RoundingMode.UP).doubleValue());
		System.out.println("price1: " + getPrice1());
		System.out.println("price2: " + getPrice2());
		System.out.println("price3: " + getPrice3());
		return true;
	}

	/**
	 * @return the price1
	 */
	public double getPrice1() {
		return price1;
	}

	/**
	 * @param price1 the price1 to set
	 */
	protected void setPrice1(double price1) {
		this.price1 = price1;
	}

	/**
	 * @return the price2
	 */
	public double getPrice2() {
		return price2;
	}

	/**
	 * @param price2 the price2 to set
	 */
	protected void setPrice2(double price2) {
		this.price2 = price2;
	}

	/**
	 * @return the price3
	 */
	public double getPrice3() {
		return price3;
	}

	/**
	 * @param price3 the price3 to set
	 */
	protected void setPrice3(double price3) {
		this.price3 = price3;
	}

	/**
	 * @return the idcompany
	 */
	public int getIdcompany() {
		return idcompany;
	}

	/**
	 * @param idcompany the idcompany to set
	 */
	public void setIdcompany(int idcompany) {
		this.idcompany = idcompany;
	}

	/**
	 * @return the flag1
	 */
	public boolean isFlag1() {
		return flag1;
	}

	/**
	 * @param flag1 the flag1 to set
	 */
	public void setFlag1(boolean flag1) {
		this.flag1 = flag1;
	}

	/**
	 * @return the flag2
	 */
	public boolean isFlag2() {
		return flag2;
	}

	/**
	 * @param flag2 the flag2 to set
	 */
	public void setFlag2(boolean flag2) {
		this.flag2 = flag2;
	}

	/**
	 * @return the flag3
	 */
	public boolean isFlag3() {
		return flag3;
	}

	/**
	 * @param flag3 the flag3 to set
	 */
	public void setFlag3(boolean flag3) {
		this.flag3 = flag3;
	}

	/**
	 * @return the flag4
	 */
	public boolean isFlag4() {
		return flag4;
	}

	/**
	 * @param flag4 the flag4 to set
	 */
	public void setFlag4(boolean flag4) {
		this.flag4 = flag4;
	}

	/**
	 * @return the idinsurance
	 */
	public long getIdinsurance() {
		return idinsurance;
	}

	/**
	 * @param idinsurance the idinsurance to set
	 */
	public void setIdinsurance(long idinsurance) {
		this.idinsurance = idinsurance;
	}
	


}
