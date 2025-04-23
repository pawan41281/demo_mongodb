package com.example.demo_mongodb.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	private final UserRepository userRepository;
	
    public CustomUserDetailsService(UserRepository userRepository) {
       this.userRepository = userRepository;
    }

	@Override
	public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {

		User user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
				.orElseThrow(() -> new UsernameNotFoundException("User not exists by Username or Email"));

		return new org.springframework.security.core.userdetails.User(usernameOrEmail, user.getPassword(), getAuthorities(user.getRoles()));
	}
	
	private Collection<SimpleGrantedAuthority> getAuthorities(Set<Role> roles) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        for (Role role : roles) {
           authorities.add(new SimpleGrantedAuthority(role.getName()));
//           for (Permission permission : role.getPermissions()) {
//               authorities.add(new SimpleGrantedAuthority(permission.getName()));
//           }
        }
        return authorities;
    }
}