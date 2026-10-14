package com.jal.ecommerce.filter;

import java.io.IOException;

import com.jal.ecommerce.util.AttributeNames;
import com.jal.ecommerce.util.SessionManager;
import com.jal.ecommerce.view.Views;
import com.sabic.explorworld.model.Participante;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Filtro de autenticación para parte privada
 */
// @WebServlet("/AuthenticationFilter")

public class AuthenticationFilter extends HttpServlet implements Filter {

       
    public AuthenticationFilter() {
        super();
       
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    	
    	Participante participante = (Participante) SessionManager.getAttribute(request,AttributeNames.USER);
    	
    	if (participante!=null) {
    		// Usuario autenticado ...
    		// pass the request along the filter chain
			chain.doFilter(request, response);
    	} else {
    		HttpServletResponse httpResponse = (HttpServletResponse) response;
    		// TODO: Explicar el porque de las URL
    		httpResponse.sendRedirect("/DemoWebApp/"+Views.PARTICIPANTE_LOGIN);
    	}
    }
    
    public void init(FilterConfig fConfig) throws ServletException {
    }
    
    public void destroy() {
	}
}
