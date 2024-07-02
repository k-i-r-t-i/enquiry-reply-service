/*package com.tcms.enquiryreplyservice.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcms.enquiryreplyservice.dao.EnquiryReplyRepository;
import com.tcms.enquiryreplyservice.dao.ReplyRepository;
import com.tcms.enquiryreplyservice.entities.EnquiryReply;
import com.tcms.enquiryreplyservice.entities.Reply;
import com.tcms.enquiryreplyservice.exceptions.ResourceNotFoundException;
import com.tcms.enquiryreplyservice.payload.EnquiryReplyDto;
import com.tcms.enquiryreplyservice.payload.ReplyDto;
import com.tcms.enquiryreplyservice.services.EnquiryReplyService;
import com.tcms.enquiryreplyservice.services.ReplyService;

@Service
public class EnquiryReplyServiceImpl implements EnquiryReplyService{
    @Autowired
	private EnquiryReplyRepository enquiryreplyRepository;
    @Autowired
    private ModelMapper modelMapper;

	@Override
	public EnquiryReplyDto createEnquiryReply(EnquiryReplyDto enquiryReplyDto) {
		EnquiryReply er=this.modelMapper.map(enquiryReplyDto, EnquiryReply.class);
		EnquiryReply addedEr=this.enquiryreplyRepository.save(er);
		return this.modelMapper.map(addedEr, EnquiryReplyDto.class);
	}


	@Override
	public void deleteEnquiryReply(Long id) {
		// TODO Auto-generated method stub
		EnquiryReply er=this.enquiryreplyRepository.findById(id)
						.orElseThrow(()-> new ResourceNotFoundException("EnquiryReply","id",id));
				this.enquiryreplyRepository.delete(er);
		
	}

	@Override
	public EnquiryReplyDto getEnquiryReply(Long id) {
		EnquiryReply er=this.enquiryreplyRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("EnquiryReply","id",id));
		return this.modelMapper.map(er, EnquiryReplyDto.class);
	}

	@Override
	public List<EnquiryReplyDto> getEnquiryReplies() {
		List<EnquiryReply>enquiryreplies =this.enquiryreplyRepository.findAll();
		List<EnquiryReplyDto> erDtos=enquiryreplies.stream().map((er)->this.modelMapper.map(er,EnquiryReplyDto.class)).collect(Collectors.toList());
		return erDtos;
	}

}*/


