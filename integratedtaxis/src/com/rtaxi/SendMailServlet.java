package com.rtaxi;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.twilio.sdk.TwilioRestException;

@SuppressWarnings("serial")
public class SendMailServlet extends HttpServlet {

	@SuppressWarnings("static-access")
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		// resp.setContentType("text/plain");
		// resp.getWriter().println("Hello, world");
		resp.setContentType("text/html");

		String fname = req.getParameter("txtname");
		String femail = req.getParameter("txtemail");
		String ftxtnumber = req.getParameter("txtnumber");
		String ftxtcompany = req.getParameter("txtcompany");
		String fsubject = req.getParameter("txtsubject");
		String fmessage = req.getParameter("txtmessage");

	

		String strBody= " From \n "+fname+"\n"+femail+"\n"+ ftxtnumber+" \n\n\n\n\n + "+fmessage +"\n\n\n\n\n\n "+"Company name : "+ftxtcompany;
		
//		System.out.println("in <<<<<<DO POST>>>>> Test  fname 0" + fname);
//		System.out.println("Test femail 0" + femail);
//		System.out.println("Test ftxtnumber 0" + ftxtnumber);
//		System.out.println("Test ftxtcompany 0" + ftxtcompany);
//		System.out.println("Test fsubject 0" + fsubject);
//		System.out.println("Test fmessage 0" + fmessage);

		Properties props = new Properties();
		Session session = Session.getDefaultInstance(props, null);
		
	
		try {
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress("ravi@govindu.com", "From VIP Customer - "+fname));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(
					"ravi@govindu.com", "Mr. Running Taxi - Support"));
			msg.setSubject(fsubject);
			msg.setText(strBody);
			Transport.send(msg);
			SmsSender sms = new SmsSender();
			try {
				sms.sendSms(strBody);
				resp.setContentType("text/html");
				resp.sendRedirect("contact-us.html?t");

			} catch (TwilioRestException e) {
				e.printStackTrace();
				resp.setContentType("text/html");
				resp.sendRedirect("contact-us.html?t"+e);

			}
			resp.setContentType("text/html");
			resp.sendRedirect("contact-us.html?t");

		} catch (AddressException e) {
			// ...
			System.out.println("Test email 7" + e);
			resp.setContentType("text/html");
			resp.sendRedirect("contact-us.html?f"+e);
		} catch (MessagingException e) {
			// ...
			System.out.println("Test email 8" + e);
			resp.setContentType("text/html");
			resp.sendRedirect("contact-us.html?f"+e);
		}
	}
}
