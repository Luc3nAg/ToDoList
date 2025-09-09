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
		
		System.out.println("Descrição: ");
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
	}
}