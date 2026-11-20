package br.com.starlog.main;

import java.util.List;
import br.com.starlog.dao.ProdutoDAO;
import br.com.starlog.dao.ProdutoDAOSqlite;
import br.com.starlog.model.Produto;

public class Main {

    public static void main(String[] args) {
        ProdutoDAO dao = new ProdutoDAOSqlite();

      
        Produto teclado = new Produto("Teclado Mecânico RGB", 349.90, 8);
        Produto mousepad = new Produto("Mousepad Speed XL", 129.90, 20);

        dao.salvar(teclado);
        dao.salvar(mousepad);

        System.out.println("=== [Create] IDs gerados ===");
        System.out.println("Teclado ID: " + teclado.getId() + " -> " + teclado);
        System.out.println("Mousepad ID: " + mousepad.getId() + " -> " + mousepad);

    
        System.out.println("\n=== [Read] Listagem inicial ===");
        imprimirTabela(dao.listarTodos());

  
        teclado.setEstoque(15);
        teclado.setPreco(289.90);
        boolean atualizou = dao.atualizar(teclado);
        System.out.println("\n=== [Update] Atualizou teclado? " + atualizou + " ===");
        dao.buscarPorId(teclado.getId())
           .ifPresent(p -> System.out.println("Atualizado no banco: " + p));

    
        boolean excluiuMousepad = dao.excluir(mousepad.getId());
        boolean excluiuInexistente = dao.excluir(888L);
        System.out.println("\n=== [Delete] ===");
        System.out.println("Excluiu mousepad (ID " + mousepad.getId() + ")? " + excluiuMousepad);
        System.out.println("Tentou excluir ID 888L? " + excluiuInexistente + " (sem travar)");

   
        System.out.println("\n=== [Final State] Restante no catálogo ===");
        imprimirTabela(dao.listarTodos());
    }

    private static void imprimirTabela(List<Produto> produtos) {
        System.out.printf("%-5s | %-25s | %10s | %8s%n", "ID", "NOME", "PREÇO", "ESTOQUE");
        System.out.println("------+---------------------------+------------+---------");
        for (Produto p : produtos) {
            System.out.printf("%-5d | %-25s | %10.2f | %8d%n", p.getId(), p.getNome(), p.getPreco(), p.getEstoque());
        }
    }
}