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
import com.tcms.enquiryreplyservice.payload.EnquiryReplyDto;
import com.tcms.enquiryreplyservice.services.EnquiryReplyService;

@RestController
@RequestMapping("/enquiryreply")
@CrossOrigin("http://localhost:3000/")
public class EnquiryReplyController {
	@Autowired
	private EnquiryReplyService enquiryReplyService;
   
	@PostMapping("/")
    public ResponseEntity<EnquiryReplyDto> createEnquiryReply(@RequestBody EnquiryReplyDto enquiryReplyDto) {
		EnquiryReplyDto createEnquiryReply=this.enquiryReplyService.createEnquiryReply(enquiryReplyDto);
        return new ResponseEntity<EnquiryReplyDto>(createEnquiryReply,HttpStatus.CREATED);
    }
	@DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteEnquiryReply(@PathVariable Long id) {
        this.enquiryReplyService.deleteEnquiryReply(id);
        return new ResponseEntity<ApiResponse>(new ApiResponse("enquiry & reply deleted successfully",true),HttpStatus.OK);
    }
	@GetMapping("/{id}")
    public ResponseEntity<EnquiryReplyDto> getEnquiryReply(@PathVariable Long id) {
		EnquiryReplyDto getEnquiryReply= this.enquiryReplyService.getEnquiryReply(id);
        return new ResponseEntity<EnquiryReplyDto>(getEnquiryReply,HttpStatus.OK);
    }
	@GetMapping("/")
	public ResponseEntity<List<EnquiryReplyDto>> getEnquirytReplies(){
		List<EnquiryReplyDto> enquiryReplies=this.enquiryReplyService.getEnquiryReplies();
		return ResponseEntity.ok(enquiryReplies);
	}

}*/
