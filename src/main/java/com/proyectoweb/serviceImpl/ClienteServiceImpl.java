package com.proyectoweb.serviceImpl;

import com.proyectoweb.dao.ClienteDao;
import com.proyectoweb.domain.Cliente;
import com.proyectoweb.service.ClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteServiceImpl implements ClienteService{
    @Autowired
    private ClienteDao clienteDao;
    
    @Override
    @Transactional(readOnly=true)
    public List<Cliente> getClientes(boolean activos) {
        List<Cliente> clientes = clienteDao.findAll();
        
        if (activos){
            clientes.removeIf(c -> !c.isActivo());
        }
        
        return clientes;
    }

    @Override
    public Cliente getCliente(Long cedula) {
        return clienteDao.findById(cedula).orElse(null);
    }
    
    @Override
    @Transactional
    public void save(Cliente cliente) {
        clienteDao.save(cliente);
    }

    @Override
    @Transactional
    public void delete(Cliente cliente) {
        clienteDao.delete(cliente);
    }
}
