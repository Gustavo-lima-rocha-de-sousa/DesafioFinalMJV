package mjv.spring.web.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mjv.spring.web.mvc.model.Cadastro;
import mjv.spring.web.mvc.repository.CadastroRepository;
import mjv.spring.web.mvc.repository.ProfissaoRepository;


@Service
public class CadastroService {
	@Autowired
	private CadastroRepository repository;
	
	@Autowired
	private ProfissaoRepository profissaoRepository;
	
	public void salvarCadastro(Cadastro cadastro) {
		boolean existeProf=profissaoRepository.existsById(cadastro.getProfissao().getId());
		if(existeProf) {
			repository.save(cadastro);
		}else {
			System.out.println("CADASTRO NÃO REALIZADO DEVIDO O ID DA PROFISSAO NAO EXISTIR NA BASE DE DADOS");
		}
	}
	
}
