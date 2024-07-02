package com.tcms.enquiryreplyservice.controller;

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
import com.tcms.enquiryreplyservice.payload.EnquiryDto;
import com.tcms.enquiryreplyservice.services.EnquiryService;

@RestController
@RequestMapping("/api/enquiries")
@CrossOrigin("http://localhost:3000/")
public class EnquiryController {
	@Autowired
	private EnquiryService enquiryService;
   
    @PostMapping("/") 
    public ResponseEntity<EnquiryDto> createEnquiry(@RequestBody EnquiryDto enquiryDto) {
        EnquiryDto createEnquiry=this.enquiryService.createEnquiry(enquiryDto);
        return new ResponseEntity<EnquiryDto>(createEnquiry,HttpStatus.CREATED);
    }
    @PostMapping("/{enquiryId}/reply")
    public ResponseEntity<EnquiryDto> createReply(@RequestBody EnquiryDto enquiryDto,@PathVariable Long enquiryId) {
        EnquiryDto updatedEnquiry=this.enquiryService.createReply(enquiryDto,enquiryId);
        return new ResponseEntity<EnquiryDto>(updatedEnquiry,HttpStatus.OK);
    }
    
    @PutMapping("/{enquiryId}")
    public ResponseEntity<EnquiryDto> updateEnquiry(@RequestBody EnquiryDto enquiryDto,@PathVariable Long enquiryId) {
        EnquiryDto updatedEnquiry=this.enquiryService.updateEnquiry(enquiryDto,enquiryId);
        return new ResponseEntity<EnquiryDto>(updatedEnquiry,HttpStatus.OK);
    }
    @DeleteMapping("/{enquiryId}")
    public ResponseEntity<ApiResponse> deleteEnquiry(@PathVariable Long enquiryId) {
        this.enquiryService.deleteEnquiry(enquiryId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("user deleted successfully",true),HttpStatus.OK);
    }
    @GetMapping("/{enquiryId}")
    public ResponseEntity<EnquiryDto> getEnquiry(@PathVariable Long enquiryId) {
    	EnquiryDto getEnquiry= this.enquiryService.getEnquiry(enquiryId);
        return new ResponseEntity<EnquiryDto>(getEnquiry,HttpStatus.OK);
    }
    @GetMapping("/")
	public ResponseEntity<List<EnquiryDto>> getEnquiries(){
		List<EnquiryDto> enquiries=this.enquiryService.getEnquiries();
		return ResponseEntity.ok(enquiries);
	}
}