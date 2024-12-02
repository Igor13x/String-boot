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
        model.addAttribute("pedido", new Pedido()); // Corrigido para "pedido"
        model.addAttribute("clientes", clienteRepository.findAll()); // Corrigido para "clientes"
        model.addAttribute("produtos", produtoRepository.findAll()); // Preservado
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

    @GetMapping("/pedidos")
    public String redirecionarParaPedidos() {
        return "redirect:/pedidos";
    }

    @GetMapping("/editar/{id}")
    public String editarPedido(@PathVariable Long id, Model model) {
        Pedido pedido = pedidoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Pedido inválido: " + id));
        model.addAttribute("pedido", pedido); // Passa o pedido existente para o template
        model.addAttribute("clientes", clienteRepository.findAll()); // Passa a lista de clientes
        model.addAttribute("produtos", produtoRepository.findAll()); // Passa a lista de produtos
        return "formulario_pedido"; // Mapeia para o template de edição
    }

}
