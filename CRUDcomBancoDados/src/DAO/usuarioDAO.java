package DAO;

import BEAN.usuarioBEAN;
import conexao.connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class usuarioDAO {
    public void salvar(usuarioBEAN ub){
        Connection con = connection.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO usuarios(nome, email, senha) VALUES(?,?,?)");
            stmt.setString(1, ub.getNome());
            stmt.setString(2, ub.getEmail());
            stmt.setString(3, ub.getSenha());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Salvo com sucesso!!");
        } catch (SQLException ex) {
            System.out.println("Erro "+ex);
        }
    }
    
    public void atualizar(usuarioBEAN ub, String email){
        Connection con = connection.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE usuarios set nome = ?, email = ?, senha = ? WHERE email = ?");
            stmt.setString(1, ub.getNome());
            stmt.setString(2, ub.getEmail());
            stmt.setString(3, ub.getSenha());
            stmt.setString(4, email);
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Atualizado com Sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro: "+ex);
        }
    }
    
    public void deletar(usuarioBEAN usub){
        Connection con = connection.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM usuarios WHERE email = ?");
            stmt.setString(1, usub.getEmail());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Excluido com sucesso!!");
        } catch (SQLException ex) {
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
