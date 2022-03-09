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
public class RequisicaoItem {
private int stab,numero,seq,item, donoRegistro;
private double quantidade,valorUnitario, valorTotal;
private String descInformada, complemento, atendido,unidade,codigoExt;  

    public int getStab() {
        return stab;
    }

    public void setStab(int stab) {
        this.stab = stab;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public int getDonoRegistro() {
        return donoRegistro;
    }

    public void setDonoRegistro(int donoRegistro) {
        this.donoRegistro = donoRegistro;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getDescInformada() {
        return descInformada;
    }

    public void setDescInformada(String descInformada) {
        this.descInformada = descInformada;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getAtendido() {
        return atendido;
    }

    public void setAtendido(String atendido) {
        this.atendido = atendido;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String getCodigoExt() {
        return codigoExt;
    }

    public void setCodigoExt(String codigoExt) {
        this.codigoExt = codigoExt;
    }


    
    
}
