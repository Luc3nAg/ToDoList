package control;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import model.Tarefas;

public class Controle {
	ArrayList<Tarefas> Lista = new ArrayList<Tarefas>();
	Scanner sc = new Scanner(System.in);
	
	public void adicionarTarefa() {
		System.out.println("ADICIONAR TAREFA");
		
		System.out.println("Título: ");
		String Titulo = sc.nextLine();
		System.out.println("Descricao: ");
		String Descricao = sc.nextLine();
                
                int id = 0;
                id = Lista.size()+1;
		
		Tarefas tarefa = new Tarefas(Titulo, Descricao, id);
		Lista.add(tarefa);
		
		System.out.println("Tarefa adicionada: " + tarefa);
	}
	
	public void editarTarefa() {
        System.out.println("EDITAR TAREFA");

        if (Lista.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada.");
            return;
        }

        // Exibe IDs e títulos
        for (Tarefas t : Lista) {
            System.out.println(t.getId() + " - " + t.getTitulo());
        }

        int id = readInt("Digite o ID da tarefa que deseja editar: ");

        // Busca tarefa pelo ID
        Tarefas tarefa = null;
        for (Tarefas t : Lista) {
            if (t.getId() == id) {
                tarefa = t;
                break;
            }
        }

        if (tarefa == null) {
            System.out.println("Tarefa não encontrada.");
            return;
        }

        System.out.println("O que deseja editar?");
        System.out.println("1 - Título");
        System.out.println("2 - Descrição");
        System.out.println("3 - Status (Completa/Incompleta)");

        int opcao = readInt("Escolha (1-3): ");

        switch (opcao) {
            case 1 -> {
                String novoTitulo = readNonEmptyLine("Novo título: ");
                tarefa.setTitulo(novoTitulo);
                System.out.println("Título atualizado.");
            }
            case 2 -> {
                String novaDescricao = readNonEmptyLine("Nova descrição: ");
                tarefa.setDescrição(novaDescricao); // atenção: método com acento
                System.out.println("Descrição atualizada.");
            }
            case 3 -> {
                boolean status = readBoolean("A tarefa está completa? (true/false): ");
                tarefa.setCompleta(status);
                System.out.println("Status atualizado.");
            }
            default -> {
                System.out.println("Opção inválida.");
                return;
            }
        }

        System.out.println("Tarefa editada com sucesso: " + tarefa);
    }
	
	public void listarTarefa() {
		System.out.println("\nLISTAR TAREFAS");
		
		if (Lista.isEmpty()) System.out.println("Nenhuma tarefa registrada!\n");
		else {
			Iterator<Tarefas> listar = Lista.iterator();
			while (listar.hasNext()){
				Tarefas tarefa = listar.next();
				System.out.println("======================");
				System.out.println("ID: " + tarefa.getId());
				System.out.println("Título: " + tarefa.getTitulo());
				System.out.println("Descrição: " + tarefa.getDescrição());
				System.out.println("======================\n");
			}
		}
	}
	
	public void excluirTarefa() {
		System.out.println("EXCLUIR TAREFA");
		System.out.print("Informe o ID da tarefa a ser excluída: ");
        int idExcluir = sc.nextInt();
        sc.nextLine(); // Limpa o buffer

        Iterator<Tarefas> iterator = Lista.iterator();
        boolean removido = false;
        while (iterator.hasNext()) {
            Tarefas tarefa = iterator.next();
            if (tarefa.getId() == idExcluir) {
				iterator.remove();
                System.out.println("Tarefa removida com sucesso!");
                removido = true;
                break;
            }
        }
        if (!removido) {
            System.out.println("Tarefa não encontrada.");
        }
    }

}
