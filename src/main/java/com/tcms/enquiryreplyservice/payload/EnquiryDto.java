package com.tcms.enquiryreplyservice.payload;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tcms.enquiryreplyservice.entities.Enquiry;
import com.tcms.enquiryreplyservice.entities.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EnquiryDto {
	private Long enquiryId;
	private Long userId;
	private String name;
	private String enquiryAbout;
	private String enquiryContent;
	private LocalDateTime dateCreated;
    private String status;
    private String replyMessage;
   // private List<User> users;
    @JsonIgnore
    private Enquiry reply;
   // private EnquiryDto enquiry;
}
