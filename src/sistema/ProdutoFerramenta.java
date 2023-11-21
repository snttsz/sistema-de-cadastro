package sistema;

import java.util.ArrayList;

public class ProdutoFerramenta extends Produto
{

    /* Construtores */

    public ProdutoFerramenta(){};

    /* 
     * Construtor feito para montagem do objeto que está vindo do banco de dados (Possui ID)
     */
    public ProdutoFerramenta(int id, String descricao, String nome, double preco, String link,
        String url_foto, String data_de_adicao, double valorArrecadado, double valorFrete, 
        String categoria, ArrayList<Especificacao> especificacoes, ArrayList<String> tags, int idUsuario, int idLoja) 
    {
        super(id, descricao, nome, preco, link, url_foto, data_de_adicao, valorArrecadado, 
        valorFrete, categoria, especificacoes, tags, idUsuario, idLoja);
    }

    /* 
     * Construtor feito para montagem do objeto que será enviado para o banco de dados ( Não possui ID, pois ele é gerado automaticamente no BD)
     */
    public ProdutoFerramenta(String descricao, String nome, double preco, String link, String url_foto, String data_de_adicao, 
    double valorArrecadado, double valorFrete, String categoria, ArrayList<Especificacao> especificacoes, ArrayList<String> tags, int idUsuario, int idLoja)
    {
        super(descricao, nome, preco, link, url_foto, data_de_adicao,
        valorArrecadado, valorFrete, categoria, especificacoes, tags, idUsuario, idLoja);

        super.getProdutoDAO().insert(this);
    }

}
