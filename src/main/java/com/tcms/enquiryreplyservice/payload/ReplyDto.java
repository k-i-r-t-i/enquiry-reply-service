package com.tcms.enquiryreplyservice.payload;

import com.tcms.enquiryreplyservice.entities.Enquiry;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReplyDto {
	private Long replyId;
	private String replyMessage;
	private String status;
}
