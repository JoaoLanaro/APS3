public class Jogador {
    private String nome;
    private Time time;
    private int cartoesVermelhos;
    private int cartoesAmarelos;
    private int gols;
    private int assistencias;

    // Construtor
    public Jogador(String nome, Time time, int cartoesVermelhos, int cartoesAmarelos, int gols, int assistencias) {
        this.nome = nome;
        this.time = time;
        this.cartoesVermelhos = cartoesVermelhos;
        this.cartoesAmarelos = cartoesAmarelos;
        this.gols = gols;
        this.assistencias = assistencias;
    }

    public String getNome() {return nome;}
    public Time getTime() { return time; }
    public int getAmarelos() { return cartoesAmarelos; }
    public int getVermelhos() { return cartoesVermelhos; }
    public int getGols() { return gols; }
    public int getAssistencias() { return assistencias; }

    public void setNome(String nome) {this.nome = nome;}
    public void setTime(Time time) {this.time = time;}
    public void setAmarelos(int cartoesAmarelos) {this.cartoesAmarelos = cartoesAmarelos;}
    public void setVermelhos(int cartoesVermelhos) {this.cartoesVermelhos = cartoesVermelhos;}
    public void setGols(int gols) {this.gols = gols;}
    public void setAssistencias(int assistencias) {this.assistencias = assistencias;}

    @Override
    public String toString() {
        return  "\nNome=" + nome  + "\n" +
                "Time=" + time.getNome() + "\n" +
                "Cartões Vermelhos=" + cartoesVermelhos + "\n" +
                "Cartões Amarelos=" + cartoesAmarelos + "\n" +
                "Gols=" + gols + "\n" +
                "Assistências=" + assistencias + "\n";
    }
}
