package br.com.feedev.jdt.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.feedev.jdt.model.Usuario;

@WebFilter(urlPatterns = { "/pages/*" })
public class AutenticacaoFilter implements Filter {

	public void destroy() {
		System.out.println("Destroy do filter");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		
		Usuario usuarioSessao = (Usuario) session.getAttribute("usuario");
		
		String urlRequisitada = req.getRequestURI();

		if (usuarioSessao == null) {
			RequestDispatcher rd = req.getRequestDispatcher("/autenticar.jsp?urlRequisitada=" + urlRequisitada);
			rd.forward(request, response);
			return;
		}
		
		System.out.println("Usuário está logado.");
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Início do filter");
	}

}
