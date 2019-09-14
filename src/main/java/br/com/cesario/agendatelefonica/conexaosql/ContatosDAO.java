/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cesario.agendatelefonica.conexaosql;

import br.com.cesario.agendatelefonica.modelos.Contatos;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author cesar
 */
public class ContatosDAO {

    public Connection connection;

    public ContatosDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void adiciona(Contatos contato) {
        String sql = "insert into contatos "
                + "( nome, numero_telefone) values (?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, contato.getNome());
            stmt.setString(2, contato.getNumero_telefone());
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Contato Adicionado");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro, verifique o"
                    + " banco de dados e tente novamente!");//ESSA MERDA NÂO APARECEEEEE!
            throw new RuntimeException(e);
        }

    }

    public void atualizar(Contatos contato) {
        String sql = "update contatos set "
                + "nome = ? , numero_telefone = ? where id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, contato.getNome());
            stmt.setString(2, contato.getNumero_telefone());
            stmt.setLong(3, contato.getId());
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Contato Atualizado");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro, verifique o"
                    + " banco de dados e tente novamente!" + e);//ESSA MERDA NÂO APARECEEEEE!
            throw new RuntimeException(e);
        }

    }

    /**
     *
     * @return
     */
    public List<Contatos> listar() {
        try {
            List<Contatos> contatos = new ArrayList<>();
            PreparedStatement stmt = this.connection.prepareStatement("SELECT * from contatos ORDER BY nome");
            ResultSet resultset = stmt.executeQuery();
            while (resultset.next()) {
                Contatos contato = new Contatos();
                contato.setId(resultset.getInt("id"));
                contato.setNome(resultset.getString("nome"));
                contato.setNumero_telefone(resultset.getString("numero_telefone"));
                contatos.add(contato);
            }
            resultset.close();
            stmt.close();
            return contatos;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void apagar(Contatos contato) {

        PreparedStatement stmt;
        try {
            stmt = this.connection.prepareStatement("delete from contatos where id = ?");
            stmt.setLong(1, contato.getId());
            System.out.println("Eu Sou o contato: " + contato.getId());
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Contato Excluido");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro: " + ex);
        }

    }

    public List<Contatos> listarBusca(String nome) {
        try {
            List<Contatos> contatos = new ArrayList<>();
            PreparedStatement stmt = this.connection.prepareStatement("SELECT * from contatos ORDER BY nome");
            ResultSet resultset = stmt.executeQuery();
            while (resultset.next()) {
                Contatos contato = new Contatos();
                contato.setId(resultset.getInt("id"));
                contato.setNome(resultset.getString("nome"));
                contato.setNumero_telefone(resultset.getString("numero_telefone"));
                contatos.add(contato);
            }
            resultset.close();
            stmt.close();
            return contatos;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
