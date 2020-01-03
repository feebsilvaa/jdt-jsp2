package br.com.feedev.jdt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/testarExcecaoJquery" })
public class CapturarExcecaoJQueryServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Get");
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String valorParam = req.getParameter("valorParam");
			int resposta = 50 / Integer.valueOf(valorParam);
			System.out.println(resposta);
			resp.setStatus(200);
			resp.getWriter().write("Processada com sucesso. Resultado: " + resposta);
		} catch (Exception e) {
			e.printStackTrace();
			resp.setStatus(500);
			resp.getWriter().write("Erro ao processar: " + e);
		}
	}

}
