package com.cesar.pedidos.controller;


import com.cesar.pedidos.entity.Pedido;
import com.cesar.pedidos.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private PedidoService service;

    public PedidoController(PedidoService service) {
        this.service = service;
    }

    @PostMapping
    public Pedido criarPedido(
            @RequestParam Long vendedorId,
            @RequestBody List<Long> pecasIds
            ) {
        return service.criarPedido(vendedorId, pecasIds);
    }

    @GetMapping("/teste")
    public String teste() {
        return "API funcionando";
    }
}
