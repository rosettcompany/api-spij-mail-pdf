package com.spijemailpdf.controller;

import java.io.IOException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lowagie.text.DocumentException;
import com.spijemailpdf.repository.Email;
import com.spijemailpdf.repositoryI.EmailPortRepositoryI;


@RestController
@CrossOrigin(origins="*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT })
@RequestMapping("/spij-ext-email-pdf")
public class SPIJMailController {
	
	@Autowired
	private EmailPortRepositoryI emailPortRepositoryI;
	
	
	@RequestMapping(value="/rest/email/sendWithPDF", method = RequestMethod.POST)
	public ResponseEntity<?> SendEmail(@RequestBody Email email) throws MessagingException, IOException, DocumentException  {
		emailPortRepositoryI.sendEmail(email);
		 
		 return new ResponseEntity<>(HttpStatus.OK);
	}
}
