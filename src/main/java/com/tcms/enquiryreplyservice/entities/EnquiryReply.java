/*package com.tcms.enquiryreplyservice.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="enquiryReply")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class EnquiryReply {
	@Id
	@GeneratedValue
	private Long id;
	@OneToOne
	@JoinColumn(name="enquiryId")
	private Enquiry enquiry;
	@OneToOne
	@JoinColumn(name="replyId")
	private Reply reply;
	private Long userId;
	private String name;
	private String enquiryAbout;
	private String enquiryContent;
	private LocalDateTime dateCreated;
	private String replyMessage;
	private String status;
}*/
