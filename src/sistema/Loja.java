package sistema;

import DAO.LojaDAO;

public class Loja 
{
    
    /* Construtores */

    public Loja(){};

    /* 
     * Construtor feito para montagem do objeto que está vindo do banco de dados (Possui ID)
     */
    public Loja(int id, String nome, String url) 
    {
        this.id = id;
        this.nome = nome;
        this.url = url;
    }

    /* 
     * Construtor feito para montagem do objeto que será enviado para o banco de dados ( Não possui ID, pois ele é gerado automaticamente no BD)
     */
    public Loja(String nome, String url) 
    {
        this.nome = nome;
        this.url = url;

        lojaDAO.insert(this);
    }

    /* Getters e Setters */

    public void setValores(String nome, String url)
    {
        this.setNome(nome);
        this.setUrl(url);
    }

    public static String getNomeTabela() 
    {
        return Loja.nomeTabela;
    }

    public String getNome() 
    {
        return this.nome;
    }

    public void setNome(String nome) 
    {
        this.nome = nome;
        lojaDAO.updateString(this, Coluna.NOME.getNomeColuna(), this.nome);
    }

    public int getId() 
    {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
        lojaDAO.updateInt(this, Coluna.ID.getNomeColuna(), this.id);
    }

    public String getUrl() 
    {
        return this.url;
    }
    
    public void setUrl(String url) 
    {
        this.url = url;
        lojaDAO.updateString(this, Coluna.URL.getNomeColuna(), this.url);
    }

    /* 
     * Enum com as tabelas da classe
     */
    public enum Coluna
    {
        ID("idLoja"),
        NOME("nome"),
        URL("url");

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
    /* Atributos */
    
    private String nome;
    private String url;
    private int id;
    private LojaDAO lojaDAO = new LojaDAO();
    private static final String nomeTabela = "Loja";

}
