/*
 *  Francisco Javier Rocha Aldana
 *  Programa que conecta mongodb con Java
 *  27 de febrero del 2023
 *  DSM501
 */
package javamongo501;

/**
 *
 * @author rocha
 */
public class JavaMongo501 {
    public static void main(String[] args) {
        Connection conexion=new Connection();
        conexion.mostrar();
        conexion.insertar("Nadar");
        System.out.println("Otro");
        conexion.mostrar();
        System.out.println("Otro mas");
        conexion.actualizar("Nadar", "Brincar");
        conexion.eliminar("Brincar");
        conexion.mostrar();
    }
    
}
