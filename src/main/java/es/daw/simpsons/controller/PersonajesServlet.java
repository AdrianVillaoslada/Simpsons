package es.daw.simpsons.controller;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import es.daw.simpsons.util.Utils;
import es.daw.simpsons.servicio.PersonajeServicio;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import es.daw.simpsons.model.Personaje;

import jdk.jshell.execution.Util;

@WebServlet("/personajes")
public class PersonajesServlet extends HttpServlet {


    private final PersonajeServicio servicio = new PersonajeServicio();
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        // 1 . leer parametros del request
        String lugar = request.getParameter("lugar");

        String ordenarPor = request.getParameter("ordenarPor");

        boolean descendente = request.getParameter("descendente") != null;

        String edadMax = request.getParameter("edadMax");

        String limite = request.getParameter("limite");

        String ocupacion = request.getParameter("ocupacion");

        List<Personaje> personajes = new ArrayList<>();
        // 2. Tratar los parametros. conversiones y validaciones
        try {
            Integer edadMaxInt =  Utils.leerEntero("Edad Maxima", edadMax);
            Integer limiteInt = Utils.leerEntero("Limite", limite);

           personajes = servicio.buscar(lugar,edadMaxInt,ordenarPor,descendente,limiteInt, ocupacion);

        } catch (Exception e) {
            // escribir un mensaje de error en personajes.jsp
            request.setAttribute("error", e.getMessage());
        }
        // 3. Logica


        // 4. Pasar a la vista todo lo que necesite
        request.setAttribute("personajes", personajes);
        request.setAttribute("lugares", servicio.lugaresDisponibles());

        // 5. Reenviar a la lista (plantilla JSP)
        request.getRequestDispatcher("/personajes.jsp").forward(request, response);


    }

    public void destroy() {
    }
}
