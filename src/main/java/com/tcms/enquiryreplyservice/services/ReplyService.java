package com.tcms.enquiryreplyservice.services;

import java.util.List;

import com.tcms.enquiryreplyservice.payload.ReplyDto;

public interface ReplyService {
    //create
		ReplyDto createReply(ReplyDto replyDto);
		
    //update
		ReplyDto updateReply(ReplyDto replyDto, Long replyId);
		
    //delete
		 void deleteReply(Long replyId);
		
	//get
		 ReplyDto getReply(Long replyId);
		
	//get all
		List<ReplyDto> getReplies();

}

