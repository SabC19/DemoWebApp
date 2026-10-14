package com.jal.ecommerce.controller;

import java.io.IOException;

import com.sabic.explorworld.service.ParticipanteService;
import com.sabic.explorworld.service.impl.ParticipanteServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/controller/private/participante")
public class PrivateParticipanteServlet extends HttpServlet {
    
	private ParticipanteService participanteService = null;
	
	
	public PrivateParticipanteServlet() {
        super();
        participanteService = new ParticipanteServiceImpl();
    }

	
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
    	String action = request.getParameter("action");
    	
    	if ("detail".equalsIgnoreCase(action)) {
    		//id
    		
    	} else if ("update".equalsIgnoreCase(action)) {
    		
    	} else {
    		// TODO: forward a pagina por error
    	}
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
