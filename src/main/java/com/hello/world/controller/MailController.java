package com.hello.world.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Properties;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/mail")
public class MailController {

	@Resource(name = "mailSender")
	private JavaMailSender mailSender;

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	/*
	 * 인증 메일 사용자에게 보내는.
	 */
	@RequestMapping(value = "/sendMail", method = RequestMethod.GET)
	public String simpleMessageSender(
			@RequestParam(value = "mem_mail") String mem_mail, Model model) {
		String url = "redirect:../member/join?mem_mail=" + mem_mail;

		String token = generateToken();

		MimeMessage message = mailSender.createMimeMessage();
		System.out.println("token : " + token);
		
		// properties
		// 수정해야함.. 2016-01-24 jihyun.Park
		/*Properties prop = new Properties();
		
		try {
			FileInputStream fis = new FileInputStream("");
			prop.load(fis);
		} catch (FileNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		prop.setProperty(mem_mail, token);

		try {
			FileOutputStream fos = new FileOutputStream("");
			prop.store(fos, "test");
			fos.close();
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}*/

		// SimpleMailMessage message = new SimpleMailMessage();
		String htmlContent = "<a href=\"http://192.168.202.120:8181/world/mail/certification?certifi="
				+ token + "&mem_mail=" + mem_mail + "\">인증페이지 이동</a>";

		try {
			message.setSubject("가입인증 테스트");
			message.setText(htmlContent, "UTF-8", "html");
			message.setFrom(new InternetAddress("jihyunkkkkk@daum.net"));
			message.addRecipient(RecipientType.TO,
					new InternetAddress(mem_mail));
		} catch (AddressException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (MessagingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		mailSender.send(message);

		try {
			mailSender.send(message);
		} catch (MailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return url;
	}

	/*
	 * 인증 처리하는 부분..
	 */
	@RequestMapping(value = "/certification", method = RequestMethod.GET)
	public String mailCertification(
			@RequestParam(value = "certifi") String certifi,
			@RequestParam(value = "mem_mail") String mem_mail) {
		String cettification = "fail";
		// 성공하면..
		if(true) {
			cettification = "fail";
		}
		
		String url = "redirect:../member/join?mem_mail=" + mem_mail+"&cetifi="+cettification;

		return url;
	}

	public String generateToken() {
		String token = null;
		SecureRandom secureRandom;
		try {
			secureRandom = SecureRandom.getInstance("SHA1PRNG");
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			secureRandom.setSeed(secureRandom.generateSeed(128));
			/*
			 * token = new String(digest.digest((secureRandom.nextLong() + "")
			 * .getBytes()));
			 */

			byte[] hash = digest.digest((secureRandom.nextLong() + "")
					.getBytes("UTF-8"));
			StringBuffer hexString = new StringBuffer();

			for (int i = 0; i < hash.length; i++) {
				String hex = Integer.toHexString(0xff & hash[i]);
				if (hex.length() == 1)
					hexString.append('0');
				hexString.append(hex);
			}
			token = hexString.toString();
			// System.out.println(hexString.toString());

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return token;
	}

}
