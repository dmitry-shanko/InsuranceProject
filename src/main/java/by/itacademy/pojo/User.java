package main.java.by.itacademy.pojo;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Bean for User instance. Uses hibernate annotation
 */
@Entity
@SequenceGenerator(name = "PK", sequenceName = "t_user_seq")
public class User implements Serializable 
{

	private static final long serialVersionUID = 4L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "PK")
	private Integer id;

	@Column(name = "firstname")
	private String firstname;

	@Column(name = "lastname")
	private String lastname;

	@Column(name = "cell_phone")
	private String cellphone;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;	

	@ManyToOne
	@JoinColumn(name = "f_role_id")
	private Role role;

	@ManyToMany(cascade = (CascadeType.ALL))
	@JoinTable(name = "t_user_company",
	joinColumns = { @JoinColumn(name = "f_user_id") },
	inverseJoinColumns = { @JoinColumn(name = "f_company_id") })
	private Set<Company> companies = new HashSet<Company>();
	/**
	 * Default constructor
	 */
	public User() 
	{
		this.cellphone = "";
		this.email = "";
		this.firstname = "";
		this.id = -1;
		this.lastname = "";
		this.password = "";
		this.role = new Role();
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
	 * @return the firstname
	 */
	public String getFirstname()
	{
		return firstname;
	}
	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname)
	{
		if (null != firstname)
		{
			this.firstname = firstname;
		}
	}
	/**
	 * @return the lastname
	 */
	public String getLastname()
	{
		return lastname;
	}
	/**
	 * @param lastname the lastname to set
	 */	
	public void setLastname(String lastname)
	{
		if (null != lastname)
		{
			this.lastname = lastname;
		}
	}
	/**
	 * @return the cellphone
	 */
	public String getCellphone()
	{
		return cellphone;
	}
	/**
	 * @param cellphone the cellphone to set
	 */	
	public void setCellphone(String cellphone)
	{
		if (null != cellphone)
		{
			this.cellphone = cellphone;
		}
	}
	/**
	 * @return the email
	 */
	public String getEmail()
	{
		return email;
	}
	/**
	 * @param email the email to set
	 */	
	public void setEmail(String email)
	{
		if (null != email)
		{
			this.email = email;
		}
	}	
	/**
	 * @return the password
	 */
	public String getPassword()
	{
		return password;
	}
	/**
	 * @param password the password to set
	 */	
	public void setPassword(String password)
	{
		if (null != password)
		{
			this.password = password;
		}
	}
	/**
	 * @return the role
	 */
	public Role getRole()
	{
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(Role role)
	{
		if (null != role)
		{
			this.role = role;
		}
	}
	/**
	 * @return the company
	 */
	public Set<Company> getCompanies() 
	{
		return companies;
	}
	/**
	 * @param company the company to set
	 */
	public void setCompanies(Set<Company> companies) 
	{
		if (null != companies)
		{
			this.companies = companies;
		}
	}
	/**
	 * Overridden object.toString()
	 * @return the String representation of this User entity
	 */
	@Override
	public String toString() 
	{
		StringBuilder sb = new StringBuilder();
		sb.append("id: ");
		sb.append(id);
		sb.append("\n");
		sb.append("firstname: ");
		sb.append(firstname);
		sb.append("\n");
		sb.append("lastname: ");
		sb.append(lastname);
		sb.append("\n");
		sb.append("cellPhone: ");
		sb.append(cellphone);
		sb.append("\n");
		return sb.toString();
	}
	/**
	 * Overridden object.equals(Object obj)
	 * @return (null != obj)<p>
				&& (obj instanceof User)<p>
				&& (((User)obj).getCellphone().equals(this.getCellphone()))<p>
				&& (((User)obj).getEmail().equals(this.getEmail()))<p>
				&& (((User)obj).getFirstname().equals(this.getFirstname()))<p>
				&& (((User)obj).getId().equals(this.getId()))<p>
				&& (((User)obj).getLastname().equals(this.getLastname()))<p>
				&& (((User)obj).getPassword().equals(this.getPassword()))<p>
				&& (((User)obj).getRole().equals(this.getRole()))<p>
				&& (((User)obj).getCompanies().equals(this.getCompanies()))<p>
	 */
	@Override
	public boolean equals(Object obj) 
	{
		return ((null != obj)
				&& (obj instanceof User)
				&& (((User)obj).getCellphone().equals(this.getCellphone()))
				&& (((User)obj).getEmail().equals(this.getEmail()))
				&& (((User)obj).getFirstname().equals(this.getFirstname()))
				&& (((User)obj).getId().equals(this.getId()))
				&& (((User)obj).getLastname().equals(this.getLastname()))
				&& (((User)obj).getPassword().equals(this.getPassword()))
				&& (((User)obj).getRole().equals(this.getRole()))
				&& (((User)obj).getCompanies().equals(this.getCompanies())));
	}
	/**
	 * Overridden object.hashCode()
	 * @return final int hash = 11;<p>
		int result = 13;<p>
		result = hash * result + id;<p>
		result = hash * result + getClass().toString().hashCode();<p>
		return result;<p>
	 */
	@Override
	public int hashCode() 
	{
		final int hash = 11;
		int result = 13;
		result = hash * result + id;
		result = hash * result + getClass().toString().hashCode();
		return result;
	}
}