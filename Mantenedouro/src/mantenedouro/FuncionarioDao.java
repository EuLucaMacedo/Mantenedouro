package mantenedouro;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDao {
    public static boolean cadastrar(Funcionario f) throws SQLException{
        String sql = "INSERT INTO Funcionario (nome, datanascimento, endereco, funcao, documento) VALUES (?, ?, ?, ?, ?)";
        
        try{
            ConexaoJDBA conectar = new ConexaoJDBA();
            conectar.conectar();
            
            PreparedStatement ps = conectar.getConexao().prepareStatement(sql);
            ps.setString(1, f.getNome());
            ps.setString(2, f.getDataNascimento());
            ps.setString(3, f.getEndereco());
            ps.setString(4, f.getFuncao());
            ps.setString(5, f.getDocumento());
            
            int AtualizacaoTabela = ps.executeUpdate();
            System.out.println("Funcionario Cadastrado com Sucesso! ");
            conectar.desconectar();
            return AtualizacaoTabela > 0;
            
        }catch (SQLException se){
            System.out.println("Erro ao Cadastrar Funcionario: " + se.getMessage());
            return false;
        }
    }
    
    public static List<Funcionario> listarTodos(){
        List<Funcionario> fun = new ArrayList();
        
        try{
            ConexaoJDBA conexao = new ConexaoJDBA();
            conexao.conectar();
            
            String sql = "SELECT f.id, f.nome, f.datanascimento, f.endereco, f.funcao, f.documento "
                    + "FROM Funcionario f";
            
            PreparedStatement ps = conexao.getConexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            
            while (rs.next()){
                Funcionario f = new Funcionario();
                f.setId(rs.getInt("id"));
                f.setNome(rs.getString("nome"));
                f.setDataNascimento(rs.getString("datanascimento"));
                f.setEndereco(rs.getString("endereco"));
                f.setFuncao(rs.getString("funcao"));
                f.setDocumento(rs.getString("documento"));
                
                fun.add(f);
                
            }
            conexao.desconectar();
            
        }catch(SQLException se){
            System.err.println("Erro ao Listar Funcionarios: " + se.getMessage());
        }
        return fun;
    }
    
    public static boolean excluir (int id){
        try{
            ConexaoJDBA jdba = new ConexaoJDBA();
            jdba.conectar();
            
            String sql = "DELETE FROM Funcionario WHERE id=?;";
            PreparedStatement consulta =jdba.getConexao().prepareStatement(sql);
            
            consulta.setInt(1, id);
            
            consulta.execute();
            
            jdba.desconectar();
            return true;
            
        }catch(SQLException s){
            System.out.println("Erro ao deletar registro no banco de dados!" + s);
            return false;
        }
    }
}
