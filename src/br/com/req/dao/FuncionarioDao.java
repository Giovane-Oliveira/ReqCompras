/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.req.dao;

import br.com.req.jdbc.ConnectionFactory;
import br.com.req.model.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Suporte
 */
public class FuncionarioDao {

    private Connection con;

    public FuncionarioDao() {
        this.con = new ConnectionFactory().getConnection();
    }

    public List<Funcionario> ListarFuncionarios() {

        try {
            List<Funcionario> lista = new ArrayList<>();
            String sql = "SELECT codigo, nome from tabcli WHERE funcionario = 'T' ";
            PreparedStatement stmt = con.prepareStatement(sql);
            //stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Funcionario obj = new Funcionario();
                obj.setCodigo(rs.getInt("codigo"));
                obj.setNome(rs.getString("nome"));
                lista.add(obj);

            }
            return lista;

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "" + e);

        }
        return null;
    }

    
      public List<Funcionario> ListarFornecedor() {

        try {
            List<Funcionario> lista = new ArrayList<>();
            String sql = "SELECT codigo, nome from tabcli WHERE funcionario = 'F' ";
            PreparedStatement stmt = con.prepareStatement(sql);
            //stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Funcionario obj = new Funcionario();
                obj.setCodigo(rs.getInt("codigo"));
                obj.setNome(rs.getString("nome"));
                lista.add(obj);

            }
            return lista;

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "" + e);

        }
        return null;
    }
      
      
      public String FuncionariosPorNumero(int numero) {
        try {
            
            String sql = "SELECT nome from tabcli WHERE funcionario = 'T'and codigo =?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, numero);
            ResultSet rs = stmt.executeQuery();
            String nome = null;
            if (rs.next()) {
                
                
                nome = rs.getString("nome");
                

            }else{
                    
                //JOptionPane.showMessageDialog(null,"Funcionário não encontrado");
                    
                    }
            return nome;

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "" + e);

        }
        return null;

    }
    
      
      public String AutorizadorPorNumero(int numero) {
        try {
            
            String sql = "SELECT nome from tabcli WHERE funcionario = 'T'and codigo =?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, numero);
            ResultSet rs = stmt.executeQuery();
            String nome = null;
            if (rs.next()) {
                
                
              nome = rs.getString("nome");
                

            }else{
                    
                //JOptionPane.showMessageDialog(null,"Funcionário não encontrado");
                    
                    }
            return nome;

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "" + e);

        }
        return null;

    }
      
      
    
    public List<Funcionario> listarFuncionariosPorNome(String nome) {
        try {
            List<Funcionario> lista = new ArrayList<>();
            String sql = "SELECT codigo, nome from tabcli WHERE funcionario = 'T'and nome like ? ";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Funcionario obj = new Funcionario();
                obj.setCodigo(rs.getInt("codigo"));
                obj.setNome(rs.getString("nome"));
                lista.add(obj);

            }else{
                    
                JOptionPane.showMessageDialog(null,"Funcionário não encontrado");
                    
                    }
            return lista;

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "" + e);

        }
        return null;

    }
    
    
      public String FornecedoresPorNumero(int numero) {
        try {
            
            String sql = "SELECT nome from tabcli WHERE funcionario = 'F' and codigo =? ";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, numero);
            ResultSet rs = stmt.executeQuery();
            String nome = null;
            if (rs.next()) {
               
                nome = rs.getString("nome");
               

            }else{
                    
                //JOptionPane.showMessageDialog(null,"Fornecedor não encontrado");
                    
                    }
            return nome;

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "" + e);

        }
        return null;

    }
    
    
    public List<Funcionario> listarFornecedoresPorNome(String nome) {
        try {
            List<Funcionario> lista = new ArrayList<>();
            String sql = "SELECT codigo, nome from tabcli WHERE funcionario = 'F'and nome like ? ";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Funcionario obj = new Funcionario();
                obj.setCodigo(rs.getInt("codigo"));
                obj.setNome(rs.getString("nome"));
                lista.add(obj);

            }else{
                    
                JOptionPane.showMessageDialog(null,"Fornecedor não encontrado");
                    
                    }
            return lista;

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "" + e);

        }
        return null;

    }

}
