package br.com.feedev.jdt.servlet;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.feedev.jdt.model.EmailJdt;
import br.com.feedev.jdt.util.Constants;

@WebServlet(urlPatterns = { "/sendMailServlet" })
public class EnvioEmailServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3867047830268648543L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String destinatarioParam = req.getParameter("destinatario");
		String assuntoParam = req.getParameter("assunto");
		String corpoEmailParam = req.getParameter("corpo_email");
		EmailJdt newMail = new EmailJdt(Constants.MAIL_JDT_DEFAULT_USERNAME, destinatarioParam, assuntoParam, corpoEmailParam);

		if (!formValido(newMail)) {
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			req.setAttribute("errorMessage", "Todos os campos precisam ser preenchidos.");
			req.setAttribute("mailForm", newMail);
			req.getRequestDispatcher("/pages/envio-email.jsp").forward(req, resp);
			return;
		} else {
			
			try {
				Properties props = Constants.MAIL_JDT_DEFAULT_PROPERTIES;
				Session mailSession = getMailSession(props);
				Address[] toAddress = InternetAddress.parse(newMail.getTo());
				Message message = new MimeMessage(mailSession);
				message.setFrom(new InternetAddress(Constants.MAIL_JDT_DEFAULT_USERNAME));
				message.setRecipients(Message.RecipientType.TO, toAddress);
				message.setRecipients(Message.RecipientType.CC, null);
				message.setRecipients(Message.RecipientType.BCC, null);
				message.setSubject(newMail.getSubject());
				message.setText(newMail.getBody());
				Transport.send(message);
			} catch (Exception e) {
				e.printStackTrace();
				resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
				req.setAttribute("errorMessage", "Ocorreu um erro na tentativa de enviar o e-mail. Tente novamente mais tarde.");
				req.setAttribute("mailForm", newMail);
				req.getRequestDispatcher("/pages/envio-email.jsp").forward(req, resp);
			}
			
		}

		resp.setStatus(HttpServletResponse.SC_OK);
		String redir = req.getContextPath() + "/pages/envio-email.jsp";
		resp.sendRedirect(redir);
		return;

	}

	private Session getMailSession(Properties props) {
		return Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(Constants.MAIL_JDT_DEFAULT_USERNAME, Constants.MAIL_JDT_DEFAULT_PASSWORD);
			}
		});
	}

	private boolean formValido(EmailJdt mail) {
		return ((mail.getTo() != null && !mail.getTo().isEmpty())
				&& (mail.getSubject() != null && !mail.getSubject().isEmpty())
				&& (mail.getBody() != null && !mail.getBody().isEmpty()));
	}

}
