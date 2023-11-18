package sistema;

import java.util.ArrayList;

import DAO.EspecificacaoDAO;
import DAO.Especificacao_has_Produto;

public class Especificacao 
{

    /* Construtores */

    public Especificacao(){};

    /* 
     * Construtor feito para montagem do objeto que está vindo do banco de dados (Possui ID)
     */
    public Especificacao(int id, String nome, String valor) 
    {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
    }

    /* 
     * Construtor feito para montagem do objeto que será enviado para o banco de dados ( Não possui ID, pois ele é gerado automaticamente no BD)
     */
    public Especificacao(String nome, String valor) 
    {
        this.nome = nome;
        this.valor = valor;

        especificacaoDAO.insert(this);
    }

    /* Funções gerais */
    public static void printarEspecificacao(Especificacao especificacao)
    {
        System.out.println("ID: " + especificacao.getId());
        System.out.println("Nome: " + especificacao.getNome());
        System.out.println("Valor: " + especificacao.getValor());
        System.out.println("\n");
    }

    /* Getters e Setters */

    public void setValores(String nome, String valor)
    {
        this.setNome(nome);
        this.setValor(valor);
    }

    public static String getNomeTabela()
    {
        return Especificacao.nomeTabela;
    }

    public int getId() 
    {
        return this.id;
    }

    public void setId(int id) 
    {
        this.id = id;
        especificacaoDAO.updateInt(this, Coluna.ID.getNomeColuna(), this.id);
    }

    public String getNome() 
    {
        return this.nome;
    }

    public void setNome(String nome) 
    {
        this.nome = nome;
        especificacaoDAO.updateString(this, Coluna.NOME.getNomeColuna(), this.nome);
    }

    public String getValor() 
    {
        return this.valor;
    }

    public void setValor(String valor) 
    {
        this.valor = valor;
        especificacaoDAO.updateString(this, Coluna.VALOR.getNomeColuna(), this.valor);
    }

    /* 
     * Enum com as tabelas da classe
     */
    public enum Coluna
    {
        ID("idEspecificacao"),
        NOME("nome"),
        VALOR("valor");

        private final String nomeColuna;

        Coluna(String nomeColuna)
        {
            this.nomeColuna = nomeColuna;
        }

        public String getNomeColuna()
        {
            return this.nomeColuna;
        }
    }

    /* Funções */

    public ArrayList<Produto> produtosRelacionados()
    {
        return especificacao_has_Produto_DAO.selectTodosProdutosDaEspecificacao(this.getId());
    }

    public void delete()
    {
        // Deletando da tabela de especificacao_has_produto
        ArrayList<Produto> produtos = this.produtosRelacionados();
        for (Produto produto : produtos) 
        {
            especificacao_has_Produto_DAO.delete(this, produto);
        }

        // Deletando da tabela de especificacao
        especificacaoDAO.delete(this);
    }

    public void insert()
    {
        //Adicionando na tabela de especificacao
        especificacaoDAO.insert(this);
    }

    /* Atributos */
    
    private int id;
    private String nome;
    private String valor;
    private EspecificacaoDAO especificacaoDAO = new EspecificacaoDAO();
    private Especificacao_has_Produto especificacao_has_Produto_DAO = new Especificacao_has_Produto();
    private static final String nomeTabela = "Especificacao";

}
