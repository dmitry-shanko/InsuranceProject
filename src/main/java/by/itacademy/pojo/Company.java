package main.java.by.itacademy.pojo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "PK", sequenceName = "t_company_seq")
public class Company implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -180390801967064801L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "PK")
	private Integer id;

	@Column(name = "companyname")
	private String companyname;

	@ManyToMany(cascade = (CascadeType.ALL))
	@JoinTable(name = "t_user_company",
	joinColumns = { @JoinColumn(name = "f_company_id") },
	inverseJoinColumns = { @JoinColumn(name = "f_user_id") })
	private Set<User> users = new HashSet<User>();

	@OneToMany(mappedBy = "company")
	private Set<Insurance> insurances = new HashSet<Insurance>();
	/**
	 * Default constructor
	 */
	public Company()
	{
		this.id = -1;
		this.companyname = "";
	}
	/**
	 * @return the id
	 */
	public Integer getId() 
	{
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) 
	{
		if (null != id)
		{
			this.id = id;
		}
	}
	/**
	 * @return the companyname
	 */
	public String getCompanyname() 
	{
		return companyname;
	}
	/**
	 * @param companyname the companyname to set
	 */
	public void setCompanyname(String companyname) 
	{
		if (null != companyname)
		{
			this.companyname = companyname;
		}
	}
	/**
	 * @return the users
	 */
	public Set<User> getUsers() 
	{
		return users;
	}
	/**
	 * @param users the users to set
	 */
	public void setUsers(Set<User> users) 
	{
		if (null != users)
		{
			this.users = users;
		}
	}
	/**
	 * @return the insurances
	 */
	public Set<Insurance> getInsurances() 
	{
		return insurances;
	}
	/**
	 * @param insurances the insurances to set
	 */
	public void setInsurances(Set<Insurance> insurances) 
	{
		if (null != insurances)
		{
			this.insurances = insurances;
		}
	}
	/**
	 * Overridden Object.toString()
	 * @return the String representation of this Company object
	 */
	@Override
	public String toString() 
	{
		return "".concat(id + ". ").concat(companyname);
	}
	/**
	 * Overridden Object.equals()
	 * @return (null != obj)<p>
				&& (obj instanceof Company)<p>
				&& (((Company)obj).getCompanyname().equals(this.getCompanyname()))<p>
				&& (((Company)obj).getId().equals(this.getId()))<p>
				&& (((Company)obj).getInsurances().equals(this.getInsurances()))<p>
				&& (((Company)obj).getUsers().equals(this.getUsers()))<p>
	 */
	@Override
	public boolean equals(Object obj) 
	{
		return ((null != obj)
				&& (obj instanceof Company)
				&& (((Company)obj).getCompanyname().equals(this.getCompanyname()))
				&& (((Company)obj).getId().equals(this.getId()))
				&& (((Company)obj).getInsurances().equals(this.getInsurances()))
				&& (((Company)obj).getUsers().equals(this.getUsers())));
	}
	/**
	 * Overridden object.hashCode()
	 * @return final int hash = 17;<p>
		int result = 19;<p>
		result = hash * result + id;<p>
		result = hash * result + getClass().toString().hashCode();<p>
	 */
	@Override
	public int hashCode() 
	{
		final int hash = 17;
		int result = 19;
		result = hash * result + id;
		result = hash * result + getClass().toString().hashCode();
		return result;
	}
}
