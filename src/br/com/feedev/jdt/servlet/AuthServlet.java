package br.com.feedev.jdt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.feedev.jdt.model.Usuario;

@WebServlet("/authServlet")
public class AuthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String actionParam = req.getParameter("action");
		
		if (actionParam != null && !actionParam.isEmpty()) {
			
			switch (actionParam) {
			case "logout":
				req.getSession().invalidate();
				resp.sendRedirect("index.jsp");
				return;
			}
			
		}

		resp.sendRedirect("index.jsp");
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loginParam = request.getParameter("login");
		String senhaParam = request.getParameter("senha");
		String urlRequisitada = request.getParameter("urlRequisitada");
		
		Usuario usuarioForm = new Usuario(loginParam, senhaParam);
		HttpSession session = request.getSession();
		
		if (!usuarioForm.verificaUsuarioESenha()) {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			request.setAttribute("errorMessage", "Usuário e/ou senha inválido(s).");
			request.setAttribute("usuarioForm", usuarioForm);
			request.getRequestDispatcher("/autenticar.jsp").forward(request, response);			
			return;
		}
		
		session.setAttribute("usuario", usuarioForm);
		response.sendRedirect(urlRequisitada);
		return;
	}

}
