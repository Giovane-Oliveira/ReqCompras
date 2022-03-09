/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.req.jdbc;


import br.com.req.dao.ConfigSQlite;
import br.com.req.model.ConfigSQL;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Giovane Oliveira
 */
public class ConnectionFactory {
   
   public static java.sql.Connection getConnection(){
try{
    ConfigSQL sql = new ConfigSQlite().buscarConfig();
  
 /*public static String ip, base, usuario, senha;*/
//return DriverManager.getConnection("jdbc:mysql://192.168.1.12/zada","root","root.csb");
return DriverManager.getConnection("jdbc:mysql://"+sql.getIp()+"/" + sql.getBase(),""+sql.getUsuario(),""+sql.getSenha());

}catch(Exception erro){
throw new RuntimeException(erro);
}
    }

  
} 

   

