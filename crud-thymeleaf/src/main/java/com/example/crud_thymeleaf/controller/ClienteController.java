package com.example.crud_thymeleaf.controller;

import com.example.crud_thymeleaf.model.Cliente;
import com.example.crud_thymeleaf.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cliente")  // A rota está no formato "/cliente"
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public String listarClientes(Model model) {
        model.addAttribute("cliente", clienteRepository.findAll());
        return "cliente";  // Mapeando para o template "cliente.html"
    }

    @GetMapping("/novo")
    public String exibirFormularioNovoCliente(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "formulario_cliente";  // Mapeando para o template "formulario_cliente.html"
    }

    @PostMapping
    public String salvarCliente(@ModelAttribute Cliente cliente) {
        clienteRepository.save(cliente);
        return "redirect:/cliente";  // Redireciona de volta para "/cliente"
    }

    @GetMapping("/editar/{id}")
    public String editarCliente(@PathVariable Long id, Model model) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Cliente inválido: " + id));
        model.addAttribute("cliente", cliente);
        return "formulario_cliente";  // Mapeando para o template "formulario_cliente.html"
    }

    @GetMapping("/excluir/{id}")
    public String excluirCliente(@PathVariable Long id) {
        clienteRepository.deleteById(id);
        return "redirect:/cliente";  // Redireciona de volta para "/cliente"
    }
}
