/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.req.model;

/**
 *
 * @author Suporte
 */
public class Requisicao {
    
private int estab,numero,solicitante,autorizador,ccusto,donoRegistro, numreqest, fornecedor, estabReqest, estaboc, numerooc;
private double percatend, valorTotal;
private String dataabert, datafec,situacao,observacao, autorizado, respCompra, prazoCompra;
//percatend atendido
   
    public int getEstab() {
        return estab;
    }

    public void setEstab(int estab) {
        this.estab = estab;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(int solicitante) {
        this.solicitante = solicitante;
    }

    public int getAutorizador() {
        return autorizador;
    }

    public void setAutorizador(int autorizador) {
        this.autorizador = autorizador;
    }

    public int getCcusto() {
        return ccusto;
    }

    public void setCcusto(int ccusto) {
        this.ccusto = ccusto;
    }

    public int getDonoRegistro() {
        return donoRegistro;
    }

    public void setDonoRegistro(int donoRegistro) {
        this.donoRegistro = donoRegistro;
    }

    public int getNumreqest() {
        return numreqest;
    }

    public void setNumreqest(int numreqest) {
        this.numreqest = numreqest;
    }

    public int getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(int fornecedor) {
        this.fornecedor = fornecedor;
    }

    public int getEstabReqest() {
        return estabReqest;
    }

    public void setEstabReqest(int estabReqest) {
        this.estabReqest = estabReqest;
    }

    public int getEstaboc() {
        return estaboc;
    }

    public void setEstaboc(int estaboc) {
        this.estaboc = estaboc;
    }

    public int getNumerooc() {
        return numerooc;
    }

    public void setNumerooc(int numerooc) {
        this.numerooc = numerooc;
    }

    public double getPercatend() {
        return percatend;
    }

    public void setPercatend(double percatend) {
        this.percatend = percatend;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorToral) {
        this.valorTotal = valorToral;
    }

    public String getDataabert() {
        return dataabert;
    }

    public void setDataabert(String dataabert) {
        this.dataabert = dataabert;
    }

    public String getDatafec() {
        return datafec;
    }

    public void setDatafec(String datadec) {
        this.datafec = datafec;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getAutorizado() {
        return autorizado;
    }

    public void setAutorizado(String autorizado) {
        this.autorizado = autorizado;
    }

    public String getRespCompra() {
        return respCompra;
    }

    public void setRespCompra(String respCompra) {
        this.respCompra = respCompra;
    }

    public String getPrazoCompra() {
        return prazoCompra;
    }

    public void setPrazoCompra(String prazoCompra) {
        this.prazoCompra = prazoCompra;
    }


    
}
