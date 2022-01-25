package mjv.spring.web.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Optional;

import mjv.spring.web.mvc.model.Cadastro;
import mjv.spring.web.mvc.model.Profissao;


@Repository
@Transactional
public interface ProfissaoRepository extends JpaRepository<Profissao, Integer> {

    Optional<Cadastro> findById(Profissao profissao);
    

}

