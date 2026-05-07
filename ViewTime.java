import java.util.List;
import java.util.Scanner;

public class ViewTime {
    
     public void mostraTimes(List<Time> times) {
            System.out.println("Mostrando todos os times: ");
            for(Time t: times) {
                System.out.println(t);
            }
        }

    public Time leTime() {
		System.out.println("Entre com os dados do time: ");
		String nome = leNome();
		int vitorias = leVitorias();
        int empates = leEmpates();
        int derrotas = leDerrotas();
        int golsMarcados = leGolsMarcados();
        int golsSofridos = leGolsSofridos();
        int pontos = lePontos();
		return new Time(nome, vitorias, empates, derrotas, golsMarcados, golsSofridos, pontos);
	}

    private String leNome() {
		System.out.println("Entre com o nome do time: ");
		Scanner in = new Scanner(System.in);
		String nome = in.nextLine();
		return nome;
	}

    private int leVitorias() {
        System.out.println("Entre com a quantidade de vitórias do time: ");
        Scanner in = new Scanner(System.in);
        String vitoriasTexto = in.nextLine();
		int vitorias;
		try {
			vitorias = Integer.parseInt(String.valueOf(vitoriasTexto));
			if(vitorias<0) {
				throw new IllegalArgumentException();
			}else {
				return vitorias;
			}
		}catch (Exception e) {
			System.out.println("Quantidade de vitórias inválida: " + vitoriasTexto);
			System.out.println("Tente novamente");
			return leVitorias();
		}
	}
    

    private int leEmpates() {
        System.out.println("Entre com a quantidade de empates do time: ");
        Scanner in = new Scanner(System.in);
        String empatesTexto = in.nextLine();
		int empates;
		try {
			empates = Integer.parseInt(empatesTexto);
			if(empates<0) {
				throw new IllegalArgumentException();
			}else {
				return empates;
			}
		}catch (Exception e) {
			System.out.println("Quantidade de empates inválida: " + empatesTexto);
			System.out.println("Tente novamente");
			return leEmpates();
		}
    }

    private int leDerrotas() {
        System.out.println("Entre com a quantidade de derrotas do time: ");
        Scanner in = new Scanner(System.in);
        String derrotasTexto = in.nextLine();
		int derrotas;
		try {
			derrotas = Integer.parseInt(derrotasTexto);
			if(derrotas<0) {
				throw new IllegalArgumentException();
			}else {
				return derrotas;
			}
		}catch (Exception e) {
			System.out.println("Quantidade de derrotas inválida: " + derrotasTexto);
			System.out.println("Tente novamente");
			return leDerrotas();
		}
    }

    private int leGolsMarcados() {
        System.out.println("Entre com a quantidade de gols marcados pelo time: ");
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
			System.out.println("Quantidade de gols marcados inválida: " + golsTexto);
			System.out.println("Tente novamente");
			return leGolsMarcados();
		}
	}

    private int leGolsSofridos() {
        System.out.println("Entre com a quantidade de gols sofridos pelo time: ");
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
            System.out.println("Quantidade de gols sofridos inválida: " + golsTexto);
            System.out.println("Tente novamente");
            return leGolsSofridos();
        }
    
    }

    private int lePontos() {
        System.out.println("Entre com a quantidade de pontos do time: ");
        Scanner in = new Scanner(System.in);
        String pontosTexto = in.nextLine();
        int pontos;
        try {
            pontos = Integer.parseInt(pontosTexto);
            if(pontos<0) {
                throw new IllegalArgumentException();
            }else {
                return pontos;
            }
        }catch (Exception e) {
            System.out.println("Quantidade de pontos inválida: " + pontosTexto);
            System.out.println("Tente novamente");
            return lePontos();
        }
    }
}
