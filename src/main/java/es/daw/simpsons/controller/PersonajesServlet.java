package es.daw.simpsons.controller;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Personaje;
import servicio.PersonajeServicio;

@WebServlet("/personajes")
public class PersonajesServlet extends HttpServlet {

    private final PersonajeServicio servicio = new PersonajeServicio();

    @Override
    public void init(ServletConfig config) throws ServletException{
        super.init(config);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
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