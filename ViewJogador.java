import java.util.List;
import java.util.Scanner;

    public class ViewJogador {
        
        public void mostraJogadores(List<Jogador> jogadores) {
            System.out.println("Mostrando todos os jogadores: ");
            for(Jogador p: jogadores) {
                System.out.println(p);
            }
        }

    public Jogador leJogador(List<Time> timesCadastrados) {
		System.out.println("Entre com os dados do jogador: ");
		String nome = leNome();
		Time time = leTime(timesCadastrados);
		int cartoesVermelhos = leVermelhos();
        int cartoesAmarelos = leAmarelos();
        int gols = leGols();
        int assistencias = leAssistencias();
		return new Jogador(nome, time, cartoesVermelhos, cartoesAmarelos, gols, assistencias);
	}

    private String leNome() {
		System.out.println("Entre com o nome do jogador: ");
		Scanner in = new Scanner(System.in);
		String nome = in.nextLine();
		return nome;
	}

    private Time leTime(List<Time> timesCadastrados) {
    System.out.println("Entre com o nome do time do jogador: ");
    Scanner in = new Scanner(System.in);
    String nomeTime = in.nextLine();
    for (Time t : timesCadastrados) {
        if (t.getNome().equalsIgnoreCase(nomeTime)) {
            return t;
        }
    }
    System.out.println("Time não encontrado. Tente novamente.");
    return leTime(timesCadastrados);
	}

    private int leVermelhos() {
        System.out.println("Entre com a quantidade de cartões vermelhos do jogador: ");
        Scanner in = new Scanner(System.in);
        String vermelhoTexto = in.nextLine();
		int cartoesVermelhos;
		try {
			cartoesVermelhos = Integer.parseInt(vermelhoTexto);
			if(cartoesVermelhos<0) {
				throw new IllegalArgumentException();
			}else {
				return cartoesVermelhos;
			}
		}catch (Exception e) {
			System.out.println("Quantidade de cartões vermelhos inválida: " + vermelhoTexto);
			System.out.println("Tente novamente");
			return leVermelhos();
		}
	}
    

    private int leAmarelos() {
        System.out.println("Entre com a quantidade de cartões amarelos do jogador: ");
        Scanner in = new Scanner(System.in);
        String amareloTexto = in.nextLine();
		int cartoesAmarelos;
		try {
			cartoesAmarelos = Integer.parseInt(amareloTexto);
			if(cartoesAmarelos<0) {
				throw new IllegalArgumentException();
			}else {
				return cartoesAmarelos;
			}
		}catch (Exception e) {
			System.out.println("Quantidade de cartões amarelos inválida: " + amareloTexto);
			System.out.println("Tente novamente");
			return leAmarelos();
		}
    }

    private int leGols() {
        System.out.println("Entre com a quantidade de gols do jogador: ");
        Scanner in = new Scanner(System.in);
        String golsTexto = in.nextLine();
		int gols;
		try {
			gols = Integer.parseInt(golsTexto);
			if(gols<0) {
				throw new IllegalArgumentException();
			}else {
				return gols;
			}
		}catch (Exception e) {
			System.out.println("Quantidade de gols inválida: " + golsTexto);
			System.out.println("Tente novamente");
			return leGols();
		}
    }

    private int leAssistencias() {
        System.out.println("Entre com a quantidade de assistências do jogador: ");
        Scanner in = new Scanner(System.in);
        String assistenciasTexto = in.nextLine();
		int assistencias;
		try {
			assistencias = Integer.parseInt(assistenciasTexto);
			if(assistencias<0) {
				throw new IllegalArgumentException();
			}else {
				return assistencias;
			}
		}catch (Exception e) {
			System.out.println("Quantidade de assistências inválida: " + assistenciasTexto);
			System.out.println("Tente novamente");
			return leAssistencias();
		}
	}
}
