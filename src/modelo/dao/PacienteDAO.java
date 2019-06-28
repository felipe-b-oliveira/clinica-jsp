package modelo.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import modelo.dominio.Paciente;

/**
 * Classe que realiza os serviços de persistência dos dados da classe Paciente
 * 
 * @author Felipe Oliveira
 * @version 2.0 - 09/05/18 *
 */
public class PacienteDAO {

	private EntityManager manager;

	public PacienteDAO() {
		super();
		
		this.manager = JPAUtil.getEntityManager();
	}

	public Paciente salvar(Paciente pcte) {
		this.manager.getTransaction().begin();
		pcte = this.manager.merge(pcte);
		this.manager.getTransaction().commit();
		return pcte;
	}

	public void excluir(Paciente pcte) {
		this.manager.getTransaction().begin();
		this.manager.remove(pcte);
		this.manager.getTransaction().commit();
	}

	public Paciente obter(Integer idPaciente) {
		return this.manager.find(Paciente.class, idPaciente);
	}

	public List<Paciente> listar() {
		
		String jpql = "from Paciente p  order by p.nome";

		List<Paciente> lista = this.manager.createQuery(jpql, Paciente.class).getResultList();

		return lista;
	}

}