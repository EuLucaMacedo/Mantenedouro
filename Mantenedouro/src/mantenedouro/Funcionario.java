package mantenedouro;
public class Funcionario {
    private int id;
    private String nome;
    private String DataNascimento;
    private String Endereco;
    private String Funcao;
    private String Documento;

    public Funcionario() {
    }

    public Funcionario(int id, String nome, String DataNascimento, String Endereco, String Funcao, String Documento) {
        this.id = id;
        this.nome = nome;
        this.DataNascimento = DataNascimento;
        this.Endereco = Endereco;
        this.Funcao = Funcao;
        this.Documento = Documento;
    }

    public String getDocumento() {
        return Documento;
    }

    public void setDocumento(String Documento) {
        this.Documento = Documento;
    }

  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return DataNascimento;
    }

    public void setDataNascimento(String DataNascimento) {
        this.DataNascimento = DataNascimento;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String Endereco) {
        this.Endereco = Endereco;
    }

    public String getFuncao() {
        return Funcao;
    }

    public void setFuncao(String Funcao) {
        this.Funcao = Funcao;
    }
    
    
}
