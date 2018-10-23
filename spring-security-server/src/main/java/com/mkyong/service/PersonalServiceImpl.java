package com.mkyong.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mkyong.dao.PersonalDao;
import com.mkyong.model.Personal;
import com.mkyong.model.User;
import com.mkyong.model.UserRole;


@Service
@Transactional
public class PersonalServiceImpl implements PersonalService {
	
	@Autowired
	private PersonalDao personalDao;

	@Transactional
	public void addPersonal(Personal personal) {
		personalDao.addPersonal(personal);
	}
	
	@Transactional
	public List<Personal> getAllPersonal(){
		List<Personal> list= new ArrayList<Personal>();
		list=personalDao.getAllPersonal();
		return list;
	}

	public void addUser(User user) {
		personalDao.addUser(user);
	}

	public void addUserRole(UserRole userRole) {
		personalDao.addUserRole(userRole);
		
	}
	
	public void deletePersonal(Integer id) {
		personalDao.deletePersonal(id);
	}

	public void enviarEmail(User user) {
		try {
			 JavaMailSender mailSender = null;

			Properties props = new Properties();
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.setProperty("mail.smtp.starttls.enable", "true");
			props.setProperty("mail.smtp.port", "587");
			props.setProperty("mail.smtp.user", "iplantooltfg@gmail.com");
			props.setProperty("mail.smtp.auth", "true");

			Session session = Session.getDefaultInstance(props, null);

			// Se compone la parte del texto
			BodyPart texto = new MimeBodyPart();
			texto.setText("A continuación se adjuntan los distintos planes de mejora generados para su organización."
					+ "\n" + "-" + "\n" + "Un saludo." + "\n");

			MimeMultipart multiParte = new MimeMultipart();
			multiParte.addBodyPart(texto);
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress("celeste.lopez@alu.ulcm.es"));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress("celeste.lopez@alu.ulcm.es"));
			message.setSubject("[LiceDQTool] Su contraseña de LiceDQTool");
			message.setContent(multiParte);

			mailSender.send(message);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void deleteUser(String username) {
		personalDao.deleteUser(username);
	}

	public void deleteUserRole(String username) {
		personalDao.deleteUserRole(username);
		
	}



}
