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
@Table(name="tab_consulta")
@SequenceGenerator(name="CONSULTA_PK", sequenceName="SEQ_CONSULTA_PK")
public class Consulta {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CONSULTA_PK")
	private Integer idConsulta;
	
	@Column(name="DATA_CONSULTA", columnDefinition="DATE")
	@Temporal(TemporalType.DATE)
	private Date dataConsulta;
	
	@Column(name="HORA_CONSULTA", columnDefinition="DATE")
	@Temporal(TemporalType.DATE)
	private Date horaConsulta;
	
	@ManyToOne
	@JoinColumn(name="id_formaPgto_fk")
	private FormaDePagamento formas;
	
	public Consulta(Integer idConsulta, Date dataConsulta, Date horaConsulta) {
		super();
		this.idConsulta = idConsulta;
		this.dataConsulta = dataConsulta;
		this.horaConsulta = horaConsulta;
	}

	public Consulta() {
		super();
	}
	
	public Integer getIdConsulta() {
		return idConsulta;
	}
	public void setIdConsulta(Integer idConsulta) {
		this.idConsulta = idConsulta;
	}
	public Date getDataConsulta() {
		return dataConsulta;
	}
	public void setDataConsulta(Date dataConsulta) {
		this.dataConsulta = dataConsulta;
	}
	public Date getHoraConsulta() {
		return horaConsulta;
	}
	public void setHoraConsulta(Date horaConsulta) {
		this.horaConsulta = horaConsulta;
	}
	
}
