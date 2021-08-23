package com.dbs.web.service;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.dbs.web.beans.Custodian;
import com.dbs.web.repository.CustodianRepository;


@Service
public class AccountuserService implements UserDetailsService{
	@Autowired
	private CustodianRepository custodianrepo;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("Username --- >  "+username);
		Optional<Custodian> account = this.custodianrepo.findByUsername(username);
		
		return account.map(acc ->{
			User user = new User(acc.getUsername(),
					encoder.encode(acc.getPassword()),
					Arrays.stream(acc.getRole().split(","))
					.map(role-> new SimpleGrantedAuthority(role))
					.collect(Collectors.toList()));
			return user;
		})
		.orElseThrow(()-> new UsernameNotFoundException("User does not exist with username "+username))
		;
		
	}
	

}
