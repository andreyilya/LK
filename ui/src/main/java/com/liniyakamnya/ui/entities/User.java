package com.liniyakamnya.ui.entities;


import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * @author a.radkov
 *         Date: 16.07.12
 */
@Entity
@NamedQueries({
		@NamedQuery(name = "user.byLogin",
				query = "from User as u where u.login = :login"),

		@NamedQuery(name = "user.all",
				query = "from User")}
)
public class User implements Identifiable {
	private Long id;
	private String login;
	private String password;
	private String email;
	private ActionsForEmail actionsForEmail = new ActionsForEmail();
	private List<Role> roles = new ArrayList<Role>();
	private String roless= StringUtils.EMPTY;

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

	@ManyToMany(fetch = FetchType.LAZY)
	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@Embedded
	public ActionsForEmail getActionsForEmail() {
		return actionsForEmail;
	}

	public void setActionsForEmail(ActionsForEmail actionsForEmail) {
		this.actionsForEmail = actionsForEmail;
	}

    public String getRoless() {
        return roless;
    }

    public void setRoless(String roless) {
        this.roless = roless;
    }
}
