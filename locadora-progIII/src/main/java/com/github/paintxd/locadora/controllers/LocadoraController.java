package com.github.paintxd.locadora.controllers;

import com.github.paintxd.locadora.models.Carro;
import com.github.paintxd.locadora.models.Cliente;
import com.github.paintxd.locadora.models.Locacao;
import com.github.paintxd.locadora.models.Modelo;
import com.github.paintxd.locadora.models.dtos.CarroDto;
import com.github.paintxd.locadora.models.dtos.ClienteDto;
import com.github.paintxd.locadora.models.dtos.LocacaoDto;
import com.github.paintxd.locadora.models.dtos.ValorCarroDto;
import com.github.paintxd.locadora.repository.CarroRepository;
import com.github.paintxd.locadora.repository.ClienteRepository;
import com.github.paintxd.locadora.repository.CnhRepository;
import com.github.paintxd.locadora.repository.LocacaoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
public class LocadoraController {
    private static final String REDIRECT_HOME = "redirect:/home";

    private final ClienteRepository clienteRepository;
    private final CnhRepository cnhRepository;
    private final CarroRepository carroRepository;
    private final LocacaoRepository locacaoRepository;

    public LocadoraController(ClienteRepository clienteRepository, CnhRepository cnhRepository, CarroRepository carroRepository, LocacaoRepository locacaoRepository) {
        this.clienteRepository = clienteRepository;
        this.carroRepository = carroRepository;
        this.cnhRepository = cnhRepository;
        this.locacaoRepository = locacaoRepository;
    }

    @GetMapping("home")
    public String home(Model model) {
        model.addAttribute("carros", carroRepository.findAll());
        model.addAttribute("clientes", clienteRepository.findAll());
        model.addAttribute("locacoes", locacaoRepository.findAll());
        model.addAttribute("valorCarroDto", new ValorCarroDto());

        return "home";
    }

    @GetMapping("/cliente/cadastro")
    public String cadastroClientePage(Model model) {
        model.addAttribute("clienteDto", new ClienteDto());

        return "cadastro-cliente";
    }

    @PostMapping("/cliente/cadastro")
    public String cadastroCliente(@ModelAttribute ClienteDto clienteDto) {
        Cliente cliente = clienteRepository.save(clienteDto.createClient());
        cnhRepository.save(clienteDto.createCnh(cliente));

        return REDIRECT_HOME;
    }

    @GetMapping("/carro/cadastro")
    public String cadastroCarroPage(Model model) {
        model.addAttribute("carroDto", new CarroDto());
        model.addAttribute("modelos", Modelo.values());

        return "cadastro-carro";
    }

    @PostMapping("/carro/cadastro")
    public String cadastroCarro(@ModelAttribute CarroDto carroDto) {
        carroRepository.save(carroDto.createCarro());

        return REDIRECT_HOME;
    }

    @PostMapping("/carro/valor")
    public String atualizarValor(@ModelAttribute ValorCarroDto valorCarroDto) {
        Optional<Carro> optionalCarro = carroRepository.findById(valorCarroDto.getId());
        optionalCarro.ifPresent(carro -> {
            carro.setValorLocacao(valorCarroDto.getValorLocacao());
            carroRepository.save(carro);
        });

        return REDIRECT_HOME;
    }

    @GetMapping("/locacao/cadastro")
    public String locacaoPage(Model model) {
        Iterable<Locacao> locacoes = locacaoRepository.findAll();
        List<Long> carrosLocados = StreamSupport.stream(locacoes.spliterator(), false)
                .filter(locacao -> locacao.getDevolucao() == null)
                .map(locacao -> locacao.getCarro().getId())
                .collect(Collectors.toList());
        Iterable<Carro> carros = carroRepository.findAll();
        Iterable<Cliente> clientes = clienteRepository.findAll();

        List<Carro> carrosLocacao = StreamSupport.stream(carros.spliterator(), false)
                .filter(carro -> !carrosLocados.contains(carro.getId()))
                .collect(Collectors.toList());

        model.addAttribute("locacaoDto", new LocacaoDto());
        model.addAttribute("carrosLocacao", carrosLocacao);
        model.addAttribute("clientes", clientes);


        return "cadastro-locacao";
    }

    @PostMapping("/locacao/cadastro")
    public String locar(@ModelAttribute LocacaoDto locacaoDto) {
        Carro carro = carroRepository.findById(locacaoDto.getCarroId()).orElseThrow();
        Cliente cliente = clienteRepository.findById(locacaoDto.getClienteId()).orElseThrow();
        locacaoRepository.save(locacaoDto.createLocacao(carro, cliente));

        return REDIRECT_HOME;
    }

    @GetMapping("/locacao/finalizar/{id}")
    public String finalizarLocacao(@PathVariable String id) {
        Optional<Locacao> locacaoOptional = locacaoRepository.findById(Long.parseLong(id));
        locacaoOptional.ifPresent(locacao -> {
            locacao.setDevolucao();
            locacao.setMulta();
            locacao.setValorPago();
            locacaoRepository.save(locacao);
        });

        return REDIRECT_HOME;
    }
}
