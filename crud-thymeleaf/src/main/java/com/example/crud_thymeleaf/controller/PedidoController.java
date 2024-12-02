package com.example.crud_thymeleaf.controller;

import com.example.crud_thymeleaf.model.Pedido;
import com.example.crud_thymeleaf.model.Cliente;
import com.example.crud_thymeleaf.model.Produto;
import com.example.crud_thymeleaf.repository.PedidoRepository;
import com.example.crud_thymeleaf.repository.ClienteRepository;
import com.example.crud_thymeleaf.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public String listarPedidos(Model model) {
        model.addAttribute("pedidos", pedidoRepository.findAll());
        return "pedidos";
    }

    @GetMapping("/novo")
    public String exibirFormularioNovoPedido(Model model) {
        model.addAttribute("pedido", new Pedido());
        model.addAttribute("clientes", clienteRepository.findAll());
        model.addAttribute("produtos", produtoRepository.findAll());
        return "formulario_pedido";
    }

    @PostMapping
    public String salvarPedido(@ModelAttribute Pedido pedido) {
        pedido.setData(LocalDate.now());
        pedidoRepository.save(pedido);
        return "redirect:/pedidos";
    }

    @GetMapping("/excluir/{id}")
    public String excluirPedido(@PathVariable Long id) {
        pedidoRepository.deleteById(id);
        return "redirect:/pedidos";
    }
}
