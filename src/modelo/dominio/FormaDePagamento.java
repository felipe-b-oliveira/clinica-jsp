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
@Table(name="tab_forma_pgto")
@SequenceGenerator(name="FORMAPGTO_PK", sequenceName="SEQ_FORMAPGTO_PK")
public class FormaDePagamento {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="FORMAPGTO_PK")
	private Integer idFormaPgto;
	
	@Column(length=80, nullable=false)
	private String tipo;
	
	@Column(name="VALOR", columnDefinition="DECIMAL(15,2)")
	private float valor;
	
	@Column(name="CREDPARCELAS")
	private Integer credParcelas;
	
	@OneToMany(mappedBy="formas", fetch=FetchType.LAZY)
	private List<Consulta> consultas;
	
	@OneToMany(mappedBy="formase", fetch=FetchType.LAZY)
	private List<Exames> exames;
		
	public FormaDePagamento(Integer idFormaPgto, String tipo, float valor, Integer credParcelas) {
		super();
		this.idFormaPgto = idFormaPgto;
		this.tipo = tipo;
		this.valor = valor;
		this.credParcelas = credParcelas;
	}

	public FormaDePagamento() {
		super();
	}
	
	public Integer getIdFormaPgto() {
		return idFormaPgto;
	}
	public void setIdFormaPgto(Integer idFormaPgto) {
		this.idFormaPgto = idFormaPgto;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public Integer getCredParcelas() {
		return credParcelas;
	}
	public void setCredParcelas(Integer credParcelas) {
		this.credParcelas = credParcelas;
	}
	
}
