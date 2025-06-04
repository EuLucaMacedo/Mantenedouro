package mantenedouro;
public class Animal {
    private int id;
    private String Nome;
    private String especie;
    private String data;
    private String Responsavel;
    private String Receita;

    public Animal() {
    }

    public Animal(int id, String Nome, String especie, String data, String Responsavel, String Receita) {
        this.id = id;
        this.Nome = Nome;
        this.especie = especie;
        this.data = data;
        this.Responsavel = Responsavel;
        this.Receita = Receita;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getResponsavel() {
        return Responsavel;
    }

    public void setResponsavel(String Responsavel) {
        this.Responsavel = Responsavel;
    }

    public String getReceita() {
        return Receita;
    }

    public void setReceita(String Receita) {
        this.Receita = Receita;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }
    
}
