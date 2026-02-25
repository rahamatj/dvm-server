package xyz.rahamatj.dvm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.rahamatj.dvm.model.Symbol;
import xyz.rahamatj.dvm.repository.SymbolRepository;

import java.util.List;

@RestController
@RequestMapping("/api/symbols")
public class SymbolController {

    @Autowired
    private SymbolRepository symbolRepository;

    public SymbolController(SymbolRepository symbolRepository) {
        this.symbolRepository = symbolRepository;
    }

    @GetMapping("/")
    public List<Symbol> getAllSymbols() {
        return symbolRepository.findAll();
    }

}
