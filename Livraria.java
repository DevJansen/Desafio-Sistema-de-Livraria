import java.util.ArrayList;
import java.util.List;

public class Livraria {

    List<Livro> livros = new ArrayList<>();
    List<Autor> autores = new ArrayList<>();
    List<Emprestimo> emprestimos = new ArrayList<>();

    //metodos para gerencia livros
    //metodo para adiciona o livro
    public void adicionarLivro(Livro livro){
        livros.add(livro);
    }

    //metodo para lista os livros
     public List<Livro> listarLivros(){
        return livros;
     }

     //metodo para lista livros disponivel
     public List<Livro> listarLivrosDisponivel(){
        List<Livro> livroDisponiveis = new ArrayList<>();
        for(Livro livros : livros){
            if (livros.isDisponivel()){
                livroDisponiveis.add(livros);
            }
        }
        return livroDisponiveis;
     }

     //metodo para busca livro por id
     public Livro buscarLivroPorId(int id){
        for (Livro livro : livros){
            if (livro.getId() == id){
                return livro;
            }
        }
        return null;
     }

     //atualiza o titulo do livro
     public  void atualizarLivro(int id,String novoTitulo){
        for (Livro livro : livros){
            if(livro.getId() == id){
                livro.setTitulo(novoTitulo);
                break;
            }
        }
     }

     //remove livro
     public void removeLivro(int id){
        livros.removeIf(livro -> livro.getId() == id);
     }

     //metodos para gerencia autores
    //metodo para add autor
    public void adicionarAutor(Autor autor){
        autores.add(autor);
    }

    //metodo para lista autores
    public List<Autor> listaAutores(){
        return autores;
    }

    //metodo para autualiza o autor
    public void atualizarAutores(int id, String nome){
        for (Autor autor : autores){
            if (autor.getId() == id){
                autor.setNome(nome);
                break;
            }
        }
    }

    //remove autor
    public void removeAutor(int id){
        autores.removeIf(autor -> autor.getId() == id);
    }


    //metodos para gerencia o emprestimo
    public void emprestarLivro(Livro livro,String nomeUsuario){
        if (livro.isDisponivel()){
            Emprestimo emprestimo = new Emprestimo(livro, nomeUsuario);
            emprestimos.add(emprestimo);
            livro.setDisponivel(false);
        }else {
            System.out.println("Livros não disponivel para emprestimo!");
        }
    }

    //metodo lista livros emprestado
    public List<Emprestimo> listaLivrosEmprestados(){
        return  emprestimos;
    }

    //metodo para devolver livro
    public void devolverLivro(int idEmprestimo){
        for(Emprestimo emprestimo : emprestimos){
            if (emprestimo.getId() == idEmprestimo && emprestimo.isAtivo()){
                emprestimo.devolverLivro();
                break;
            }
        }
    }

}
