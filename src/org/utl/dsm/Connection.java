/*
 *  Francisco Javier Rocha Aldana
 *  Programa que conecta mongodb con Java
 *  27 de febrero del 2023
 *  DSM501
 */
package org.utl.dsm;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rocha
 */
public class Connection{
    DB BaseDatos;
    DBCollection coleccion;
    BasicDBObject document=new BasicDBObject();

    public Connection() {
        try{
            Mongo mongo=new Mongo("localhost", 27017);
            BaseDatos=mongo.getDB("actividadCRUD501");
            coleccion=BaseDatos.getCollection("crud501");
            System.out.println("Conexion exitosa");
        } catch(UnknownError ex){
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*---------------------Metodos CRUD---------------------*/

    //Insertar
    public boolean insertar(String accion){
        document.put("accion", accion);
        coleccion.insert(document);
        return true;
    }
    
    //Mostrar
    public void mostrar(){
        DBCursor cursor=coleccion.find();
        while(cursor.hasNext()){
            System.out.println(cursor.next());
        }
    }
    
    //Actualizar
    public boolean actualizar(String accionAnterior, String accionNueva){
        document.put("accion", accionAnterior);
        BasicDBObject newDocument=new BasicDBObject();
        newDocument.put("accion", accionNueva);
        coleccion.findAndModify(document, newDocument);
        return true;
    }
    
    //Eliminar
    public boolean eliminar(String accion){
        document.put("accion", accion);
        coleccion.remove(document);
        return true;
    }
}
