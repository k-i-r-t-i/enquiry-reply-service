package com.tcms.enquiryreplyservice.entities;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.tcms.enquiryreplyservice.payload.EnquiryDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "enquiry")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Enquiry {
    @Id
    @GeneratedValue
    private Long enquiryId;
    private Long userId;
    private String name;
    private String enquiryAbout;
    private String enquiryContent;
    private LocalDateTime dateCreated;
    private String status;
    private String replyMessage;
    
    // One-to-one relationship with itself
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="reply_id")
    private Enquiry reply;
    //@OneToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name="reply_id")
    //private Enquiry enquiry;
}
