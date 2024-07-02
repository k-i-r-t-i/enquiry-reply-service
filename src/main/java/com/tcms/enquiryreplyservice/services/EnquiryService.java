package com.tcms.enquiryreplyservice.services;

import java.util.List;

import com.tcms.enquiryreplyservice.payload.EnquiryDto;

public interface EnquiryService {
    //create
	EnquiryDto createEnquiry(EnquiryDto enquiryServiceDto);
	
    //update
	EnquiryDto updateEnquiry(EnquiryDto enquiryDto, Long enquiryId);
	
	//create reply
		EnquiryDto createReply(EnquiryDto enquiryDto, Long enquiryId);
	
    //delete
	 void deleteEnquiry(Long enquiryId);
	
    //get
	EnquiryDto getEnquiry(Long enquiryId);
	
    //get all
	List<EnquiryDto> getEnquiries();
}
