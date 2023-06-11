package com.spijemailpdf.repositoryI;

import com.lowagie.text.DocumentException;
import com.spijemailpdf.repository.Email;

import java.io.IOException;

import javax.mail.MessagingException;
public interface EmailPortRepositoryI {

	public boolean sendEmail(Email email) throws MessagingException, IOException, DocumentException;
}
