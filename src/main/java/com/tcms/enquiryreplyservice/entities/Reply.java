/*package com.tcms.enquiryreplyservice.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="reply")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reply {
	@Id
	@GeneratedValue
	private Long replyId;
	private String replyMessage;
	private String status;
	@OneToOne(mappedBy="reply", cascade=CascadeType.ALL)
	private EnquiryReply enquiryReply;

}*/
