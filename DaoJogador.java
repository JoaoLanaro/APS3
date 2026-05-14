import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class DaoJogador{
    

    public List<Jogador> loadJogadores(String path, List<Time> timesCadastrados){
		List<Jogador> jogadores = new ArrayList<Jogador>();
		try (InputStream is = new FileInputStream(path);
				InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
				BufferedReader br = new BufferedReader(isr);
				){
			String linha;
			while((linha = br.readLine()) != null){
				String[] palavras = linha.split(",");
				String nome = palavras[0];
				String nomeTime = palavras[1];
				Time timeVinculado = null;
				int cartoesVermelhos = Integer.parseInt(palavras[2]);
				int cartoesAmarelos = Integer.parseInt(palavras[3]);
				int gols = Integer.parseInt(palavras[4]);
				int assistencias = Integer.parseInt(palavras[5]);
				for (Time t : timesCadastrados) {
        			if (t.getNome().equalsIgnoreCase(nomeTime)) 
						{
           		 	timeVinculado = t;
            	break;
        }
    }
				jogadores.add(new Jogador(nome, timeVinculado, cartoesVermelhos, cartoesAmarelos, gols, assistencias));
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		return jogadores;

    }

	public void saveJogadores(String path, List<Jogador> jogadores) {
		try(OutputStream os = new FileOutputStream(path/*, true*/);
				OutputStreamWriter osw = new OutputStreamWriter(os, StandardCharsets.UTF_8);
				PrintWriter pw = new PrintWriter(osw, true);
				){
			for(Jogador p: jogadores){
				pw.println(p.getNome()+","+p.getTime().getNome()+","+p.getVermelhos()+","+p.getAmarelos()+","+p.getGols()+","+p.getAssistencias());
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public Jogador searchJogadorPorNome(List<Jogador> jogadores, String nome) {
    for (Jogador j : jogadores) {
        if (j.getNome().equalsIgnoreCase(nome)) {
            return j;
        }
    }
    return null;
	}

	public List<Jogador> searchJogadoresPorTime(List<Jogador> jogadores, String nomeTime) {
    List<Jogador> resultado = new ArrayList<>();
    for (Jogador j : jogadores) {
        if (j.getTime().getNome().equalsIgnoreCase(nomeTime)) {
            resultado.add(j);
        }
    }
    return resultado;
	}

}
