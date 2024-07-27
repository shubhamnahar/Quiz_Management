package com.no_one.demo.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.no_one.demo.dao.UserRepo;
import com.no_one.demo.model.UserTable;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepo repo;
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserTable usertable= repo.findByuName(username);
		
		if(usertable==null) {
			throw new UsernameNotFoundException("404 not found");
		}
		System.out.println("Db result --"+usertable);
		usertable.getRoles().size();
		return new UserPrinciple(usertable);
		
	}

}
