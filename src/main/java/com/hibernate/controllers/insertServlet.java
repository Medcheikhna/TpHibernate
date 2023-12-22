package com.hibernate.controllers;

import com.hibernate.models.Artiste;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class insertServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve form parameters
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String anneeNaissance = request.getParameter("anneeNaissance");

        // Create an instance of the Artiste model
        Artiste artiste = new Artiste();
        artiste.setNom(nom);
        artiste.setPrenom(prenom);
        artiste.setAnnee_naissance(Integer.parseInt(anneeNaissance));

        // Instantiate the Hibernate controller
        TestsHibernate tstHiber = new TestsHibernate();

        try {
            // Insert the artist into the database
            tstHiber.InsertArt(artiste);
            request.setAttribute("insertionReussie", true);
            request.setAttribute("art", artiste);
        } catch (Exception e) {
            // Handle the insertion failure
            e.printStackTrace();
            request.setAttribute("insertionReussie", false);
            request.setAttribute("erreurMessage", "Erreur lors de l'insertion : " + e.getMessage());
        }

        // Forward the request to the appropriate JSP page
        request.getRequestDispatcher("/insertion_confirm.jsp").forward(request, response);
    }

}
