public class Time {
    private String nome;
    private int vitorias;
    private int empates;
    private int derrotas;
    private int golsMarcados;
    private int golsSofridos;
    private int pontos;


    public Time(String nome, int vitorias, int empates, int derrotas, 
        int golsMarcados, int golsSofridos, int pontos) {
        this.nome = nome;
        this.vitorias = vitorias;
        this.empates = empates;
        this.derrotas = derrotas;
        this.golsMarcados = golsMarcados;
        this.golsSofridos = golsSofridos;
        this.pontos = pontos;
    }

    
    public String getNome() { return nome; }
    public int getVitorias() { return vitorias; }
    public int getEmpates() { return empates; }
    public int getDerrotas() { return derrotas; }
    public int getGolsMarcados() { return golsMarcados; }
    public int getGolsSofridos() { return golsSofridos; }
    public int getPontos() { return pontos; }

    public void setNome(String nome) { this.nome = nome; }
    public void setVitorias(int vitorias) { this.vitorias = vitorias; }
    public void setEmpates(int empates) { this.empates = empates; }
    public void setDerrotas(int derotas) { this.derrotas = derotas; }
    public void setGolsMarcados(int golsMarcados) { this.golsMarcados = golsMarcados; }
    public void setGolsSofridos(int golsSofridos) { this.golsSofridos = golsSofridos; }
    public void setPontos(int pontos) { this.pontos = pontos; }

    @Override
    public String toString() {
        return  "\nNome=" + nome  + "\n" +
                "vitorias=" + vitorias + "\n" +
                "empates=" + empates + "\n" +
                "derrotas=" + derrotas + "\n" +
                "golsMarcados=" + golsMarcados + "\n" +
                "golsSofridos=" + golsSofridos + "\n" +
                "pontos=" + pontos + "\n";
    }
}