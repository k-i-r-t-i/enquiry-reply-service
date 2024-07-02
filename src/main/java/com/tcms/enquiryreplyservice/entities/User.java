package com.tcms.enquiryreplyservice.entities;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
	private Long userId;
	private Long enquiryId;
	private String salutation;
	private String first_name;
	private String last_name;
	private String tel_code;
	private String mobile;
	private String email;
	private String username;
	private String password;
	private String passwordHint;
	private String security_ques_1;
	private String security_ans_1;
	private String security_ques_2;
	private String security_ans_2;

}
