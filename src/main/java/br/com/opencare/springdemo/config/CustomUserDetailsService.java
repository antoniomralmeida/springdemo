package br.com.opencare.springdemo.config;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.com.opencare.springdemo.model.Status;
import br.com.opencare.springdemo.model.SysUser;
import br.com.opencare.springdemo.model.UserProfile;
import br.com.opencare.springdemo.repository.SysUserRepository;

@Configuration
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private SysUserRepository sysUserRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		SysUser sysUser = sysUserRepository.findByEmail(email);
		if (sysUser == null) {
			throw new UsernameNotFoundException("Username not found");
		}
		return new org.springframework.security.core.userdetails.User(sysUser.getEmail(), sysUser.getPwd(),
				sysUser.getStatus().equals(Status.ACTIVE.getStatus()), true, true, true, getGrantedAuthorities(sysUser));
	}

	private List<GrantedAuthority> getGrantedAuthorities(SysUser sysUser) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		for (UserProfile userProfile : sysUser.getUserProfiles()) {
			authorities.add(new SimpleGrantedAuthority("ROLE_" + userProfile.getType()));
		}
		return authorities;
	}

}