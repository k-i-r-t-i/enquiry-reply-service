/*package com.tcms.enquiryreplyservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcms.enquiryreplyservice.payload.ApiResponse;
import com.tcms.enquiryreplyservice.payload.ReplyDto;
import com.tcms.enquiryreplyservice.services.ReplyService;

@RestController
@RequestMapping("/reply")
@CrossOrigin("http://localhost:3000/")
public class ReplyController {
	@Autowired
	private ReplyService replyService;
   
	@PostMapping("/")
    public ResponseEntity<ReplyDto> createEnquiry(@RequestBody ReplyDto replyDto) {
        ReplyDto createReply=this.replyService.createReply(replyDto);
        return new ResponseEntity<ReplyDto>(createReply,HttpStatus.CREATED);
    }
	@PutMapping("/{replyId}")
    public ResponseEntity<ReplyDto> updateEnquiry(@RequestBody ReplyDto replyDto,@PathVariable Long replyId) {
        ReplyDto updatedReply=this.replyService.updateReply(replyDto,replyId);
        return new ResponseEntity<ReplyDto>(updatedReply,HttpStatus.OK);
    }
	@DeleteMapping("/{replyId}")
    public ResponseEntity<ApiResponse> deleteEnquiry(@PathVariable Long replyId) {
        this.replyService.deleteReply(replyId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("user deleted successfully",true),HttpStatus.OK);
    }
	@GetMapping("/{replyId}")
    public ResponseEntity<ReplyDto> getEnquiry(@PathVariable Long replyId) {
    	ReplyDto getReply= this.replyService.getReply(replyId);
        return new ResponseEntity<ReplyDto>(getReply,HttpStatus.OK);
    }
	@GetMapping("/")
	public ResponseEntity<List<ReplyDto>> getReplies(){
		List<ReplyDto> replies=this.replyService.getReplies();
		return ResponseEntity.ok(replies);
	}
}*/

