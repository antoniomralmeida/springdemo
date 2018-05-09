package br.com.opencare.springdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.opencare.springdemo.model.SysUser;

public interface SysUserRepository extends JpaRepository<SysUser, Long> {
	public SysUser findByEmail(String email);
}
