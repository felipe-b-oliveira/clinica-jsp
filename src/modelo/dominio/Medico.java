package modelo.dominio;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tab_medico")
@SequenceGenerator(name="MEDICO_PK", sequenceName="SEQ_MEDICO_PK")
public class Medico {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MEDICO_PK")
	private Integer idMed;
	
	@Column(length=120, nullable=false)
	private String nomeMed;
	
	@Column(length=22, nullable=false)
	private String crm;
	
	@Column(length=32, nullable=false)
	private String especialidade;
	
	@ManyToMany
    @JoinTable(name="tab_consulta", joinColumns=
    {@JoinColumn(name="idMed")}, inverseJoinColumns=
      {@JoinColumn(name="idConsulta")})
    private List<Medico> medicos;
		
	public Medico() {
		super();
	}
		
	public Medico(Integer idMed, String nomeMed, String crm, String especialidade) {
		super();
		this.idMed = idMed;
		this.nomeMed = nomeMed;
		this.crm = crm;
		this.especialidade = especialidade;
	}

	public Integer getIdMed() {
		return idMed;
	}
	public void setIdMed(Integer idMed) {
		this.idMed = idMed;
	}
	public String getNomeMed() {
		return nomeMed;
	}
	public void setNomeMed(String nomeMed) {
		this.nomeMed = nomeMed;
	}
	public String getCrm() {
		return crm;
	}
	public void setCrm(String crm) {
		this.crm = crm;
	}
	public String getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	
}
