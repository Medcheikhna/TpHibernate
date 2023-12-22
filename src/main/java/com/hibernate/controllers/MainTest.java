package com.hibernate.controllers;

import com.hibernate.models.Artiste;

public class MainTest {
    public static void main(String[] args) {
        TestsHibernate t =new TestsHibernate();
        Artiste ar=new Artiste();
        ar.setNom("Med");
        ar.setPrenom("sidi 3li");
        ar.setAnnee_naissance(23);
        t.InsertArt(ar);
    }
}
