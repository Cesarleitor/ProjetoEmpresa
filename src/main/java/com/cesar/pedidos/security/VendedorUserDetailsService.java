package com.cesar.pedidos.security;

import com.cesar.pedidos.entity.Vendedor;
import com.cesar.pedidos.repository.VendedorRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class VendedorUserDetailsService implements UserDetailsService {

    private final VendedorRepository vendedorRepository;

    public VendedorUserDetailsService(VendedorRepository vendedorRepository) {
        this.vendedorRepository = vendedorRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email)
        throws UsernameNotFoundException {

        Vendedor vendedor = vendedorRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Vendedor não encontrado"));

        return User.builder()
                .username(vendedor.getEmail())
                .password(vendedor.getSenha())
                .roles("VENDEDOR")
                .build();
    }
}
