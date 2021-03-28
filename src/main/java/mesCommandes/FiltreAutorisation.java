package mesCommandes;

import java.io.IOException;

import org.apache.tomcat.util.http.parser.Cookie;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FiltreAutorisation implements Filter {
private FilterConfig filterConfig = null;
public void init(FilterConfig filterConfig) throws ServletException {
this.filterConfig = filterConfig;
}
public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
ServletException {
String nom = null;
HttpServletRequest hrequest = (HttpServletRequest) request;
HttpServletResponse hresponse = (HttpServletResponse) response;
jakarta.servlet.http.Cookie[] cookies = hrequest.getCookies();

nom = Identification.chercheNom(cookies);
if(nom==null) { 
	hresponse.sendRedirect(hrequest.getContextPath()+"/sinscrire");
}
else {
	chain.doFilter(request, response); }
}
public void destroy() {
this.filterConfig = null;
}

}