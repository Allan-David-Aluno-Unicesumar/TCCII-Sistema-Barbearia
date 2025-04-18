/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author allan
 */
@Entity
public class Agendamento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "servico_id")
    private Servico servico;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    
    private Usuario usuario;
    
    private double valor;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    
    private String observacao;

    
    public Agendamento() {
    }

    
    public Agendamento(Cliente cliente, Servico servico, Usuario usuario, double valor, String data, String observacao) {
        this.cliente = cliente;
        this.servico = servico;
        this.usuario = usuario;
        this.valor = valor;
        try {
            System.out.println(data);
            this.data = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(data);
        } catch (ParseException ex) {
            Logger.getLogger(Agendamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.observacao = observacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setBarbeiro(Usuario usuario) {
        this.usuario = usuario;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }
    
    public void setData(Date data) {
        this.data = data;
    }
    
    public String getDataFormatada() {
        return new SimpleDateFormat("dd/MM/yyyy").format(data);
    }
    
    public void setDataFormatada(String dataFormatada) {
        try {
            this.data = new SimpleDateFormat("dd/MM/yyyy").parse(dataFormatada);
        } catch (ParseException e) {
            e.printStackTrace(); // ou logue adequadamente
        }
    }
    
    public String getHoraFormatada() {
        return new SimpleDateFormat("HH:mm").format(data);
    }
    
    public void setHoraFormatada(String horaFormatada) {
        try {
            // Pegando apenas a hora, mantendo a data atual
            Date hora = new SimpleDateFormat("HH:mm").parse(horaFormatada);

            // Atualizando apenas hora e minuto na variável 'data' existente
            Calendar calData = Calendar.getInstance();
            calData.setTime(this.data != null ? this.data : new Date()); // usa a data existente, ou data atual
            Calendar calHora = Calendar.getInstance();
            calHora.setTime(hora);

            calData.set(Calendar.HOUR_OF_DAY, calHora.get(Calendar.HOUR_OF_DAY));
            calData.set(Calendar.MINUTE, calHora.get(Calendar.MINUTE));
            calData.set(Calendar.SECOND, 0);
            calData.set(Calendar.MILLISECOND, 0);

            this.data = calData.getTime();
        } catch (ParseException e) {
            e.printStackTrace(); // ou logue adequadamente
        }
    }
    
    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    
}
