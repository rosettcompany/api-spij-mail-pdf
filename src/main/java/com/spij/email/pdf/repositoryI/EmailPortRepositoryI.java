package com.spij.email.pdf.repositoryI;

import com.lowagie.text.DocumentException;
import com.spij.email.pdf.repository.Email;

import java.io.IOException;

import javax.mail.MessagingException;
public interface EmailPortRepositoryI {

	public boolean sendEmail(Email email) throws MessagingException, IOException, DocumentException;
}
