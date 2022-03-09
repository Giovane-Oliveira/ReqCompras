/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.req.dao;

import br.com.req.jdbc.SQLiteJDBCDriverConnection;
import br.com.req.model.ConfigSQL;
import br.com.req.view.ReqCompras;
import static java.lang.System.exit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Giovane Oliveira
 */
public class ConfigSQlite {
  private Connection sqlite;   
  
   public ConfigSQlite(){
    
    this.sqlite = new SQLiteJDBCDriverConnection().getConnection();
 
      try {
           Statement stmt = sqlite.createStatement();;
           stmt.execute("CREATE TABLE IF NOT EXISTS CONFIG(ID INTEGER,IP VARCHAR, BASE VARCHAR, USUARIO VARCHAR, SENHA VARCHAR)");
           
           boolean f = verifica();
           
           if(f ==  false){
           
                 stmt.execute("INSERT INTO CONFIG(ID, IP, BASE, USUARIO, SENHA) VALUES (1, '192.168.1.12', 'zada', 'root', 'root.csb')");
               JOptionPane.showMessageDialog(null, "Configuracao do servidor efetuada!\n Clique em ok e inicie o software novamente");
           }
           
         
           stmt.close();
           
          

          
      } catch (SQLException ex) {
          Logger.getLogger(ConfigSQlite.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
   
   public boolean verifica() throws SQLException{
   boolean x;
      // lendo os registros
            PreparedStatement stmt = sqlite.prepareStatement("select * from CONFIG");
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
               /*Integer id = resultSet.getInt("ID");
                String ip = resultSet.getString("IP");
                String base = resultSet.getString("BASE");
                String usuario = resultSet.getString("USUARIO");
                String senha = resultSet.getString("SENHA");
            
               System.out.println( "ID - " + id + "\nIP - " +ip + "\n"
                       + "BASE -" + base + "\nUsuario - " + usuario + "\n senha - " + senha);*/
                x = true;
            }else{
            
                x = false;
                
            }
            
            stmt.close();
   return x;
   
   }
   
   public ConfigSQL buscarConfig() throws SQLException{
   
      PreparedStatement stmt = sqlite.prepareStatement("select * from CONFIG");
            ResultSet resultSet = stmt.executeQuery();
           ConfigSQL sql =   new ConfigSQL();
            if (resultSet.next()) {
                 sql.setId(resultSet.getInt("ID"));
                sql.setIp(resultSet.getString("IP"));
                sql.setBase(resultSet.getString("BASE"));
                sql.setUsuario(resultSet.getString("USUARIO"));
                sql.setSenha(resultSet.getString("SENHA"));
            
             /*  System.out.println( "ID - " + id + "\nIP - " +ip + "\n"
                       + "BASE -" + base + "\nUsuario - " + usuario + "\n senha - " + senha);*/
                
            }
            stmt.close();
   return sql;
   }
   
   public void alterarConfig(ConfigSQL obj) {
        try {

            String sql = "UPDATE CONFIG set IP=?, BASE=?, USUARIO=?, "
                    + "SENHA=? WHERE ID=?";

            PreparedStatement stmt = sqlite.prepareStatement(sql);
            stmt.setString(1, obj.getIp());
            stmt.setString(2, obj.getBase());
            stmt.setString(3, obj.getUsuario());
            stmt.setString(4, obj.getSenha());
            stmt.setInt(5, obj.getId());
          


            stmt.executeUpdate();
            stmt.close();
            
            ReqCompras req = ReqCompras.x;
            if(req.certo == false){
            JOptionPane.showMessageDialog(null, "O programa vai ser fechado para que"
                    + " as novas configuracoes entrem em vigor.\n Posteriormente, abra-o novamente.\n"
                    + "Se abrir diretamente a tela de configuracao mais uma vez, revise as configuracoes,"
                    + " ou seja, o endereco de conexao com o servidor de acesso ao banco de dados.");
            exit(0);
            
            }else{
            
             JOptionPane.showMessageDialog(null, "Alterado com sucesso! Feche e abra o programa novamente para que as configuracoes entrem vigor");
             
            }

           

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "" + e);

        }

    }
    
}
