package modelo.dominio;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tab_exames")
@SequenceGenerator(name="EXAMES_PK", sequenceName="SEQ_EXAMES_PK")
public class Exames {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXAMES_PK")
	private Integer idExame;
	
	@Column(length=180, nullable=false)
	private String nomeExame;
	
	@Column(name="DATA_EXAME", columnDefinition="DATE")
	@Temporal(TemporalType.DATE)
	private Date dataExame;
	
	@Column(name="HORA_EXAME", columnDefinition="DATE")
	@Temporal(TemporalType.DATE)
	private Date horaExame;	
	
	@ManyToOne
	@JoinColumn(name="id_formaPgto_fk")
	private FormaDePagamento formase;
	
	public Exames(Integer idExame, String nomeExame, Date dataExame, Date horaExame) {
		super();
		this.idExame = idExame;
		this.nomeExame = nomeExame;
		this.dataExame = dataExame;
		this.horaExame = horaExame;
	}

	public Exames() {
		super();
	}
	
	public Integer getIdExame() {
		return idExame;
	}
	public void setIdExame(Integer idExame) {
		this.idExame = idExame;
	}
	public String getNomeExame() {
		return nomeExame;
	}
	public void setNomeExame(String nomeExame) {
		this.nomeExame = nomeExame;
	}
	public Date getDataExame() {
		return dataExame;
	}
	public void setDataExame(Date dataExame) {
		this.dataExame = dataExame;
	}
	public Date getHoraExame() {
		return horaExame;
	}
	public void setHoraExame(Date horaExame) {
		this.horaExame = horaExame;
	}
}
