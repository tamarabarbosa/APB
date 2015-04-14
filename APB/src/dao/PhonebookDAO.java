package dao;

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;

	import model.Phonebook;
	import dao.FactoryConnection;

	public class PhonebookDAO {

		private static PhonebookDAO instance;

		private PhonebookDAO() {
		}

		public static PhonebookDAO getInstance() {
			if (instance == null)
				instance = new PhonebookDAO();
			return instance;
		}

		public boolean incluir(Phonebook phonebook) throws SQLException {
			if (phonebook == null)
				return false;
			
			this.updateQuery("INSERT INTO "
					+ "PhoneNumber (nome, telefone, descricao) VALUES (" + "\""
					+ PhoneNumber.getName() + "\", " + "\"" + Phonebook.getPhoneNumber()
					+ "\", " + "\"" + PhoneNumber.getDescricao() + "\"); ");
			return true;
		}

		public boolean alterar(String nome, Phonebook Phonebook_alterado, Phonebook Phonebook) throws SQLException {	
			if(Phonebook == null || Phonebook_alterado == null)
				return false;
			
			this.updateQuery("UPDATE Phonebook SET " +
					"nome = \"" + Phonebook_alterado.getName() + "\", " +
					"telefone = \"" + Phonebook_alterado.getPhoneNumber() + "\", "+
					"descricao = \"" + Phonebook_alterado.getDescription() + "\""+
					" WHERE " +
					" Phonebook.nome = \"" + nome + "\";");
				
			return true;
		}

		public boolean excluir(Phonebook contato) throws SQLException {
			if(contato ==  null)
				return false;
			
			this.updateQuery("DELETE FROM Phonebook WHERE " + "Phonebook.telefone = \""
					+ contato.getPhoneNumber() + "\";");
			return true;
		}

		public void updateQuery(String message) throws SQLException {
			Connection connection = FactoryConnection.getInstance().getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(message);
			preparedStatement.executeUpdate();
			preparedStatement.close();
			connection.close();
		}
		
		public ResultSet mostrarContatosCadastrados(Phonebook contato) throws SQLException {
			Connection connection = FactoryConnection.getInstance().getConnection();
			ResultSet rs = connection.createStatement().executeQuery(
					"Select * from Phonebook;");
			
			return rs;
		}
		
		public ResultSet pesquisarPorNome(Phonebook contato) throws SQLException {
			Connection connection = FactoryConnection.getInstance().getConnection();
			java.sql.PreparedStatement pst = connection.prepareStatement("SELECT * FROM Phonebook WHERE "
					+ "nome = '" + contato.getName()+ "';");
			ResultSet rs = pst.executeQuery();

			return rs;
		}
		
		public ResultSet pesquisarPorTelefone(Phonebook contato) throws SQLException {
			Connection connection = FactoryConnection.getInstance().getConnection();
			java.sql.PreparedStatement pst = connection.prepareStatement("SELECT * FROM Phonebook WHERE "
					+ "telefone = '" + contato.getPhoneNumber()+ "';");
			ResultSet rs = pst.executeQuery();

			return rs;
		}

	}


