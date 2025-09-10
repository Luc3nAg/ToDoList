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
	}
	
	public void listarTarefa() {
		System.out.println("LISTAR TAREFA");
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

	
