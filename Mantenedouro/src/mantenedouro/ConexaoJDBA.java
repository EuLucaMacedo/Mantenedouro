package mantenedouro;

//import com.sun.jdi.connect.spi.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;


public class ConexaoJDBA {
    private Connection conexao;

    public Connection getConexao() {
        return conexao;
    }

    public void setConexao(Connection conexao) {
        this.conexao = conexao;
    }

    public void conectar() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost/mantenedouro", "root", "C@ir1887");
            System.out.println("SUCESSO DE CONEXÃO!");
        } catch (ClassNotFoundException cn) {
            System.out.println("Falha ao conectar com o Banco" + cn);
        } catch (SQLException sql) {
            System.out.println("Erro de SQL: " + sql);
        }
    }
    
    public void desconectar(){
        try{
            if(conexao != null && !conexao.isClosed()){
                conexao.close();
                System.out.println("DESCONECTAR");
            }
        }catch(SQLException se){
            System.out.println("Problema de Conectar do Banco: " + se);
                
        }
    }
}
