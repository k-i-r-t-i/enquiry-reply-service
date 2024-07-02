package com.tcms.enquiryreplyservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcms.enquiryreplyservice.entities.Enquiry;

public interface EnquiryRepository extends JpaRepository<Enquiry,Long>{

}
