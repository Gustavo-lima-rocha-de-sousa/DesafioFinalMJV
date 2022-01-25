package mjv.spring.web.mvc.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import mjv.spring.web.mvc.model.Cadastro;
import mjv.spring.web.mvc.model.Profissao;
import mjv.spring.web.mvc.repository.CadastroRepository;
import mjv.spring.web.mvc.repository.ProfissaoRepository;
import mjv.spring.web.mvc.service.CadastroService;

@Controller

public class CadastroController {

	@Autowired
	CadastroService service;
		
	@Autowired
	private ProfissaoRepository repository;
	@Autowired
	private CadastroRepository repository2;

	@PostConstruct
	public void carregrListas() {

	}

	@GetMapping("/")
    public ModelAndView index() {
        List<Profissao> profissoes = repository.findAll();
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("profissoes", profissoes);
        List<Cadastro> cadastros = repository2.findAll();
        mv.addObject("cadastros", cadastros);
        mv.addObject("cadastro", new Cadastro());
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/grava")
    public ModelAndView save(@Validated Cadastro cadastro) {
        service.salvarCadastro(cadastro);
        return index();
    }
	
    @GetMapping("/pesquisar")
    public ModelAndView pesquisar(@RequestParam ("nomepesquisa") String nomepesquisa) {
    	ModelAndView mv2 = new ModelAndView("index");
    	mv2.addObject("c.profissao.nome",repository2.findProfissaoByName(nomepesquisa));
    	mv2.addObject("profissoes", new Cadastro());
    	return mv2;    	
    }
    
    
}
	// GET: select
	// POST: insert
	// PUT: update
	// DELETE: delete

