/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.req.dao;

import br.com.req.jdbc.ConnectionFactory;
import br.com.req.jdbc.SQLiteJDBCDriverConnection;
import br.com.req.model.Funcionario;
import br.com.req.model.Item;
import br.com.req.model.Requisicao;
import br.com.req.model.RequisicaoItem;
import br.com.req.view.ReqCompras;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import javax.swing.JOptionPane;

/**
 *
 * @author Suporte
 */
public class ReqDAO {

    private Connection con;


    public ReqDAO() {
        this.con = new ConnectionFactory().getConnection();
    }
    
  
    



    public void cadastrarInipublico(String numeroReq, String data2, int stab2) {
            int n;
        try {
            String chave = stab2 + ";" + numeroReq;
            String data = data2;
            int stab = stab2;
           n = verificanumero(chave);
          // JOptionPane.showMessageDialog(null, "" + n + "\n" + chave);
           if(n == 0){
           String sql = "insert into inipublico(aplic, secao, chave, valor, donoregistro, data_atu, conexao, tela) values(?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, "LOCK");
            stmt.setString(2, "PEFREQ");
            stmt.setString(3,chave);
            stmt.setString(4,"1234");
            stmt.setInt(5,994);
            stmt.setString(6, "" + data  + " 00:00:00");
            stmt.setString(7, "12345");
            stmt.setString(8, "PefEd04");

            stmt.execute();

            stmt.close();

          //  JOptionPane.showMessageDialog(null, "Adicionado ao IniPublico");
           
           }else if( n == 1){
           
           // JOptionPane.showMessageDialog(null, "Este número " + numeroReq + " já está resevado para este usuário");
           }else{
           
           // JOptionPane.showMessageDialog(null, "Este número " + numeroReq + " já está resevado\n por outro usuário");
            int a = Integer.parseInt(numeroReq);
            int b = a + 1;
            ReqCompras req = ReqCompras.x;
            req.numeroReq.setText("" + String.valueOf(b));
            cadastrarInipublico( String.valueOf(b), data2, stab2);
           }
            

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "" + e);

        }

    }
    
    public int verificanumero(String chave){
        int x = 0;
    
   
    try{
    String sql = "SELECT * FROM inipublico where  DONOREGISTRO =994 and chave =?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, chave);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
            
                x = 1;
            
            }else{
            
           String sql1 = "SELECT * FROM inipublico where chave =?";
           PreparedStatement stmt1 = con.prepareStatement(sql1);
            stmt1.setString(1, chave);
            ResultSet rss = stmt1.executeQuery();
            
            if (rss.next()) {
            
                x = 2;
            
            }else{
            
            x = 0;
                
            }
           
           
            }
    
    
    }catch(SQLException e){
    
    
    }
          
    
    return x;
    
    }

    public void cadastrarReqItens(List<RequisicaoItem> item, int estab, int numero) {

        try {

            String sql = "insert into pefreqit(estab, numero, seq, item, descinformada, complemento, quantidade, atendido, unidade, donoregistro,"
                    + "valorunit, valortotal, codigoext) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement stmt = con.prepareStatement(sql);

            for (RequisicaoItem c : item) {

                stmt.setInt(1, estab);
                stmt.setInt(2, numero);
                stmt.setInt(3, c.getSeq());
                stmt.setInt(4, c.getItem());
                stmt.setString(5, c.getDescInformada());
                stmt.setString(6, c.getComplemento());
                stmt.setDouble(7, c.getQuantidade());
                stmt.setString(8, c.getAtendido());
                stmt.setString(9, c.getUnidade());
                stmt.setInt(10, 0);
                stmt.setDouble(11, c.getValorUnitario());
                stmt.setDouble(12, c.getValorTotal());
                stmt.setString(13, c.getCodigoExt());

                stmt.execute();

            }

            stmt.close();

            JOptionPane.showMessageDialog(null, "Cadastro realizado com  sucesso");

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "" + e);

        }

    }

    public void cadastrarRequisicao(Requisicao obj) {

        try {

            String sql = "insert into pefreq(estab, numero, dataabert, datafec, situacao, observacao, solicitante, autorizador,"
                    + "ccusto, percatend, donoregistro, autorizado, valortotal, numreqest,fornecedor, estabreqest,"
                    + "estaboc, numerooc, respcompra, prazocompra)"
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getEstab());
            stmt.setInt(2, obj.getNumero());
            stmt.setString(3, obj.getDataabert());
            stmt.setString(4, obj.getDatafec());
            stmt.setString(5, obj.getSituacao());
            stmt.setString(6, obj.getObservacao());
            stmt.setInt(7, obj.getSolicitante());
            stmt.setInt(8, obj.getAutorizador());
            stmt.setInt(9, obj.getCcusto());
            stmt.setDouble(10, obj.getPercatend());
            stmt.setInt(11, obj.getDonoRegistro());
            stmt.setString(12, obj.getAutorizado());
            stmt.setDouble(13, obj.getValorTotal());
            stmt.setInt(14, obj.getNumreqest());
            stmt.setInt(15, obj.getFornecedor());
            stmt.setInt(16, obj.getEstabReqest());
            stmt.setInt(17, obj.getEstaboc());
            stmt.setInt(18, obj.getNumerooc());
            stmt.setString(19, obj.getRespCompra());
            stmt.setString(20, obj.getPrazoCompra());

            stmt.execute();
            stmt.close();

           // JOptionPane.showMessageDialog(null, "Cadastro realizado com  sucesso");

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "" + e);

        }

    }

    public Requisicao primeiraReq(int n) {

        try {

            String sql = "SELECT * from pefreq where estab =?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, n);
            ResultSet rs = stmt.executeQuery();
            Requisicao obj = new Requisicao();
            if (rs.first()) {

                obj.setEstab(rs.getInt("estab"));
                obj.setDataabert(rs.getString("dataabert"));
                obj.setDatafec(rs.getString("datafec"));
                obj.setSituacao(rs.getString("situacao"));
                obj.setObservacao(rs.getString("observacao"));
                obj.setSolicitante(rs.getInt("solicitante"));
                obj.setAutorizador(rs.getInt("autorizador"));
                obj.setPercatend(rs.getDouble("percatend"));
                obj.setDonoRegistro(rs.getInt("donoregistro"));
                obj.setAutorizado(rs.getString("autorizado"));
                obj.setValorTotal(rs.getDouble("valortotal"));
                obj.setNumreqest(rs.getInt("numreqest"));
                obj.setFornecedor(rs.getInt("fornecedor"));
                obj.setEstabReqest(rs.getInt("estabreqest"));
                obj.setEstaboc(rs.getInt("estaboc"));
                obj.setNumerooc(rs.getInt("numerooc"));
                obj.setRespCompra(rs.getString("respcompra"));
                obj.setPrazoCompra(rs.getString("prazocompra"));
                obj.setNumero(rs.getInt("numero"));

            }
            return obj;

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "" + e);

        }
        return null;

    }

    public Requisicao ultimaReq(int n) {

        try {

            String sql = "SELECT * from pefreq where estab =? order by numero DESC LIMIT 1";
            PreparedStatement stmt = con.prepareStatement(sql);
             stmt.setInt(1, n);
            ResultSet rs = stmt.executeQuery();
            Requisicao obj = new Requisicao();
            if (rs.next()) {

                obj.setEstab(rs.getInt("estab"));
                obj.setDataabert(rs.getString("dataabert"));
                obj.setDatafec(rs.getString("datafec"));
                obj.setSituacao(rs.getString("situacao"));
                obj.setObservacao(rs.getString("observacao"));
                obj.setSolicitante(rs.getInt("solicitante"));
                obj.setAutorizador(rs.getInt("autorizador"));
                obj.setPercatend(rs.getDouble("percatend"));
                obj.setDonoRegistro(rs.getInt("donoregistro"));
                obj.setAutorizado(rs.getString("autorizado"));
                obj.setValorTotal(rs.getDouble("valortotal"));
                obj.setNumreqest(rs.getInt("numreqest"));
                obj.setFornecedor(rs.getInt("fornecedor"));
                obj.setEstabReqest(rs.getInt("estabreqest"));
                obj.setEstaboc(rs.getInt("estaboc"));
                obj.setNumerooc(rs.getInt("numerooc"));
                obj.setRespCompra(rs.getString("respcompra"));
                obj.setPrazoCompra(rs.getString("prazocompra"));
                obj.setNumero(rs.getInt("numero"));
            }
            return obj;

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "" + e);

        }
        return null;

    }
    
    


    public ListIterator <Requisicao> anteriorReq(int m) {
      
        try {
            
            
           
          /*ReqCompras req = ReqCompras.x;
          String l = req.estab.getItemAt(0).toString();
          int n = Integer.parseInt(l);*/
            String sql = "SELECT * from pefreq where estab =?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, m);

            ResultSet rs = stmt.executeQuery();

            ArrayList<Requisicao> r = new ArrayList<Requisicao>();
            while (rs.next()) {
                Requisicao obj = new Requisicao();

                  obj.setEstab(rs.getInt("estab"));
                obj.setNumero(rs.getInt("numero"));
                obj.setDataabert(rs.getString("dataabert"));
                obj.setDatafec(rs.getString("datafec"));
                obj.setSituacao(rs.getString("situacao"));
                obj.setObservacao(rs.getString("observacao"));
                obj.setSolicitante(rs.getInt("solicitante"));
                obj.setAutorizador(rs.getInt("autorizador"));
                obj.setPercatend(rs.getDouble("percatend"));
                obj.setDonoRegistro(rs.getInt("donoregistro"));
                obj.setAutorizado(rs.getString("autorizado"));
                obj.setValorTotal(rs.getDouble("valortotal"));
                obj.setNumreqest(rs.getInt("numreqest"));
                obj.setFornecedor(rs.getInt("fornecedor"));
                obj.setEstabReqest(rs.getInt("estabreqest"));
                obj.setEstaboc(rs.getInt("estaboc"));
                obj.setNumerooc(rs.getInt("numerooc"));
                obj.setRespCompra(rs.getString("respcompra"));
                obj.setPrazoCompra(rs.getString("prazocompra"));
                r.add(obj);

            }
            
            ListIterator <Requisicao> i = r.listIterator();  

           
            return i;

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "" + e);

        }
        return null;

    }

    public List<Item> ListarItens() {

        try {
            List<Item> lista = new ArrayList<>();
            String sql = "SELECT codigo, grupo, UNIDADE, DESCRICAO FROM tabitens  group by grupo, UNIDADE, DESCRICAO";
            PreparedStatement stmt = con.prepareStatement(sql);
            //stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Item obj = new Item();
                obj.setCodigo(rs.getInt("codigo"));
                obj.setGrupo(rs.getInt("grupo"));
                obj.setUnidade(rs.getString("unidade"));
                obj.setDescricao(rs.getString("descricao"));
                lista.add(obj);

            }
            return lista;

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "" + e);

        }
        return null;
    }
    
    
     public Iterator proximaReq() {

        try {

            String sql = "SELECT * from pefreq";
            PreparedStatement stmt = con.prepareStatement(sql);
            //stmt.setString(1, String.valueOf(numero));

            ResultSet rs = stmt.executeQuery();

            ArrayList<Requisicao> r = new ArrayList<Requisicao>();
            while (rs.next()) {
                Requisicao obj = new Requisicao();
                obj.setEstab(rs.getInt("estab"));
                obj.setNumero(rs.getInt("numero"));
                obj.setDataabert(rs.getString("dataabert"));
                obj.setDatafec(rs.getString("datafec"));
                obj.setSituacao(rs.getString("situacao"));
                obj.setObservacao(rs.getString("observacao"));
                obj.setSolicitante(rs.getInt("solicitante"));
                obj.setAutorizador(rs.getInt("autorizador"));
                obj.setPercatend(rs.getDouble("percatend"));
                obj.setDonoRegistro(rs.getInt("donoregistro"));
                obj.setAutorizado(rs.getString("autorizado"));
                obj.setValorTotal(rs.getDouble("valortotal"));
                obj.setNumreqest(rs.getInt("numreqest"));
                obj.setFornecedor(rs.getInt("fornecedor"));
                obj.setEstabReqest(rs.getInt("estabreqest"));
                obj.setEstaboc(rs.getInt("estaboc"));
                obj.setNumerooc(rs.getInt("numerooc"));
                obj.setRespCompra(rs.getString("respcompra"));
                obj.setPrazoCompra(rs.getString("prazocompra"));

                r.add(obj);

            }

            Iterator i = r.iterator();
            return i;

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "" + e);

        }
        return null;

    }


    public Requisicao ConsultarRequisicao(int numero, int estab) {

        try {

            String sql = "SELECT * from pefreq where numero=? and estab=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, numero);
            stmt.setInt(2, estab);

            ResultSet rs = stmt.executeQuery();

           Requisicao obj = new Requisicao();
            while (rs.next()) {
                
                obj.setEstab(rs.getInt("estab"));
                obj.setNumero(rs.getInt("numero"));
                obj.setDataabert(rs.getString("dataabert"));
                obj.setDatafec(rs.getString("datafec"));
                obj.setSituacao(rs.getString("situacao"));
                obj.setObservacao(rs.getString("observacao"));
                obj.setSolicitante(rs.getInt("solicitante"));
                obj.setAutorizador(rs.getInt("autorizador"));
                obj.setPercatend(rs.getDouble("percatend"));
                obj.setDonoRegistro(rs.getInt("donoregistro"));
                obj.setAutorizado(rs.getString("autorizado"));
                obj.setValorTotal(rs.getDouble("valortotal"));
                obj.setNumreqest(rs.getInt("numreqest"));
                obj.setFornecedor(rs.getInt("fornecedor"));
                obj.setEstabReqest(rs.getInt("estabreqest"));
                obj.setEstaboc(rs.getInt("estaboc"));
                obj.setNumerooc(rs.getInt("numerooc"));
                obj.setRespCompra(rs.getString("respcompra"));
                obj.setPrazoCompra(rs.getString("prazocompra"));

            

            }
                  return obj;
            
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "" + e);

        }
        return null;

    }

    public List<RequisicaoItem> consultarItemReq(int numero) {

        try {
            List<RequisicaoItem> lista = new ArrayList<>();
            String sql = "select * from pefreqit where numero=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, numero);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                RequisicaoItem obj = new RequisicaoItem();
                obj.setSeq(rs.getInt("seq"));
                obj.setItem(rs.getInt("item"));
                obj.setDescInformada(rs.getString("descinformada"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setQuantidade(rs.getInt("quantidade"));
                if (rs.getString("atendido").equals("F")) {

                    obj.setAtendido("Nao");

                } else {

                    obj.setAtendido("Sim");

                }

                obj.setUnidade(rs.getString("unidade"));
                obj.setDonoRegistro(rs.getInt("donoregistro"));
                obj.setValorUnitario(rs.getInt("valorunit"));
                obj.setValorTotal(rs.getInt("valortotal"));
                obj.setCodigoExt(rs.getString("codigoext"));

                lista.add(obj);

            }
            return lista;

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "" + e);

        }
        return null;

    }

    public List<Item> consultarItemReqPorDesc(String desc) {

        try {
            List<Item> lista = new ArrayList<>();
            String sql = "SELECT codigo, grupo, UNIDADE, DESCRICAO FROM tabitens WHERE DESCRICAO like ? group by grupo, UNIDADE, DESCRICAO";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, desc);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Item obj = new Item();
                obj.setCodigo(rs.getInt("codigo"));
                obj.setGrupo(rs.getInt("grupo"));
                obj.setUnidade(rs.getString("unidade"));
                obj.setDescricao(rs.getString("descricao"));

                lista.add(obj);

            }
            return lista;

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "" + e);

        }
        return null;

    }

    public Requisicao consultarUltimoIdRequisicao(int n) {

        try {

            String sql = "SELECT * from pefreq where estab = ? order by numero DESC LIMIT 1";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, n);
            ResultSet rs = stmt.executeQuery();
            Requisicao obj = new Requisicao();
            if (rs.next()) {
                int x = rs.getInt("numero");
                int y = x + 1;
                obj.setNumero(y);

            }
            return obj;

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "" + e);

        }
        return null;

    }

}
