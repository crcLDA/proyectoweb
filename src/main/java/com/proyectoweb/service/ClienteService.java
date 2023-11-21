package com.proyectoweb.service;

import com.proyectoweb.domain.Cliente;
import java.util.List;

public interface ClienteService {
    public List<Cliente> getClientes(boolean activos);
    
    public Cliente getCliente(Long cedula);
    
    public void save(Cliente cliente);
    
    public void delete(Cliente cliente);
}
