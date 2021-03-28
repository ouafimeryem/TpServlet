package mesCommandes;

import java.io.IOException;
import java.io.PrintWriter;

import org.apache.tomcat.util.http.parser.Cookie;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

public class FiltrerechercheNom implements Filter {
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String nom = null;
		HttpServletRequest hrequest = (HttpServletRequest) request;
		jakarta.servlet.http.Cookie[] cookies = hrequest.getCookies();
		// test s'il existe un cookie dont l'attribut est "nom"
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals("nom")) {
					nom = cookies[i].getValue();
					PrintWriter out = response.getWriter();
					out.print( nom);
					break;
				}
			}
		}
		chain.doFilter(request, response);
	}

}