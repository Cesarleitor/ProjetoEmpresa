package com.cesar.pedidos.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;



@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate data;


    @ManyToOne
    private Vendedor vendedor;

    @ManyToMany
    private List<Peca> pecas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Object getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {

    }

    public List<Peca> getPecas() {
        return pecas;
    }

    public void setPecas(List<Peca> pecas) {
        this.pecas = pecas;
    }

    public void setDataPedido(LocalDate now) {
    }
}
