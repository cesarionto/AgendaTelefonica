/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cesario.agendatelefonica.conexaosql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author cesar
 */
public class ConnectionFactory {
    public Connection getConnection(){
        String url = "jdbc:mysql://localhost:3306/agenda"
                + "?useTimezone=true&serverTimezone=America/Sao_Paulo";
        String usuario = "root";
        String senha = "";
        String driver = "com.mysql.cj.jdbc.Driver";
        
        try {
            Class.forName(driver);
            return DriverManager.getConnection(url, usuario, senha);
        }catch(SQLException | ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }
}
