package modelo.dominio;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tab_endereco")
@SequenceGenerator(name="ENDERECO_PK", sequenceName="SEQ_ENDERECO_PK")
public class Endereco {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ENDERECO_PK")
	private Integer idEndereco;
	
	@Column(length=10, nullable=false)
	private String cep;
	
	@Column(length=120, nullable=false)
	private String logradouro;
	
	@Column(length=6, nullable=false)
	private String numero;
	
	@Column(length=120, nullable=false)
	private String complemento;
	
	@Column(length=30, nullable=false)
	private String bairro;
	
	@Column(length=25, nullable=false)
	private String cidade;
	
	@Column(length=30, nullable=false)
	private String estado;
	
	@OneToMany(mappedBy="endereco", fetch=FetchType.LAZY)
	private List<Paciente> pacientes;
	
	public Endereco() {
		super();
	}
	
	public Endereco(Integer idEndereco, String cep, String logradouro, String numero, String complemento, String bairro,
			String cidade, String estado, List<Paciente> pacientes) {
		super();
		this.idEndereco = idEndereco;
		this.cep = cep;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.pacientes = pacientes;
	}

	public Integer getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(Integer idEndereco) {
		this.idEndereco = idEndereco;
	}

	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idEndereco == null) ? 0 : idEndereco.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		if (idEndereco == null) {
			if (other.idEndereco != null)
				return false;
		} else if (!idEndereco.equals(other.idEndereco))
			return false;
		return true;
	}
	
}
