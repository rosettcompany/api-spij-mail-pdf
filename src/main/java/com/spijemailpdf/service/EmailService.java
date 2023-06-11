package com.spijemailpdf.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.lowagie.text.DocumentException;
import com.spijemailpdf.util.LimpiarUtil;
import com.spijemailpdf.repository.Email;
import com.spijemailpdf.repositoryI.EmailPortRepositoryI;

import org.xhtmlrenderer.pdf.ITextRenderer;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URLDecoder;

@Service
public class EmailService implements EmailPortRepositoryI {

    @Autowired
    private JavaMailSender javaMailSender;
    private static final String UTF8 = "UTF-8";
    private LimpiarUtil limpiarUtil;
    //private Docx4jUtil docx4jUtil;
    
    public boolean sendEmail(Email email) throws MessagingException, IOException, DocumentException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(email.gettoEmail());
        helper.setSubject(email.getSubject());
        //helper.setText(email.getSubject(), true);
        
        //helper.setText("Estimado(a) señor(a): \\n Se le envía el texto solicitado. \\n Saludos cordiales");
        helper.setText("<html> <body><p>Estimado(a) se&ntilde;or(a):</p><p>Se le env&iacute;a el texto solicitado.</p><p>Saludos cordiales,</p> </body></html>",true);
        
        String formater = URLDecoder.decode(email.getHtml(), UTF8);
        
        formater = formater.replace("display", "");
        
        formater = formater.replace("font-family", "Arial");
        
        formater = formater.replace("font-size", "10pt");
        
        //formater = limpiarUtil.decodificarSimbolos(formater);
        
        //formater = limpiarUtil.limpiarHtmlImprimir(formater);
        //formater = docx4jUtil.fixTidy(formater);
        //formater = limpiarUtil.limpiarFixTidy(formater);

        formater = formater.replace("[AComillas]", "&#8220;");
        formater = formater.replace("[CComillas]", "&#8221;");	
		
        formater = formater.replaceAll("'text-decoration:\" font-weight:=\"", "");
        formater = formater.replaceAll("\"'", "\"");
        formater = formater.replaceAll("'\"", "\""); 
        formater = formater.replaceAll("\r", ""); 
        formater = formater.replaceAll("\n", ""); 
        
        //String html = formater.replace("font-align", "justify");
        String html = formater;
        
        ByteArrayOutputStream outputStream = generatePdfOutputStream(html);
        
        helper.addAttachment("norma.pdf", new ByteArrayResource(outputStream.toByteArray()));

        javaMailSender.send(message);
        return true;
    }

    private ByteArrayOutputStream generatePdfOutputStream(String content) throws DocumentException, IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        try {
            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocumentFromString(content);
            renderer.layout();
            renderer.createPDF(outputStream);
            renderer.finishPDF();
        } catch (com.lowagie.text.DocumentException e) {
            DocumentException documentException = new DocumentException();
            documentException.initCause(e);
            throw documentException;
        }

        return outputStream;
    }
}
