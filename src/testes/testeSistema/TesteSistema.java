package testes.testeSistema;

import java.util.ArrayList;

import DAO.LojaDAO;
import DAO.UsuariosDAO;
import bancodedados.SQLiteConnectionManager;
import sistema.Loja;
import sistema.Usuario;
import utils.ParserArquivo;

public class TesteSistema 
{

    public static void main(String args[])
    {
        UsuariosDAO usuariosDAO = new UsuariosDAO();
        LojaDAO lojaDao = new LojaDAO();

        // Usuario newUsuario = new Usuario("Kalvin", "kalvin123", "123", "kalvin123@gmail.com");
        // usuariosDAO.insert(newUsuario);
        
        // ArrayList<Usuario> allUsuarios = usuariosDAO.selectAll();
        // System.out.println("---- TODOS OS USUARIOS ----");
        // allUsuarios.forEach(usuario -> {
        //     // usuariosDAO.delete(usuario);
        //     // Usuario.printarUsuario(usuario);
        // });

        // ArrayList<Loja> allLojas = lojaDao.selectAll();
        // System.out.println("---- TODOS AS LOJAS ----");
        // allLojas.forEach(loja -> {
            // Loja.printarLoja(loja);
            // usuariosDAO.delete(usuario);
            // Usuario.printarUsuario(usuario);
        // });
    }

    // public static void povoarBanco()
    // {
    //     String scriptPath = "database/scriptPovoamento.txt";

    //     ArrayList<String> instrucoes = new ArrayList<String>();
    //     instrucoes = ParserArquivo.lerScriptSQL(scriptPath);
        
    //     for(String instrucao : instrucoes)
    //     {   
    //         SQLiteConnectionManager.enviarQuery(instrucao);
    //     }

    // }

}


