
package org.utl.dsm;

/**
 *
 * @author rocha
 */
public class JavaMongo{
    public static void main(String[] args){
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
