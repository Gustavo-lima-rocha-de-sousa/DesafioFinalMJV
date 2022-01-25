package mjv.spring.web.mvc.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

	@Entity
	@Table(name = "tab_cadastro")
	public class Cadastro {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
		
		@Column( length = 50)
		private String nome;
		
		@Column(name = "cpf_cnpj", length = 20 )
		private String cpfCnpj;
		
		@Enumerated(EnumType.STRING)
		@Column(name = "sx", columnDefinition = "char(1)")
		private Sexo sexo;
		
		@Embedded
		private Endereco endereco = new Endereco();
		
		
		@Column(length = 15)
		private String telefone;
		
		@Column(length = 70)
		private String email;	
			
		
		
		@ManyToOne()
		@JoinColumn(name = "prof_id")
		private Profissao profissao;
		
		public Profissao getProfissao() {
			return profissao;
		}
		public void setProfissao(Profissao profissao) {
			this.profissao = profissao;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getCpfCnpj() {
			return cpfCnpj;
		}

		public void setCpfCnpj(String cpfCnpj) {
			this.cpfCnpj = cpfCnpj;
		}

		public Sexo getSexo() {
			return sexo;
		}

		public void setSexo(Sexo sexo) {
			this.sexo = sexo;
		}
		public void setEndereco(Endereco endereco) {
			this.endereco = endereco;
		}
		public Endereco getEndereco() {
			return endereco;
		}
		public String getTelefone() {
			return telefone;
		}
		public void setTelefone(String telefone) {
			this.telefone = telefone;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		
}