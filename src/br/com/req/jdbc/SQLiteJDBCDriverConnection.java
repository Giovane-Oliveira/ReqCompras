/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.req.jdbc;


import java.sql.DriverManager;

/**
 *
 * @author Giovane Oliveira
 */
public class SQLiteJDBCDriverConnection {
    
    
      public static java.sql.Connection getConnection(){
try{
  
 /*public static String ip, base, usuario, senha;*/
//return DriverManager.getConnection("jdbc:mysql://192.168.1.12/zada","root","root.csb");
return DriverManager.getConnection("jdbc:sqlite:banco.db");

}catch(Exception erro){
throw new RuntimeException(erro);
}
    }
    
    
    
}
