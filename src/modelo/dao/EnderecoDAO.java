package modelo.dao;

import java.util.List;
import javax.persistence.EntityManager;
import modelo.dominio.Endereco;

/**
 * Classe responsavel por persistir a classe Endereco no banco de dados.
 * 
 * @author felipe
 * @version 2.0 - 30/05/18
 */
public class EnderecoDAO {
	
	private EntityManager manager;

	public EnderecoDAO() {
		super();
		
		this.manager = JPAUtil.getEntityManager();
	}
	
	public Endereco salvar(Endereco end) {
		this.manager.getTransaction().begin();
		Endereco novo = this.manager.merge(end);
		this.manager.getTransaction().commit();
		return novo;
	}

	public void excluir(Endereco end) {
		this.manager.getTransaction().begin();
		this.manager.remove(end);
		this.manager.getTransaction().commit();
	}

	public Endereco obter(Integer idEndereco) {
		return this.manager.find(Endereco.class, idEndereco);
	}

	public List<Endereco> listar() {
		
		String jpql = "from Endereco e  order by e.logradouro";

		List<Endereco> lista = this.manager.createQuery(jpql, Endereco.class).getResultList();

		return lista;
	}

}
