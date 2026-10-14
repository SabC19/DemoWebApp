package com.jal.ecommerce.controller;

import java.io.IOException;

import com.jal.ecommerce.util.AttributeNames;
import com.jal.ecommerce.util.PNames;
import com.jal.ecommerce.util.PValues;
import com.jal.ecommerce.util.SessionManager;
import com.jal.ecommerce.view.Views;
import com.sabic.explorworld.model.Participante;
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
@WebServlet("/controller/public/participante")
public class PublicParticipanteServlet extends HttpServlet {
       
    private ParticipanteService participanteService = null;
	
    public PublicParticipanteServlet() {
        super();
        participanteService = new ParticipanteServiceImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter(PNames.ACTION);
		if (PValues.ACTION_LOGIN.equalsIgnoreCase(action)) {
			String email = request.getParameter(PNames.LOGIN);
			String password = request.getParameter(PNames.PASSWORD);
			try {
				Participante participante = participanteService.login(email, password);
				SessionManager.setAttribute(request, AttributeNames.USER, participante);
				request.getRequestDispatcher(Views.ACTIVIDAD_SEARCH).forward(request, response);
			} catch ServiceException e) {
				request.getRequestDispatcher(Views.PARTICIPANTE_LOGIN).forward(request, response);
			}
		} else if (PValues.ACTION_LOGOUT.equalsIgnoreCase(action)) {
			SessionManager.setAttribute(request, AttributeNames.USER, null);
			request.getRequestDispatcher(Views.HOME).forward(request, response);
			
		} else if (PValues.ACTION_DETAIL.equalsIgnoreCase (action)) {
			// id
		} else {
			// TODO: forward a pagina por error
		}
		
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
