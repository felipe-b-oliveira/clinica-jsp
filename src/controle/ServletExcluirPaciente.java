package controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.PacienteDAO;
import modelo.dominio.Paciente;

/**
 * Servlet implementation class ServletExcluirPaciente
 */
@WebServlet("/excluir")
public class ServletExcluirPaciente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletExcluirPaciente() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idPacienteStr = request.getParameter("idPaciente");
		Integer idPaciente = Integer.parseInt(idPacienteStr);
		
		// criar instância do DAO para persistência
		PacienteDAO dao = new PacienteDAO();
		
		// carregar o paciente escolhido do banco
		Paciente pcte = dao.obter(idPaciente);
		
		// excluir o paciente do banco de dados
		dao.excluir(pcte);
		
		// fazer redirect para listar os pacientes afim de se evitar repetições
		response.sendRedirect("listarPaciente");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
