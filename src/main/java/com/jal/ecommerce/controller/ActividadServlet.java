package com.jal.ecommerce.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.jal.ecommerce.util.AttributeNames;
import com.jal.ecommerce.view.Views;
import com.sabic.explorworld.dao.criteria.ActividadCriteria;
import com.sabic.explorworld.model.ActividadDTO;
import com.sabic.explorworld.service.ActividadService;
import com.sabic.explorworld.service.impl.ActividadServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ActividadServlet
 */
@WebServlet("/controller/private/actividad")
public class ActividadServlet extends HttpServlet {
	
	private ActividadService actividadService = null;

    public ActividadServlet() {
    	actividadService = new ActividadServiceImpl();
    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		
		String action = request.getParameter("action");
		
		if ("detail".equalsIgnoreCase(action)) {
			// Action: Ver detalle sobre una actividad
			String idStr = request.getParameter("id");
			// ActividadCriteria criteria = new ActividadCriteria();
			// criteria.setId(Long.valueOf(idStr));
			try {
				ActividadDTO actividad = actividadService.findById(Long.valueOf(idStr));
				// Se encarga de dirigir a la vista de detalle de actividad
				request.setAttribute("actividad", actividad);
				request.getRequestDispatcher(Views.ACTIVIDAD_DETAIL).forward(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else if ("search".equalsIgnoreCase(action)) {
			// Action: Buscar Actividades
			String nombre = request.getParameter("nombre");
			String fechaInicio = request.getParameter("fechaInico");
			
			ActividadCriteria criteria = new ActividadCriteria();
			criteria.setNombre(nombre);
			try {
				Results<ActividadDTO> results = actividadService.findByCriteria(criteria, 1, Integer.MAX_VALUE);
				// Reenviar a la vista
				request.setAttribute(AttributeNames.RESULTS, results);
				request.getRequestDispatcher(Views.ACTIVIDAD_SEARCH).forward(request, response);
			} catch (ServiceException) se) {
				se.printStackTrace();
			}
		} else if ("delete".equalsIgnoreCase (action)) {
			// Action: Eliminar Actividad
			String idStr = request.getParameter("id");
			try {
				actividadService.delete(Long.valueOf(idStr));
			} catch (ServiceException se) {
				se.printStackTrace();
				writer.append("<i>No ha podido borrarse la actividad, Por favor contacte con un administrador</i>");
			}
		} else {
			// Ninguna accion
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
