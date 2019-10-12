/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex2_copybytestexto;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;

/**
 *
 * @author oracle
 */
public class Ex2_copybytestexto {

    /**
     * @param args the command line arguments
     */
    public static ArrayList<Integer> listaBytes = new ArrayList<>();

    public static void main(String[] args) {

        //en este ejercicio solo usaremos los métodos de lectura/escritura
        //byte a byte, que son los más simples
            /*
         1)...
            
         2.1)Desenvolve unha pequena aplicacion que usando somente estas duas
         clases e os metodos indicados  copie  byte a byte o contido do
         ficheiro de texto chamado texto1.txt noutro ficheiro chamado
         texto2.txt
         */
        //Para que funcionen correctamente los métodos, declarar fuera
        //las variables e instanciar los objetos dentro !!!
        //Podemos hacer el código más simple si solo añadimos un único
        //try-catch con excepcion "Exception" para que las cubra todas????
        //o incluso con un throws??
        FileInputStream leer1 = null;

        try {
            //read identifica los saltos de línea o espacios como bytes!!!
            leer1 = new FileInputStream("/home/oracle/Desktop/ex2/texto1.txt");

            //este método read lee byte a byte
            //también se podría hacer con un Iterator
            int valByte = 0;

            while (valByte != -1) {

                try {
                    valByte = leer1.read();
                    listaBytes.add(valByte);

                } catch (IOException ex) {
                    Logger.getLogger(Ex2_copybytestexto.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            //comprobación
            System.out.println(listaBytes);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ex2_copybytestexto.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                leer1.close();
            } catch (IOException ex) {
                Logger.getLogger(Ex2_copybytestexto.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

//        FileOutputStream escribir1 = null;
//
//        try {
//            escribir1 = new FileOutputStream("/home/oracle/Desktop/ex2/texto2.txt");
//
//            for (Integer z : listaBytes) {
//
//                if (z == -1) {
//
//                    try {
//                        escribir1.close();
//                    } catch (IOException ex) {
//                        Logger.getLogger(Ex2_copybytestexto.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//
//                } else {
//
//                    try {
//                        escribir1.write(z);
//                    } catch (IOException ex) {
//                        Logger.getLogger(Ex2_copybytestexto.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//
//                }
//
//            }
//
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(Ex2_copybytestexto.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//
//            try {
//                escribir1.close();
//            } catch (IOException ex) {
//                Logger.getLogger(Ex2_copybytestexto.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//        }

        /*
         2.2)
         Fai a modifica necesaria na aplicacion anterior para que se engada de 
         novo o texto do ficheiro texto1.txt ao ficheiro texto2.txt
         */
        FileOutputStream escribir1 = null;

        try {
            escribir1 = new FileOutputStream("/home/oracle/Desktop/ex2/texto2.txt", true);

            for (Integer z : listaBytes) {

                if (z == -1) {

                    try {
                        escribir1.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Ex2_copybytestexto.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else {

                    try {
                        escribir1.write(z);
                    } catch (IOException ex) {
                        Logger.getLogger(Ex2_copybytestexto.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ex2_copybytestexto.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                escribir1.close();
            } catch (IOException ex) {
                Logger.getLogger(Ex2_copybytestexto.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

}
