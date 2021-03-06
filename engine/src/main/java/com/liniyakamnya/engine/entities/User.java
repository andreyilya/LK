package com.liniyakamnya.engine.entities;


import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * @author a.radkov
 *         Date: 16.07.12
 */
@Entity

@NamedQueries(
		@NamedQuery(name = "user.byLogin",
				query = "from User as u where u.login = :login")
)
public class User implements Serializable {
	private Long id;
	private String login;
	private String password;
	private String email;
	private ActionsForEmail actionsForEmail = new ActionsForEmail();

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Column
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Embedded
	public ActionsForEmail getActionsForEmail() {
		return actionsForEmail;
	}

	public void setActionsForEmail(ActionsForEmail actionsForEmail) {
		this.actionsForEmail = actionsForEmail;
	}
}
