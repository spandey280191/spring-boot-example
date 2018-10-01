package com.example.springsecurity;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
  
	@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	UserBuilder builder = null;
        if(username.equals("test")) {
           builder  = User.withUsername("test");
           return builder.password(new BCryptPasswordEncoder().encode("test"))
                       .roles("USER")
                       .build();
           
        } else {
            return null;
        }
    }
}