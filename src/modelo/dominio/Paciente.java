package modelo.dominio;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tab_pacientes")
@SequenceGenerator(name="PACIENTE_PK", sequenceName="SEQ_PACIENTE_PK")
public class Paciente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PACIENTE_PK")
	private Integer idPaciente;
	
	@Column(length=120, nullable=false)
	private String nome;
	
	@Column(length=30, nullable=false)
	private String rg;
	
	@Column(length=12, nullable=false)
	private String sexo;
	
	@Column(name="DATA_NASC", columnDefinition="DATE")
	@Temporal(TemporalType.DATE)
	private Date dataNasc;
	
	@Column(length=15, nullable=false)
	private String telefone;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Prontuario prontuario;	
	
	@ManyToOne
	@JoinColumn(name="id_endereco_fk")
	private Endereco endereco;
	
	@ManyToMany
    @JoinTable(name="paciente_tecnicos", joinColumns=
    {@JoinColumn(name="idPaciente")}, inverseJoinColumns=
      {@JoinColumn(name="idTecnico")})
    private List<TecnicoDeExames> tecnicos;
	
	@ManyToMany
    @JoinTable(name="tab_consulta", joinColumns=
    {@JoinColumn(name="idPaciente")}, inverseJoinColumns=
      {@JoinColumn(name="idConsulta")})
    private List<Medico> medicos;
	
	public Paciente() {
		super();
	}
	
	public Paciente(Integer idPaciente, String nome, String rg, String sexo, Date dataNasc, String telefone) {
		super();
		this.idPaciente = idPaciente;
		this.nome = nome;
		this.rg = rg;
		this.sexo = sexo;
		this.dataNasc = dataNasc;
		this.telefone = telefone;
	}

	public Integer getIdPaciente() {
		return idPaciente;
	}
	public void setIdPaciente(Integer idPaciente) {
		this.idPaciente = idPaciente;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Date getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPaciente == null) ? 0 : idPaciente.hashCode());
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
		Paciente other = (Paciente) obj;
		if (idPaciente == null) {
			if (other.idPaciente != null)
				return false;
		} else if (!idPaciente.equals(other.idPaciente))
			return false;
		return true;
	}
	
}
