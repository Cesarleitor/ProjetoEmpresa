package com.cesar.pedidos.controller;


import com.cesar.pedidos.entity.Vendedor;
import com.cesar.pedidos.service.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendedores")
public class VendedorController {

    @Autowired
    private VendedorService service;

    @PostMapping
    public Vendedor criar(@RequestBody Vendedor vendedor) {
        return service.salvar(vendedor);
    }

    @GetMapping
    public List<Vendedor> listar() {
        return service.Listar();
    }


}
