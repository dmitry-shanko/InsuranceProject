package main.java.by.itacademy.pojo;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
/**
 * Bean for Role instance. Uses hibernate annotation
 */
@Entity
@SequenceGenerator(name = "PK", sequenceName = "t_role_seq")
public class Role implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1464241500995615514L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "PK")
	private Integer id;

	@Column(name = "rolename")
	private String rolename;

	@OneToMany(mappedBy = "role")
	private Set<User> users;
	/**
	 * Default constructor
	 */
	public Role()
	{
		this.id = -1;
		this.rolename = "";
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
	 * @return the rolename
	 */
	public String getRolename() 
	{
		return rolename;
	}
	/**
	 * @param rolename the rolename to set
	 */
	public void setRolename(String rolename) 
	{
		if (null != rolename)
		{
			this.rolename = rolename;
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
	 * Overridden object.toString()
	 * @return the String representation of this Role entity
	 */
	@Override
	public String toString() 
	{
		StringBuilder sb = new StringBuilder();
		sb.append("id: ");
		sb.append(id);
		sb.append("\n");
		sb.append("rolename: ");
		sb.append(rolename);
		sb.append("\n");
		return sb.toString();
	}
	/**
	 * Overridden object.equals(Object obj)
	 * @return ((null != obj)<p>
				&& (obj instanceof Role)<p>
				&& (((Role)obj).getId().equals(this.getId()))<p>
				&& (((Role)obj).getRolename().equals(this.getRolename()))<p>
				&& (((Role)obj).getUsers().equals(this.getUsers())));<p>
	 */
	@Override
	public boolean equals(Object obj) 
	{
		return ((null != obj)
				&& (obj instanceof Role)
				&& (((Role)obj).getId().equals(this.getId()))
				&& (((Role)obj).getRolename().equals(this.getRolename()))
				&& (((Role)obj).getUsers().equals(this.getUsers())));
	}
	/**
	 * Overridden object.hashCode()
	 * @return final int hash = 13;<p>
		int result = 15;<p>
		result = hash * result + id;<p>
		result = hash * result + getClass().toString().hashCode();<p>
		return result;<p>
	 */
	@Override
	public int hashCode() 
	{
		final int hash = 13;
		int result = 15;
		result = hash * result + id;
		result = hash * result + getClass().toString().hashCode();
		return result;
	}
}
