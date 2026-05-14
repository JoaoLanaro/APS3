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

public class DaoTime {
    
    public List<Time> loadTimes(String path){
		List<Time> times = new ArrayList<Time>();
		try (InputStream is = new FileInputStream(path);
				InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
				BufferedReader br = new BufferedReader(isr);
				){
			String linha;
			while((linha = br.readLine()) != null){
				String[] palavras = linha.split(",");
				String nome = palavras[0];
				int vitorias = Integer.parseInt(palavras[1]);
				int empates = Integer.parseInt(palavras[2]);
				int derrotas = Integer.parseInt(palavras[3]);
				int golsMarcados = Integer.parseInt(palavras[4]);
				int golsSofridos = Integer.parseInt(palavras[5]);
				int pontos = Integer.parseInt(palavras[6]);
				times.add(new Time(nome, vitorias, empates, derrotas, golsMarcados, golsSofridos, pontos));
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		return times;

    }

	public void saveTimes(String path, List<Time> times) {
		try(OutputStream os = new FileOutputStream(path/*, true*/);
				OutputStreamWriter osw = new OutputStreamWriter(os, StandardCharsets.UTF_8);
				PrintWriter pw = new PrintWriter(osw, true);
				){
			for(Time t: times){
				pw.println(t.getNome()+","+t.getVitorias()+","+t.getEmpates()+","+t.getDerrotas()+","+t.getGolsMarcados()+","+t.getGolsSofridos()+","+t.getPontos());
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}


	public Time searchTime(List<Time> times, String nome) {
    for (Time t : times) {
        if (t.getNome().equalsIgnoreCase(nome)) {
            return t;
        }
    }
    return null; 
}
    
}
