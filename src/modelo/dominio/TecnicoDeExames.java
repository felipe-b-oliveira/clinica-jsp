package modelo.dominio;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tab_tecnico")
@SequenceGenerator(name="TECNICO_PK", sequenceName="SEQ_TECNICO_PK")
public class TecnicoDeExames {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TECNICO_PK")
	private Integer idTecnico;
	
	@Column(length=120, nullable=false)
	private String nomeTecnico;
	
	@Column(length=20, nullable=false)
	private String codigoTecnico;
	
	@ManyToMany(mappedBy="tecnicos")
    private List<Paciente> pacientes;
		
	public TecnicoDeExames() {
		super();
	}	
	
	public TecnicoDeExames(Integer idTecnico, String nomeTecnico, String codigoTecnico) {
		super();
		this.idTecnico = idTecnico;
		this.nomeTecnico = nomeTecnico;
		this.codigoTecnico = codigoTecnico;
	}

	public Integer getIdTecnico() {
		return idTecnico;
	}

	public void setIdTecnico(Integer idTecnico) {
		this.idTecnico = idTecnico;
	}

	public String getNomeTecnico() {
		return nomeTecnico;
	}
	public void setNomeTecnico(String nomeTecnico) {
		this.nomeTecnico = nomeTecnico;
	}
	public String getCodigoTecnico() {
		return codigoTecnico;
	}
	public void setCodigoTecnico(String codigoTecnico) {
		this.codigoTecnico = codigoTecnico;
	}
		
}
