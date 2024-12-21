/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entidade.Disciplina;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author evaldovisk
 */
public class DisciplinaDAO {
        public void inserir(Disciplina disciplina) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement(
                "INSERT INTO Disciplina (nome, descricao, carga_horaria) VALUES (?,?,?)"
            );
            sql.setString(1, disciplina.getNome());
            sql.setString(2, disciplina.getDescricao());
            sql.setInt(3, disciplina.getCargaHoraria());
            sql.executeUpdate();
        } finally {
            conexao.closeConexao();
        }
    }

    public void alterar(Disciplina disciplina) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement(
                "UPDATE Disciplina SET nome=?, descricao=?, carga_horaria=? WHERE id=?"
            );
            sql.setString(1, disciplina.getNome());
            sql.setString(2, disciplina.getDescricao());
            sql.setInt(3, disciplina.getCargaHoraria());
            sql.setInt(4, disciplina.getId());
            sql.executeUpdate();
        } finally {
            conexao.closeConexao();
        }
    }

    public void excluir(int id) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("DELETE FROM Disciplina WHERE id=?");
            sql.setInt(1, id);
            sql.executeUpdate();
        } finally {
            conexao.closeConexao();
        }
    }

    public Disciplina obter(int id) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM Disciplina WHERE id=?");
            sql.setInt(1, id);
            ResultSet resultado = sql.executeQuery();
            if (resultado.next()) {
                return new Disciplina(
                    resultado.getString("nome"),
                    resultado.getString("descricao"),
                    resultado.getInt("carga_horaria")
                );
            }
        } finally {
            conexao.closeConexao();
        }
        return null;
    }

    public ArrayList<Disciplina> listar() throws Exception {
        Conexao conexao = new Conexao();
        ArrayList<Disciplina> lista = new ArrayList<>();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM Disciplina ORDER BY nome");
            ResultSet resultado = sql.executeQuery();
            while (resultado.next()) {
                Disciplina disciplina = new Disciplina(
                    resultado.getString("nome"),
                    resultado.getString("descricao"),
                    resultado.getInt("carga_horaria")
                );
                disciplina.setId(resultado.getInt("id"));
                lista.add(disciplina);
            }
        } finally {
            conexao.closeConexao();
        }
        return lista;
    }
    
}
