package com.example.estudio1;

import android.widget.Toast;

import java.util.ArrayList;

public class DatosListView {

    public static ArrayList<String> listaPersonas;

    public static void InicializarArrayList () {

        listaPersonas = new ArrayList<String>();

        listaPersonas.add("Daniel");
        listaPersonas.add("Pedro");
        listaPersonas.add("Luis");
        listaPersonas.add("Juan");
    }

    public static void AniadirPersona () {

        listaPersonas.add("Julian");
    }

    public static boolean EliminarPersona() {

        if (listaPersonas.size() > 0) {
            listaPersonas.remove(listaPersonas.size() - 1);
            return true;
        } else  {
            return false;
        }


    }
}
