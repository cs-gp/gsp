package com.himalayanGeeks.carRental.serviceImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;




@Transactional
@Service
public class CustomUserDetailsService implements UserDetailsService{
	@Autowired
	com.himalayanGeeks.carRental.service.UserService userService;
	
	static com.himalayanGeeks.carRental.domain.User domainUser;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			domainUser = userService.findByUsername(username);
			
			System.out.println(domainUser.getUserName());
			System.out.println(domainUser.getPassword());
			boolean enabled = true;
			boolean accountNonExpired = true;
			boolean credentialsNonExpired = true;
			boolean accountNonLocked = true;
			User usr = new User(domainUser.getUserName(), 
					domainUser.getPassword().toLowerCase(),
					enabled,
					accountNonExpired,
					credentialsNonExpired,
					accountNonLocked,
					getAuthorities(domainUser.getRole().getRole()));
			System.out.println();
			System.out.println(usr);
			return usr;
			
		} catch (Exception e) {
			throw new RuntimeException(e);
}
	}

		

	public Collection<? extends GrantedAuthority> getAuthorities(Integer role) {
		List<GrantedAuthority> authList = getGrantedAuthorities(getRoles(role));
		return authList;
	}

	public List<String> getRoles(Integer role) {
		List<String> roles = new ArrayList<String>();

		if (role.intValue() == 1) {
			roles.add("ROLE_ADMIN");

		} else if (role.intValue() == 2) {
			roles.add("ROLE_USER");
		}

		return roles;
	}

	public static List<GrantedAuthority> getGrantedAuthorities(List<String> roles) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (String role : roles) {
			authorities.add(new SimpleGrantedAuthority(role));
		}
		return authorities;
	}
	public com.himalayanGeeks.carRental.domain.User getSessionUser(){
		System.out.println(domainUser.getFirstName()+"insideloaduser");
		return domainUser;
		
	}

}
