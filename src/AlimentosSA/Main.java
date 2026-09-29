package AlimentosSA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

// Alunos: João Felipe de Freitas Nascimento
// João Vinicius
// Mickael Henrique

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static HashMap<String, Usuario> usuarios = Arquivo.carregarUsuarios();
    public static ArrayList<Alimento> alimentos = Arquivo.carregarAlimentos();

    public static void main(String[] args) {
        int opcao = 0;

        while (opcao != 3) {
            System.out.println("\n--- MENU ---");
            System.out.println("1 - Adicionar usuário");
            System.out.println("2 - Entrar no sistema");
            System.out.println("3 - Sair");
            opcao = lerOpcao();

            if (opcao == 1) {
                adicionarUsuario();
            } else if (opcao == 2) {
                entrar();
            } else if (opcao == 3) {
                System.out.println("Saindo...");
            } else {
                System.out.println("Opção inválida");
            }
        }
    }

    public static int lerOpcao() {
        System.out.print("Opção: ");
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            return 0;
        }
    }

    public static void adicionarUsuario() {
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Senha: ");
        String senha = sc.nextLine();

        if (usuarios.containsKey(email)) {
            System.out.println("Email já cadastrado");
        } else {
            usuarios.put(email, new Usuario(email, senha));
            Arquivo.salvarUsuarios(usuarios);
            System.out.println("Usuário cadastrado!");
        }
    }

    public static void entrar() {
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Senha: ");
        String senha = sc.nextLine();

        Usuario usuario = usuarios.get(email);
        if (usuario != null && usuario.getSenha().equals(senha)) {
            System.out.println("Bem-vindo, " + email);
            menuAlimentos();
        } else {
            System.out.println("Email ou senha incorretos");
        }
    }

    public static void menuAlimentos() {
        int opcao = 0;

        while (opcao != 3) {
            System.out.println("\n--- ALIMENTOS ---");
            System.out.println("1 - Registrar alimento");
            System.out.println("2 - Listar alimentos");
            System.out.println("3 - Voltar");
            opcao = lerOpcao();

            if (opcao == 1) {
                registrarAlimento();
            } else if (opcao == 2) {
                listarAlimentos();
            } else if (opcao != 3) {
                System.out.println("Opção inválida");
            }
        }
    }

    public static void registrarAlimento() {
        System.out.print("Título: ");
        String titulo = sc.nextLine();

        float preco;
        while (true) {
            System.out.print("Preço: ");
            try {
                preco = Float.parseFloat(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Digite um número válido, ex: 10.50");
            }
        }

        System.out.print("Descrição: ");
        String descricao = sc.nextLine();

        alimentos.add(new Alimento(titulo, preco, descricao));
        Arquivo.salvarAlimentos(alimentos);
        System.out.println("Alimento registrado!");
    }

    public static void listarAlimentos() {
        if (alimentos.isEmpty()) {
            System.out.println("Nenhum alimento cadastrado");
        } else {
            for (int i = 0; i < alimentos.size(); i++) {
                Alimento a = alimentos.get(i);
                System.out.println((i + 1) + " - " + a.getTitulo() + " | R$ " + a.getPreco() + " | " + a.getDescricao());
            }
        }
    }
}
