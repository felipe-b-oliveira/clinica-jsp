package modelo.dominio;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tab_prontuario")
@SequenceGenerator(name="PRONTUARIO_PK", sequenceName="SEQ_PRONTUARIO_PK")
public class Prontuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PRONTUARIO_PK")
	private Integer idPront;
	
	@Column(length=120, nullable=false)
	private String nomePaciente;
	
	@Column(name="DATA_PRONT", columnDefinition="DATE")
	@Temporal(TemporalType.DATE)
	private Date dataPront;
	
	@Column(name="HORA_PRONT", columnDefinition="DATE")
	@Temporal(TemporalType.DATE)
	private Date horaPront;
	
	@Column(length=500, nullable=false)
	private String medicacao;
	
	@Column(name="ALTURA", columnDefinition="DECIMAL(15,2)")
	private float altura;
	
	@Column(name="PESO", columnDefinition="DECIMAL(15,2)")
	private float peso;
	
	@Column(length=600, nullable=false)
	private String historico;
	
	@Column(length=500, nullable=false)
	private String exames;
	
	@Column(length=20, nullable=false)
	private String cid;
	
	
	
	public Prontuario() {
		super();
	}
	
	public Prontuario(Integer idPront, String nomePaciente, Date dataPront, Date horaPront, String medicacao,
			float altura, float peso, String historico, String exames, String cid) {
		super();
		this.idPront = idPront;
		this.nomePaciente = nomePaciente;
		this.dataPront = dataPront;
		this.horaPront = horaPront;
		this.medicacao = medicacao;
		this.altura = altura;
		this.peso = peso;
		this.historico = historico;
		this.exames = exames;
		this.cid = cid;
	}

	public Integer getIdPront() {
		return idPront;
	}

	public void setIdPront(Integer idPront) {
		this.idPront = idPront;
	}

	public String getNomePaciente() {
		return nomePaciente;
	}
	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}
	public Date getDataPront() {
		return dataPront;
	}
	public void setDataPront(Date dataPront) {
		this.dataPront = dataPront;
	}
	public Date getHoraPront() {
		return horaPront;
	}
	public void setHoraPront(Date horaPront) {
		this.horaPront = horaPront;
	}
	public String getMedicacao() {
		return medicacao;
	}
	public void setMedicacao(String medicacao) {
		this.medicacao = medicacao;
	}
	public float getAltura() {
		return altura;
	}
	public void setAltura(float altura) {
		this.altura = altura;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public String getHistorico() {
		return historico;
	}
	public void setHistorico(String historico) {
		this.historico = historico;
	}
	public String getExames() {
		return exames;
	}
	public void setExames(String exames) {
		this.exames = exames;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	
}
