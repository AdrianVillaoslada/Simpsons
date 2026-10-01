package es.daw.simpsons.controller;

import java.io.*;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import es.daw.simpsons.model.Personaje;
import es.daw.simpsons.servicio.PersonajeServicio;

@WebServlet("/personajes")
public class PersonajesServlet extends HttpServlet {


    private final PersonajeServicio servicio = new PersonajeServicio();
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        // 1 . leer parametros del request
        String lugar = request.getParameter("lugar");
        String ordenarPor = request.getParameter("ordenarPor");
        boolean descendente = request.getParameter("descendente") != null  ? Boolean.parseBoolean(request.getParameter("descendente")) : false;
        String edadMax = request.getParameter("edadMax");
        String limite = request.getParameter("limite");

        // 2. Tratar los parametros. conversiones y validaciones

        // 3. Logica
        List<Personaje> personajes = servicio.buscar();

        // 4. Pasar a la vista todo lo que necesite
        request.setAttribute("personajes", personajes);

        // 5. Reenviar a la lista (plantilla JSP)
        request.getRequestDispatcher("/personajes.jsp").forward(request, response);


    }

    public void destroy() {
    }
}
