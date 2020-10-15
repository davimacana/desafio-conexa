/**
 * 
 */
package com.desafio.conexa.security.jwt;

import java.util.Collection;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.desafio.conexa.entity.Usuario;

/**
 * @author Davi Maçana
 *
 */
public class UserPrinciple implements UserDetails {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String username;
	private String password;

	public UserPrinciple(Long id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public static UserPrinciple build(Usuario user) {
		return new UserPrinciple(user.getIdUsuario(), user.getUsuario(), user.getSenha());
	}

	public Long getId() {
		return id;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserPrinciple user = (UserPrinciple) o;
		return Objects.equals(id, user.id);
	}
}