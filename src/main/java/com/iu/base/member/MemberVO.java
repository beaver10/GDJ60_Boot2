package com.iu.base.member;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class MemberVO implements UserDetails, OAuth2User{
	
	@NotBlank
	private String username;
	
	@NotBlank
	@Size(min = 6, max =20)
	private String password;
	
	private String password2;
	
	@NotBlank
	private String name;
	
	@Email
	@NotBlank
	private String email;
	
	@Past
	private Date birth;
	
	private boolean enabled;

	private Date lastTime;
	
	private List<RoleVO> roleVOs;
	
	//OAuth2User의 token 정보 저장 
	private Map<String, Object> attributes;
	
	
	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		List<GrantedAuthority> authorities = new ArrayList<>();
		for(RoleVO roleVO : roleVOs) {
			authorities.add(new SimpleGrantedAuthority(roleVO.getRoleName()));
		}
		
		return authorities;
	}

//	@Override
//	public String getUsername() {
//		// TODO Auto-generated method stub
//		username(id) 반환 
//		return null;
//	}
	
//	@Override
//	public String getPassword() {
//		// TODO Auto-generated method stub
//		password 반환 
//		return null;
//	}	
	

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		// 계정의 만료 여부
		// true : 만료 안됨
		// false : 만료 됨, 로그인 안됨 
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		// 계정 잠김 여부 
		// true : 계정 잠기지 않음 
		// false : 계정 잠김, 로그인 안됨 
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		// password 만료 여부
		// true : 만료 안됨
		// false : 만료됨, 로그인 안됨 
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		// 계정 사용 여부 
		// true : 계정 활성화
		// false : 계정 비활성화, 로그인 안됨
		return this.enabled;
	}

	@Override
	public <A> A getAttribute(String name) {
		// TODO Auto-generated method stub
		return OAuth2User.super.getAttribute(name);
	}

	@Override
	public Map<String, Object> getAttributes() {
		// TODO Auto-generated method stub
		return null;
	}

}
