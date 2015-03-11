package Utile;

import java.io.*;
import java.util.*;

import javax.mail.*;
import javax.mail.Flags.Flag;
import javax.mail.internet.*;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import org.junit.Assert;

import com.sun.mail.imap.IMAPFolder;





public class EmailPage extends ScenarioSteps {
	

	@Step
	public void checkLastEmailSubjectAndBody(String expectedSubject, String expectedBody) throws MessagingException, IOException {
		IMAPFolder folder = null;
		Store store = null;
		String subject = null;
		String body = null;
		try {
			Properties props = System.getProperties();
			props.setProperty("mail.store.protocol", "imaps");

			Session session = Session.getDefaultInstance(props, null);

			store = session.getStore("imaps");
			store.connect("mail.evozon.com", "dragos.campean@evozon.com", "Dragos.campean91");

			folder = (IMAPFolder) store.getFolder("Inbox");

			if (!folder.isOpen())
				folder.open(Folder.READ_WRITE);
			Message msg = folder.getMessage(folder.getMessageCount());

			subject = msg.getSubject();
			body = msg.getContent().toString();

			System.out.println("Subject: " + subject);
			System.out.println("From: " + msg.getFrom()[0]);
			System.out.println("To: " + msg.getAllRecipients()[0]);
			System.out.println("Date: " + msg.getReceivedDate());
			System.out.println("Size: " + msg.getSize());
			System.out.println(msg.getFlags());
			System.out.println("Body: \n" + body);
			System.out.println(msg.getContentType());

		} finally {
			if (folder != null && folder.isOpen()) {
				folder.close(true);
			}
			if (store != null) {
				store.close();
			}
		}

		
		Assert.assertTrue(subject.contentEquals(expectedSubject));
		Assert.assertTrue(body.contains(expectedBody));
		
	}

}
