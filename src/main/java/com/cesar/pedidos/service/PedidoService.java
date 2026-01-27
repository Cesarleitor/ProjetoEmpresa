package com.cesar.pedidos.service;

import com.cesar.pedidos.entity.Peca;
import com.cesar.pedidos.entity.Pedido;
import com.cesar.pedidos.entity.Vendedor;
import com.cesar.pedidos.repository.PecaRepository;
import com.cesar.pedidos.repository.PedidoRepository;
import com.cesar.pedidos.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private VendedorRepository vendedorRepository;

    @Autowired
    private PecaRepository pecaRepository;

    public Pedido criarPedido(Long vendedorId, List<Long> pecasIds) {
        Vendedor vendedor = vendedorRepository.findById(vendedorId)
                .orElseThrow(()  -> new RuntimeException("Vendedor não encontrado"));

        List<Peca> pecas = pecaRepository.findAllById(pecasIds);

        Pedido pedido = new Pedido();
        pedido.setDataPedido(LocalDate.now());
        pedido.setVendedor(vendedor);
        pedido.setPecas(pecas);

        return  pedidoRepository.save(pedido);
    }



}
