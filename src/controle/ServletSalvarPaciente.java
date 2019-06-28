package controle;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.EnderecoDAO;
import modelo.dao.PacienteDAO;
import modelo.dominio.Endereco;
import modelo.dominio.Paciente;

/**
 * Servlet implementation class ServletSalvarPaciente
 */
@WebServlet("/salvarPaciente")
public class ServletSalvarPaciente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletSalvarPaciente() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.sendError(403, "Acesso negado via método GET.  Por favor use o formulário para salvar os dados.");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<String> erros = new ArrayList<String>();
		
		// ler os campos do formulário
		String enderecoStr = request.getParameter("endereco");
		String idPacienteStr = request.getParameter("idPaciente");
		String nome = request.getParameter("nome");
		String rg = request.getParameter("rg");
		String sexo = request.getParameter("myradio");
		String dataNascStr = request.getParameter("dataNasc");
		 // String dataNascStr = request.getParameter("dataNasc");
		String telefone = request.getParameter("telefone");
		
		String logradouroStr = request.getParameter("logradouro");
		String cepStr = request.getParameter("cep");
		String numeroStr = request.getParameter("numero");
		String complementoStr = request.getParameter("complemento");
		String bairroStr = request.getParameter("bairro");
		String cidadeStr = request.getParameter("cidade");
		String estadoStr = request.getParameter("estado");


		// converter os valores numéricos
		
		Integer idPaciente;
		try {
			idPaciente = Integer.parseInt(idPacienteStr);
		} catch (NumberFormatException e) {
			idPaciente = null;
		}
		
		Integer idEndereco;
		Endereco end;
		try {
			idEndereco = Integer.parseInt(enderecoStr);
			
			// ler o endereco escolhido do banco
			EnderecoDAO daoEnd = new EnderecoDAO();
			end = daoEnd.obter(idEndereco);
			
		} catch (NumberFormatException e) {
			idEndereco = null;
			end = null;
		}
		
		Date dataNasc = null; // Ver se está certo
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataNasc = sdf.parse(dataNascStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}	
		
		/* II Date dataNasc = null;
		try {
			dataNasc = Date.form.parse(dataNascStr);
		} catch () {
			dataNasc = null;
		}  II */
		
		/*if (idPaciente == null)
			erros.add("O campo ID é inválido");*/
		
		if (nome == null || nome.length() == 0)
			erros.add("O campo Nome é obrigatório");
		
		if (rg == null || rg.length() == 0)
			erros.add("O campo RG é obrigatório");
		
		/*if (sexo == null || sexo.length() == 0)
			erros.add("O campo Sexo é obrigatório");*/ //OBS
		
		if (dataNascStr == null)
			erros.add("O campo Data de Nascimento é inválido");
		
		if (telefone == null || telefone.length() == 0)
			erros.add("O campo Telefone é obrigatório");
		
		// criar instância do DAO para persistência
		PacienteDAO dao = new PacienteDAO();
		// transferir os dados para o objeto do Modelo
		Paciente pcte;
		
		if (idPaciente == null)
			pcte = new Paciente();
		else
			pcte = dao.obter(idPaciente);
		
		// alterar os dados do objeto
		pcte.setEndereco(end);
		pcte.setIdPaciente(idPaciente);
		pcte.setNome(nome);
		pcte.setRg(rg);
		pcte.setSexo(sexo);
		pcte.setDataNasc(dataNasc);
		pcte.setTelefone(telefone);
		
		// verifica se ocorreu algum erro
		if (erros.size() == 0)
		{
			// salvar o objeto no banco de dados
			pcte = dao.salvar(pcte);
			
			// fazer redirect para listar os pacientes afim de se evitar repetições
			response.sendRedirect("listarPaciente");
		}
		else 
		{
			// guarda a lista de erros no request para ser usada na página
			request.setAttribute("pcte", pcte);
			request.setAttribute("erros", erros);
			
			// ler a lista de enderecos
			EnderecoDAO daoEnd = new EnderecoDAO();
			List<Endereco> listaEnd = daoEnd.listar();
			// guardar a lista de enderecos no request
			request.setAttribute("listaEnd", listaEnd);
			
			// encaminhar de volta para a página de edição exibindo as mensagens de erro
			RequestDispatcher desp = request.getRequestDispatcher("pacienteEditar.jsp");			
			// encaminhar o processamento para a página
			desp.forward(request, response);
		}

	}

}
