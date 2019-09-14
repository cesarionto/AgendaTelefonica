/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cesario.agendatelefonica.controladores;

import br.com.cesario.agendatelefonica.conexaosql.ContatosDAO;
import br.com.cesario.agendatelefonica.interfacegrafica.TelaPrincipal;
import br.com.cesario.agendatelefonica.modelos.Contatos;

/**
 *
 * @author cesar
 */
public class ControladorTelaPrincipal {

    private Contatos contato = new Contatos();
    private ContatosDAO dao = new ContatosDAO();

    public void adicionaContato(TelaPrincipal tela) {
//        contato.setId(Integer.parseInt(tela.getId().getText()));
        contato.setNome(tela.getNome().getText());
        contato.setNumero_telefone(tela.getNumerotelefone().getText());

        dao.adiciona(contato);
    }

    public void alteraContato(TelaPrincipal tela) {
        contato.setId(Integer.parseInt(tela.getId().getText()));
        contato.setNome(tela.getNome().getText());
        contato.setNumero_telefone(tela.getNumerotelefone().getText());

        dao.atualizar(contato);
    }

    public void excluir(TelaPrincipal tela) {
        int id;
        id = Integer.parseInt(tela.getId().getText());
        contato.setId(id);

        dao.apagar(contato);
    }

    public void pesquisar(TelaPrincipal tela) {
        String nome;
        nome = tela.getNome().getText();
    }
}
