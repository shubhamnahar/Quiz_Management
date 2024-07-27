package com.no_one.demo.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.no_one.demo.dao.RoleRepository;
import com.no_one.demo.dao.UserRepo;
import com.no_one.demo.model.Role;
import com.no_one.demo.model.UserTable;

import jakarta.transaction.Transactional;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;
	
	 @Autowired
	    private RoleRepository roleRepository;
	
	@Transactional
	public ResponseEntity<String> createUser(UserTable usertable) {
		// TODO Auto-generated method stub
		try {
			System.out.println("-----------------------createUser------"+usertable.toString());
			String plain_psw=usertable.getUser_psw();
			String pw_hash = BCrypt.hashpw(plain_psw, BCrypt.gensalt());
			usertable.setUser_psw(pw_hash);
			Set<Role> roles = new HashSet<>();
	        for (Role role : usertable.getRoles()) {
	        	Role existingRole = roleRepository.findById(role.getId()).orElse(null);
	        	if (existingRole != null) {
                    roles.add(existingRole);
                } else {
                    roles.add(roleRepository.save(role));
                }
//	            roles.add(roleRepository.findById(role.getId()).orElseThrow(() -> new RuntimeException("Role not found")));
	        }
	        System.out.println("rolessss::"+roles.toString());
	        usertable.setRoles(roles);
	        userRepo.save(usertable);
		return new ResponseEntity<>("Success",HttpStatus.CREATED);
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Exception::"+e.getMessage());
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}

	public ResponseEntity<List<UserTable>> getUser() {
		
		System.out.println("---------------------User List----------"+userRepo.findAll());
		// TODO Auto-generated method stub
		return new ResponseEntity<>(userRepo.findAll(),HttpStatus.OK);
	}
	
	 

}
