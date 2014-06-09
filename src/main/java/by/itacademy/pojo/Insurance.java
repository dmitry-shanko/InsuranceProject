package main.java.by.itacademy.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
@Entity
@SequenceGenerator(name = "PK", sequenceName = "t_insurance_seq")
public class Insurance implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 108272362693229803L;

	/*
	 * see http://javatutor.net/articles/hibernate-types-udt
	 */
	//	@org.hibernate.annotations.Type(type = "test.db2.model.AddressTypeDescriptor")
	//    @Columns(columns = {
	//        @Column(name = "home_country"),
	//        @Column(name = "home_city"),
	//        @Column(name = "home_home"),
	//        @Column(name = "home_phone")
	//            })
	//    protected AddressType homeAddress;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "PK")
	private Integer id;

	@Column(name = "idinsurance")
	private Long idinsurance;

	@Column(name = "fio")
	private String fio;

	@Column(name = "price")
	private Double price;

	@ManyToOne
	@JoinColumn(name = "f_company_id")
	private Company company;

	/**
	 * @return the company
	 */
	public Company getCompany() {
		return company;
	}

	/**
	 * @param company the company to set
	 */
	public void setCompany(Company company) {
		this.company = company;
	}

	/**
	 * @return the idinsurance
	 */
	public Long getIdinsurance() {
		return idinsurance;
	}

	/**
	 * @param idinsurance the idinsurance to set
	 */
	public void setIdinsurance(Long idinsurance) {
		this.idinsurance = idinsurance;
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
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}
	/**
	 * Overridden Object.toString()
	 * @return the String representation of this Insurance object
	 */
	@Override
	public String toString() 
	{
		return "".concat(idinsurance + "");
	}
	/**
	 * Overridden Object.equals()
	 * @return (null != obj)<p>
				&& (obj instanceof Insurance)<p>
				&& (((Insurance)obj).getIdinsurance().equals(this.getIdinsurance()))<p>
				&& (((Insurance)obj).getId().equals(this.getId()))<p>
				&& (((Insurance)obj).getCompany().equals(this.getCompany()))<p>
				&& (((Insurance)obj).getFio().equals(this.getFio()))<p>
	 */
	@Override
	public boolean equals(Object obj) 
	{
		return ((null != obj)
				&& (obj instanceof Insurance)
				&& (((Insurance)obj).getIdinsurance().equals(this.getIdinsurance()))
				&& (((Insurance)obj).getId().equals(this.getId()))
				&& (((Insurance)obj).getCompany().equals(this.getCompany()))
				&& (((Insurance)obj).getFio().equals(this.getFio())));
	}
	/**
	 * Overridden object.hashCode()
	 * @return 		final int hash = 111;<p>
	 *	int result = 191;<p>
	 *	result = hash * result + id;<p>
	 *	result = hash * result + idinsurance.hashCode();<p>
	 *	result = hash * result + getClass().toString().hashCode();<p>
	 */
	@Override
	public int hashCode() 
	{
		final int hash = 111;
		int result = 191;
		result = hash * result + id;
		result = hash * result + idinsurance.hashCode();
		result = hash * result + getClass().toString().hashCode();
		return result;
	}
}
