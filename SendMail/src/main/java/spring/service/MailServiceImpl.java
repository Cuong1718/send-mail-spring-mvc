package spring.service;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import spring.model.Customer;

@Service("mailService")
public class MailServiceImpl {
	@Autowired
	JavaMailSender mailSender;
	
	public void sendEmail(Object object) {
		Customer customer=(Customer) object;
		MimeMessagePreparator preparator=getContent(customer);
		try {
			mailSender.send(preparator);
			System.out.println("message with attachement has been sent...");
		} catch (Exception e) {
			System.err.println(e.getMessage());;
		}
		
	}
	private MimeMessagePreparator getContent(final Customer customer) {
		MimeMessagePreparator preparator =new MimeMessagePreparator() {
			
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper helper=new MimeMessageHelper(mimeMessage,true);
				helper.setSubject("abcxyz");
//				helper.setFrom("customerservice@yourshop.com");
				helper.setTo(customer.getEmail());
				String content="Hello "+customer.getName()+" thanks you "+customer.getOderId();
				helper.setText(content);
				
				
			}
		};
		
		
		return preparator ;
	}
	
}
