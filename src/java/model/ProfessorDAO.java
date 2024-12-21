/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entidade.Professor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author evaldovisk
 */
public class ProfessorDAO {
    public void inserir(Professor professor) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement(
                "INSERT INTO Professor (nome, email, cpf, senha) VALUES (?,?,?,?)"
            );
            sql.setString(1, professor.getNome());
            sql.setString(2, professor.getEmail());
            sql.setString(3, professor.getCpf());
            sql.setString(4, professor.getSenha());
            sql.executeUpdate();
        } finally {
            conexao.closeConexao();
        }
    }

    public void alterar(Professor professor) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement(
                "UPDATE Professor SET nome=?, email=?, cpf=?, senha=? WHERE id=?"
            );
            sql.setString(1, professor.getNome());
            sql.setString(2, professor.getEmail());
            sql.setString(3, professor.getCpf());
            sql.setString(4, professor.getSenha());
            sql.setInt(5, professor.getId());
            sql.executeUpdate();
        } finally {
            conexao.closeConexao();
        }
    }

    public void excluir(int id) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("DELETE FROM Professor WHERE id=?");
            sql.setInt(1, id);
            sql.executeUpdate();
        } finally {
            conexao.closeConexao();
        }
    }

    public Professor obter(int id) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM Professor WHERE id=?");
            sql.setInt(1, id);
            ResultSet resultado = sql.executeQuery();
            if (resultado.next()) {
                return new Professor(
                    resultado.getString("nome"),
                    resultado.getString("email"),
                    resultado.getString("cpf"),
                    resultado.getString("senha")
                );
            }
        } finally {
            conexao.closeConexao();
        }
        return null;
    }

    public ArrayList<Professor> listar() throws Exception {
        Conexao conexao = new Conexao();
        ArrayList<Professor> lista = new ArrayList<>();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM Professor ORDER BY nome");
            ResultSet resultado = sql.executeQuery();
            while (resultado.next()) {
                Professor professor = new Professor(
                    resultado.getString("nome"),
                    resultado.getString("email"),
                    resultado.getString("cpf"),
                    resultado.getString("senha")
                );
                professor.setId(resultado.getInt("id"));
                lista.add(professor);
            }
        } finally {
            conexao.closeConexao();
        }
        return lista;
    }
    
}
