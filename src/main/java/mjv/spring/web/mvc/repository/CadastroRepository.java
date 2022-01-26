package mjv.spring.web.mvc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mjv.spring.web.mvc.model.Cadastro;
import mjv.spring.web.mvc.model.Profissao;


@Repository
@Transactional
public interface CadastroRepository extends JpaRepository<Cadastro, Integer> {
	
	@Query("select p from Profissao p where p.nome like %?1%")
    public List<Profissao> findProfissaoByName(String nome);

    
}
	