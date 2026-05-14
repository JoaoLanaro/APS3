import java.nio.charset.StandardCharsets;
import java.util.List;

import java.util.Scanner;

public class Controller{
    
        private enum Opcoes {MOSTRAR_JOGADORES, LE_JOGADORES, MOSTRAR_TIMES, LE_TIMES, BUSCAR_JOGADOR_POR_NOME, BUSCAR_JOGADORES_POR_TIME, BUSCAR_TIME, SAIR}
        static final String PATH_JOGADORES = "files/jogadores.csv";
    	static final String PATH_TIMES = "files/times.csv";
        ViewJogador viewJogador = new ViewJogador();
        DaoJogador daoJogador = new DaoJogador();
		ViewTime viewTime = new ViewTime();
		DaoTime daoTime = new DaoTime();

        public void init() {
		
		Opcoes opcao = null;
		
		List<Time> times;
		List<Jogador> jogadores;
		do {
			opcao = pegaOpcao();
			times = daoTime.loadTimes(PATH_TIMES);
			switch (opcao) {
			case MOSTRAR_JOGADORES: 
				jogadores = daoJogador.loadJogadores(PATH_JOGADORES, times);
				viewJogador.mostraJogadores(jogadores);
				break;
			case LE_JOGADORES: 
				Jogador jogador = viewJogador.leJogador(times);
				jogadores = daoJogador.loadJogadores(PATH_JOGADORES, times);
				jogadores.add(jogador);
				daoJogador.saveJogadores(PATH_JOGADORES, jogadores);
				break;
			case MOSTRAR_TIMES:
				viewTime.mostraTimes(times);
				break;
			case LE_TIMES:
				Time time = viewTime.leTime();
				times.add(time);
				daoTime.saveTimes(PATH_TIMES, times);
				break;
			case BUSCAR_JOGADOR_POR_NOME:
				System.out.println("Digite o nome do jogador: ");
				String nomeJogador = new Scanner(System.in, StandardCharsets.UTF_8).nextLine();
				jogadores = daoJogador.loadJogadores(PATH_JOGADORES, times);
				Jogador encontrado = daoJogador.searchJogadorPorNome(jogadores, nomeJogador);
				if (encontrado != null)
					System.out.println(encontrado);
				else
					System.out.println("Jogador não encontrado.");
				break;
			case BUSCAR_JOGADORES_POR_TIME:
				System.out.println("Digite o nome do time: ");
				String nomeTimeBusca = new Scanner(System.in, StandardCharsets.UTF_8).nextLine();
				jogadores = daoJogador.loadJogadores(PATH_JOGADORES, times);
				List<Jogador> doTime = daoJogador.searchJogadoresPorTime(jogadores, nomeTimeBusca);
				if (!doTime.isEmpty())
					viewJogador.mostraJogadores(doTime);
				else
					System.out.println("Nenhum jogador encontrado para esse time.");
				break;
			case BUSCAR_TIME:
				System.out.println("Digite o nome do time: ");
				String nomeTimeProcurado = new Scanner(System.in, StandardCharsets.UTF_8).nextLine();
				Time timeEncontrado = daoTime.searchTime(times, nomeTimeProcurado);
				if (timeEncontrado != null)
					System.out.println(timeEncontrado);
				else
					System.out.println("Time não encontrado.");
				break;
			case SAIR:
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + opcao);
			}
		} while(opcao != Opcoes.SAIR); 
	}


        Opcoes pegaOpcao() {
		System.out.println("Entre com a opção desejada");
		System.out.println("1 - Para mostrar jogadores");
		System.out.println("2 - para entrar com um novo Jogador");
		System.out.println("3 - Para mostrar times");
		System.out.println("4 - para entrar com um novo Time");
		System.out.println("5 - Buscar jogador pelo nome");
		System.out.println("6 - Buscar jogadores de um time");
		System.out.println("7 - Buscar time pelo nome");
		System.out.println("0 - para sair");
		
		Scanner in = new Scanner(System.in, StandardCharsets.UTF_8);
		String opcaoPalavra = in.nextLine();
		int opcaoInt = -1;
		try {
			opcaoInt = Integer.parseInt(opcaoPalavra);
			switch (opcaoInt) {
			case 1:
				return Opcoes.MOSTRAR_JOGADORES;
			case 2:
				return Opcoes.LE_JOGADORES;
			case 3:
				return Opcoes.MOSTRAR_TIMES;
			case 4:
				return Opcoes.LE_TIMES;
			case 5: 
				return Opcoes.BUSCAR_JOGADOR_POR_NOME;
			case 6: 
				return Opcoes.BUSCAR_JOGADORES_POR_TIME;
			case 7: 
				return Opcoes.BUSCAR_TIME;
			case 0:
				return Opcoes.SAIR;
			default:
				throw new IllegalArgumentException();
			}
		}catch (NumberFormatException e) {
			System.out.println("Opcao invalida: " + opcaoPalavra);
			System.out.println("Opcao deve ser um numero inteiro");
			System.out.println("Tente Novamente");
			return pegaOpcao();
		}catch (IllegalArgumentException e) {
			System.out.println("Opcao invalida: " + opcaoInt);
			System.out.println("Tente Novamente");
			return pegaOpcao();
		}
	}
}
