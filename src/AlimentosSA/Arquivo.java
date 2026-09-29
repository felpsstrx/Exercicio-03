package AlimentosSA;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Arquivo {

    public static HashMap<String, Usuario> carregarUsuarios() {
        HashMap<String, Usuario> usuarios = new HashMap<>();
        try {
            File arquivo = new File("usuarios.txt");
            if (arquivo.exists()) {
                Scanner leitor = new Scanner(arquivo);
                while (leitor.hasNextLine()) {
                    String[] partes = leitor.nextLine().split(";");
                    if (partes.length == 2) {
                        usuarios.put(partes[0], new Usuario(partes[0], partes[1]));
                    }
                }
                leitor.close();
            }
        } catch (Exception e) {
            System.out.println("Erro ao ler usuarios.txt");
        }
        return usuarios;
    }

    public static void salvarUsuarios(HashMap<String, Usuario> usuarios) {
        try {
            FileWriter escritor = new FileWriter("usuarios.txt");
            for (Usuario u : usuarios.values()) {
                escritor.write(u.getEmail() + ";" + u.getSenha() + "\n");
            }
            escritor.close();
        } catch (Exception e) {
            System.out.println("Erro ao salvar usuarios.txt");
        }
    }

    public static ArrayList<Alimento> carregarAlimentos() {
        ArrayList<Alimento> alimentos = new ArrayList<>();
        try {
            File arquivo = new File("alimentos.txt");
            if (arquivo.exists()) {
                Scanner leitor = new Scanner(arquivo);
                while (leitor.hasNextLine()) {
                    String[] partes = leitor.nextLine().split(";");
                    if (partes.length == 3) {
                        float preco = Float.parseFloat(partes[1]);
                        alimentos.add(new Alimento(partes[0], preco, partes[2]));
                    }
                }
                leitor.close();
            }
        } catch (Exception e) {
            System.out.println("Erro ao ler alimentos.txt");
        }
        return alimentos;
    }

    public static void salvarAlimentos(ArrayList<Alimento> alimentos) {
        try {
            FileWriter escritor = new FileWriter("alimentos.txt");
            for (Alimento a : alimentos) {
                escritor.write(a.getTitulo() + ";" + a.getPreco() + ";" + a.getDescricao() + "\n");
            }
            escritor.close();
        } catch (Exception e) {
            System.out.println("Erro ao salvar alimentos.txt");
        }
    }
}
