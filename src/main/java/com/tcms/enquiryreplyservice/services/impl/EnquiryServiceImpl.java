package com.tcms.enquiryreplyservice.services.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.tcms.enquiryreplyservice.dao.EnquiryRepository;
import com.tcms.enquiryreplyservice.entities.Enquiry;
import com.tcms.enquiryreplyservice.entities.User;
import com.tcms.enquiryreplyservice.exceptions.ResourceNotFoundException;
import com.tcms.enquiryreplyservice.payload.EnquiryDto;
import com.tcms.enquiryreplyservice.services.EnquiryService;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class EnquiryServiceImpl implements EnquiryService {
	@Autowired
	private EnquiryRepository enquiryRepository;
	@Autowired
    private ModelMapper modelMapper;
	@Autowired
	private RestTemplate restTemplate;
	private Logger logger=LoggerFactory.getLogger(EnquiryServiceImpl.class);
    public void saveEnquiry(Enquiry enquiry) {
    	enquiry.setDateCreated(LocalDateTime.now());
    	enquiryRepository.save(enquiry);
    }

    @Override
    public EnquiryDto createEnquiry(EnquiryDto enquiryDto) {
        // Map the EnquiryDto to an Enquiry object
        Enquiry eq = this.modelMapper.map(enquiryDto, Enquiry.class);
        
        // Set properties for the main enquiry
        eq.setDateCreated(LocalDateTime.now()); // Set current date and time
        eq.setStatus("Pending"); // Set default status
       
        
        // Save the main enquiry
        Enquiry addedEq = this.enquiryRepository.save(eq);
        
        // Map the saved Enquiry object back to EnquiryDto and return
        return this.modelMapper.map(addedEq, EnquiryDto.class);
    }
    /*@Override
	public EnquiryDto createReply(EnquiryDto enquiryDto, Long enquiryId) {
		// TODO Auto-generated method stub
		Enquiry eq=this.enquiryRepository.findById(enquiryId).orElseThrow(()->new ResourceNotFoundException("Enquiry","Enquiry Id",enquiryId));
		eq.setReplyMessage(enquiryDto.getReplyMessage());
		Enquiry updatedeq=this.enquiryRepository.save(eq);
		return this.modelMapper.map(updatedeq, EnquiryDto.class);
	}*/
    @Override
    public EnquiryDto createReply(EnquiryDto enquiryDto, Long enquiryId) {
        // Retrieve the main enquiry object
        Enquiry mainEnquiry = this.enquiryRepository.findById(enquiryId)
                                        .orElseThrow(() -> new ResourceNotFoundException("Enquiry", "Enquiry Id", enquiryId));
        mainEnquiry.setStatus("Replied"); // Set default status
        // Set the reply message from the DTO
        mainEnquiry.setReplyMessage(enquiryDto.getReplyMessage());
        
        // Set the foreign key (reply) of the main enquiry to itself
        mainEnquiry.setReply(mainEnquiry);
        
        // Save the updated enquiry object
        Enquiry updatedEnquiry = this.enquiryRepository.save(mainEnquiry);
        
        // Map the updated Enquiry object back to EnquiryDto and return
        return this.modelMapper.map(updatedEnquiry, EnquiryDto.class);
    }


	@Override
	public EnquiryDto updateEnquiry(EnquiryDto enquiryDto, Long enquiryId) {
		// TODO Auto-generated method stub
		Enquiry eq=this.enquiryRepository.findById(enquiryId).orElseThrow(()->new ResourceNotFoundException("Enquiry","Enquiry Id",enquiryId));
		eq.setName(enquiryDto.getName());
		eq.setEnquiryAbout(enquiryDto.getEnquiryAbout());
		eq.setEnquiryContent(enquiryDto.getEnquiryContent());
		Enquiry updatedeq=this.enquiryRepository.save(eq);
		return this.modelMapper.map(updatedeq, EnquiryDto.class);
	}

	@Override
	public void deleteEnquiry(Long enquiryId) {
		// TODO Auto-generated method stub
		Enquiry eq=this.enquiryRepository.findById(enquiryId)
				.orElseThrow(()-> new ResourceNotFoundException("Enquiry","enquiry id",enquiryId));
		this.enquiryRepository.delete(eq);
	}

	@Override
	public EnquiryDto getEnquiry(Long enquiryId) {
		// TODO Auto-generated method stub
		Enquiry eq=this.enquiryRepository.findById(enquiryId)
				.orElseThrow(()-> new ResourceNotFoundException("Enquiry","enquiry id",enquiryId));
		return this.modelMapper.map(eq, EnquiryDto.class);
	}
	/*@Override
	public EnquiryDto getEnquiry(Long enquiryId) {
		Enquiry eq=this.enquiryRepository.findById(enquiryId)
				.orElseThrow(()-> new ResourceNotFoundException("Enquiry","enquiry id",enquiryId));
		// Fetch users of the enquiry from the user service
		    ArrayList<User> usersOfEnquiry = restTemplate.getForObject("http://localhost:8081/api/users/user/"+eq.getEnquiryId(),ArrayList.class);
		    
		    // Log the enquiries for debugging
		    logger.info("Users for enquiry {}: {}", enquiryId, usersOfEnquiry);
		    EnquiryDto enquiryDto=this.modelMapper.map(eq, EnquiryDto.class);
		    // Set enquiries in the UserDto
		    enquiryDto.setUsers(usersOfEnquiry);
		return enquiryDto;
	}*/

	@Override
	public List<EnquiryDto> getEnquiries() {
		List<Enquiry>enquiries =this.enquiryRepository.findAll();
		List<EnquiryDto> eqDtos=enquiries.stream().map((eq)->this.modelMapper.map(eq,EnquiryDto.class)).collect(Collectors.toList());
		return eqDtos;
	}
}

