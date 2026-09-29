package es.daw.simpsons.controller;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Personaje;

@WebServlet("/personajes")
public class PersonajesServlet extends HttpServlet {


        response.setContentType("text/html");

        // 1 . leer parametros del request
        String lugar = request.getParameter("lugar");
        String ordenarPor = request.getParameter("ordenarPor");
        boolean descendente = request.getParameter("descendente") != null  ? Boolean.parseBoolean(request.getParameter("descendente")) : false;


        String edadMax = request.getParameter("edadMax");
        String limite = request.getParameter("limite");

        // 2. Tratar los parametros. conversiones y validaciones

        // 3. Logica


        // 4. Pasar a la vista todo lo que necesite

        // 5. Reenviar a la lista (plantilla JSP)



    }

    public void destroy() {
    }
}