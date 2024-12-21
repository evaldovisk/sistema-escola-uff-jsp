/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entidade.Turma;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author evaldovisk
 */
public class TurmaDAO {
        public void inserir(Turma turma) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement(
                "INSERT INTO Turma (nome, semestre, id_disciplina, id_professor) VALUES (?,?,?,?)"
            );
            sql.setString(1, turma.getNome());
            sql.setString(2, turma.getSemestre());
            sql.setInt(3, turma.getDisciplinaId());
            sql.setInt(4, turma.getProfessorId());
            sql.executeUpdate();
        } finally {
            conexao.closeConexao();
        }
    }

    public void alterar(Turma turma) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement(
                "UPDATE Turma SET nome=?, semestre=?, id_disciplina=?, id_professor=? WHERE id=?"
            );
            sql.setString(1, turma.getNome());
            sql.setString(2, turma.getSemestre());
            sql.setInt(3, turma.getDisciplinaId());
            sql.setInt(4, turma.getProfessorId());
            sql.setInt(5, turma.getId());
            sql.executeUpdate();
        } finally {
            conexao.closeConexao();
        }
    }

    public void excluir(int id) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("DELETE FROM Turma WHERE id=?");
            sql.setInt(1, id);
            sql.executeUpdate();
        } finally {
            conexao.closeConexao();
        }
    }

    public Turma obter(int id) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM Turma WHERE id=?");
            sql.setInt(1, id);
            ResultSet resultado = sql.executeQuery();
            if (resultado.next()) {
                return new Turma(
                    resultado.getString("nome"),
                    resultado.getString("semestre"),
                    resultado.getInt("id_disciplina"),
                    resultado.getInt("id_professor")
                );
            }
        } finally {
            conexao.closeConexao();
        }
        return null;
    }

    public ArrayList<Turma> listar() throws Exception {
        Conexao conexao = new Conexao();
        ArrayList<Turma> lista = new ArrayList<>();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM Turma ORDER BY nome");
            ResultSet resultado = sql.executeQuery();
            while (resultado.next()) {
                Turma turma = new Turma(
                    resultado.getString("nome"),
                    resultado.getString("semestre"),
                    resultado.getInt("id_disciplina"),
                    resultado.getInt("id_professor")
                );
                turma.setId(resultado.getInt("id"));
                lista.add(turma);
            }
        } finally {
            conexao.closeConexao();
        }
        return lista;
    }
    
}
