package com.cesar.pedidos.service;

import com.cesar.pedidos.entity.Vendedor;
import com.cesar.pedidos.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendedorService {

    @Autowired
    private VendedorRepository repository;

    public Vendedor salvar(Vendedor vendedor) {
        return repository.save(vendedor);
    }

    public List<Vendedor> Listar() {
        return repository.findAll();
    }
}
