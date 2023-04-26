package com.iu.base.member;

import java.sql.Date;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class MemberVO {
	
	@NotBlank
	private String userName;
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

}
