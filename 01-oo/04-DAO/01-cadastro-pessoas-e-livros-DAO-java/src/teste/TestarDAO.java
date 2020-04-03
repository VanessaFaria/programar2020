package teste;

import dao.dinamico.DAO;
import modelo.Livro;
import modelo.Pessoa;

public class TestarDAO {

    public static void main(String[] args) {

        // instanciar o DAO
        DAO dao = new DAO();
        
        // popular o cadastro de livros
        Livro l1 = new Livro("As regras do trabalho",
                "Richard Templar", "2010", "Sextante");
        Livro l2 = new Livro("Pense e enriqueça",
                "Napoleon Hill", "2014", "BestSeller");
        Livro l3 = new Livro("A semente da vitória",
                "Nuno Cobra", "2001", "Senac SP");
        dao.adicionarLivro(l1);
        dao.adicionarLivro(l2);
        dao.adicionarLivro(l3);
        
        // popular o cadastro de pessoas (três pessoas)
        Pessoa p = new Pessoa("Joao", "Rua 3", "3521-1212");
        p.registrarPosseLivro(l1);
        dao.adicionarPessoa(p);
        
        p = new Pessoa("Maria", "Beco Vinte", "4141-1313");
        p.registrarPosseLivro(l2);
        dao.adicionarPessoa(p);
                
        p = new Pessoa("Tiago", "Av. Redentor", "não tem telefone");
        p.registrarPosseLivro(l1); // essa pessoa também tem um exemplar de l1
        p.registrarPosseLivro(l3);
        dao.adicionarPessoa(p);
        
        // listar pessoas
        System.out.print("* Pessoas no cadastro: ");
        System.out.println(dao.retornarQuantidadeDePessoas());
        for (Pessoa pe : dao.retornarPessoas()){
            System.out.println(pe);
        }
        
        // alterar os dados de uma pessoa
        System.out.println("* alterando endereço de p3: ");
        p.setEndereco("Minha casa nova");
        dao.atualizarPessoa(p);
        System.out.println("novos dados: "+p);
                
        // teste de busca
        p = dao.retornarPessoa(2);
        System.out.println("* buscando pessoa 2: " + p);
        
        // excluir pessoa
        dao.removerPessoa(p);
        System.out.print("* Pessoas no cadastro: ");
        System.out.println(dao.retornarQuantidadeDePessoas());
        
        // quais são os livros no cadastro?
        System.out.println("* Livros no cadastro: ");
        for (Livro livro : dao.retornarLivros()) {
            System.out.println(livro);
        }
        
        // teste de filtro
        String exp = "na";
        System.out.println("* Livros que possuem a expressão '"+exp+"':");
        for (Livro livro : dao.retornarLivrosPorTextoDeBusca(exp)) {
            System.out.println(">"+livro);
        }        
    }
}