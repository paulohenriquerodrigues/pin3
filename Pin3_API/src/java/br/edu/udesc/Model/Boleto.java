package br.edu.udesc.Model;

import java.util.Date;

/**
 *
 * @author paulohenrique
 */
public class Boleto {
    
    private int id;
    private String codigobarras;
    private String linhadigitavel;
    private Date datavencimento;
    private boolean pago;

    public Boleto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigobarras() {
        return codigobarras;
    }

    public void setCodigobarras(String codigobarras) {
        this.codigobarras = codigobarras;
    }

    public String getLinhadigitavel() {
        return linhadigitavel;
    }

    public void setLinhadigitavel(String linhadigitavel) {
        this.linhadigitavel = linhadigitavel;
    }

    public Date getDatavencimento() {
        return datavencimento;
    }

    public void setDatavencimento(Date datavencimento) {
        this.datavencimento = datavencimento;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }
    
}
