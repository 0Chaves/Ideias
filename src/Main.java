import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws SQLException {
		//Estabelecer conexão com o banco de dados
		String login = "postgres";
		String senha = "postgres";
		String urlcon = "jdbc:postgresql://localhost:5432/banco";
		Connection con = DriverManager.getConnection(urlcon, login, senha);
		//Criar o objeto Ideia
		String titulo = "estudar";
		String descricao = "Estudar todos os dias, pelo menos 1h por dia, algum conteúdo sobre DevOps ou Metodologias ágeis. Ou estudar alguma tendência nova.";
		int urgencia = 3;
		Ideia nova_ideia = new Ideia(titulo, descricao, urgencia);
		//Tentar inserir o objeto no banco de dados
		try {
			nova_ideia.inserir(con);
			System.out.println("Deu bom!");
		}catch(SQLException e) {
			System.out.println("Deu ruim!");
		}
		
		//TODO :Fazer SELECT no banco e printar para testar
		
		//Inserir diversas ideias
		Scanner sc = new Scanner(System.in);
		Ideia segunda_ideia;
		for(int i=0; i<5; i++) {
			System.out.printf("Insira o titulo da %d ideia: ", i+1);
			titulo = sc.next();
			System.out.printf("Insira a descricao da %d ideia: ", i+1);
			/*
			 * ERRO NA EXECUÇÃO DE BAIXO
			 */
			descricao = sc.next();
			System.out.printf("Insira o grau de urgencia (1 a 5) da %d ideia: ", i+1);
			urgencia = sc.nextInt();
			segunda_ideia = new Ideia(titulo,descricao,urgencia);
			
			try {
				segunda_ideia.inserir(con);
				System.out.println("Deu bom!");
			}catch(SQLException e) {
				System.out.println("Deu ruim!");
			}
		}
		
		//TODO :Fazer SELECT no banco e printar para testar
		
		
		//Deletar o primeiro objeto adicionado ao banco
		try {
			nova_ideia.deletar(con);
		}catch(SQLException e) {
			System.out.println("Erro");
		}
		//TODO :Fazer SELECT no banco e printar para testar
		
		
		List<Ideia> lista = Ideia.listar(con);
		
		System.out.println("Abaixo, Lista das Ideias que estão no banco: ");
		lista.stream().forEach(System.out::println);;
		
		sc.close();
	}

}
