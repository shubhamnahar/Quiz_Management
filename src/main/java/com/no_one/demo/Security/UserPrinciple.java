package com.no_one.demo.Security;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.no_one.demo.model.UserTable;

public class UserPrinciple implements UserDetails {

	
	private UserTable usertable;
	
	
	public UserPrinciple(UserTable usertable) {
		super();
		this.usertable = usertable;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return Collections.singleton(new SimpleGrantedAuthority("ADMIN"));
	}

	private Collection<? extends GrantedAuthority> getAuthorities(UserTable user) {
	    System.out.println("role.getName()::::-----"+user.getRoles());    
		return user.getRoles().stream()
	                   .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName()))
	                   .collect(Collectors.toList());
	    }
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return usertable.getUser_psw();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return usertable.getuName();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
		
	}

	

}
