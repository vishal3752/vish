package com.validation.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserRequest {
	
	@NotNull
	private String userName;
	@NotNull
	private int userID;
	@Email
	private String email;
	@Size(max = 10 , min = 10)
	@Pattern(regexp="(^$|[0-9]{10})")
	private String mobile;
	@Max(60)
	private int age;
	private String sex;

}
