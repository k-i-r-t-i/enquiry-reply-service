/*package com.tcms.enquiryreplyservice.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcms.enquiryreplyservice.dao.ReplyRepository;
import com.tcms.enquiryreplyservice.entities.Reply;
import com.tcms.enquiryreplyservice.exceptions.ResourceNotFoundException;
import com.tcms.enquiryreplyservice.payload.ReplyDto;
import com.tcms.enquiryreplyservice.services.ReplyService;

@Service
public class ReplyServiceImpl implements ReplyService{
    @Autowired
	private ReplyRepository replyRepository;
    @Autowired
    private ModelMapper modelMapper;

	@Override
	public ReplyDto createReply(ReplyDto replyDto) {
		Reply re=this.modelMapper.map(replyDto, Reply.class);
		Reply addedEq=this.replyRepository.save(re);
		return this.modelMapper.map(addedEq, ReplyDto.class);
	}

	@Override
	public ReplyDto updateReply(ReplyDto replyDto, Long replyId) {
		Reply re=this.replyRepository.findById(replyId).orElseThrow(()->new ResourceNotFoundException("Reply","Reply Id",replyId));
		re.setReplyMessage(replyDto.getReplyMessage());
		Reply updatedre=this.replyRepository.save(re);
		return this.modelMapper.map(updatedre, ReplyDto.class);
	}

	@Override
	public void deleteReply(Long replyId) {
		// TODO Auto-generated method stub
				Reply re=this.replyRepository.findById(replyId)
						.orElseThrow(()-> new ResourceNotFoundException("Reply","reply id",replyId));
				this.replyRepository.delete(re);
		
	}

	@Override
	public ReplyDto getReply(Long replyId) {
		Reply re=this.replyRepository.findById(replyId)
				.orElseThrow(()-> new ResourceNotFoundException("Reply","reply id",replyId));
		return this.modelMapper.map(re, ReplyDto.class);
	}

	@Override
	public List<ReplyDto> getReplies() {
		List<Reply>replies =this.replyRepository.findAll();
		List<ReplyDto> reDtos=replies.stream().map((re)->this.modelMapper.map(re,ReplyDto.class)).collect(Collectors.toList());
		return reDtos;
	}

}*/

