package model;

import entidade.Aluno;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AlunoDAO {

    public void inserir(Aluno aluno) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement(
                "INSERT INTO Aluno (nome, email, celular, cpf, senha, endereco, cidade, bairro, cep) VALUES (?,?,?,?,?,?,?,?,?)"
            );
            sql.setString(1, aluno.getNome());
            sql.setString(2, aluno.getEmail());
            sql.setString(3, aluno.getCelular());
            sql.setString(4, aluno.getCpf());
            sql.setString(5, aluno.getSenha());
            sql.setString(6, aluno.getEndereco());
            sql.setString(7, aluno.getCidade());
            sql.setString(8, aluno.getBairro());
            sql.setString(9, aluno.getCep());
            sql.executeUpdate();
        } finally {
            conexao.closeConexao();
        }
    }

    public void alterar(Aluno aluno) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement(
                "UPDATE Aluno SET nome=?, email=?, celular=?, cpf=?, senha=?, endereco=?, cidade=?, bairro=?, cep=? WHERE id=?"
            );
            sql.setString(1, aluno.getNome());
            sql.setString(2, aluno.getEmail());
            sql.setString(3, aluno.getCelular());
            sql.setString(4, aluno.getCpf());
            sql.setString(5, aluno.getSenha());
            sql.setString(6, aluno.getEndereco());
            sql.setString(7, aluno.getCidade());
            sql.setString(8, aluno.getBairro());
            sql.setString(9, aluno.getCep());
            sql.setInt(10, aluno.getId());
            sql.executeUpdate();
        } finally {
            conexao.closeConexao();
        }
    }

    public void excluir(int id) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("DELETE FROM Aluno WHERE id=?");
            sql.setInt(1, id);
            sql.executeUpdate();
        } finally {
            conexao.closeConexao();
        }
    }

    public Aluno obter(int id) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM Aluno WHERE id=?");
            sql.setInt(1, id);
            ResultSet resultado = sql.executeQuery();
            if (resultado.next()) {
                return new Aluno(
                    resultado.getString("nome"),
                    resultado.getString("email"),
                    resultado.getString("celular"),
                    resultado.getString("cpf"),
                    resultado.getString("senha"),
                    resultado.getString("endereco"),
                    resultado.getString("cidade"),
                    resultado.getString("bairro"),
                    resultado.getString("cep")
                );
            }
        } finally {
            conexao.closeConexao();
        }
        return null;
    }

    public ArrayList<Aluno> listar() throws Exception {
        Conexao conexao = new Conexao();
        ArrayList<Aluno> lista = new ArrayList<>();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM Aluno ORDER BY nome");
            ResultSet resultado = sql.executeQuery();
            while (resultado.next()) {
                Aluno aluno = new Aluno(
                    resultado.getString("nome"),
                    resultado.getString("email"),
                    resultado.getString("celular"),
                    resultado.getString("cpf"),
                    resultado.getString("senha"),
                    resultado.getString("endereco"),
                    resultado.getString("cidade"),
                    resultado.getString("bairro"),
                    resultado.getString("cep")
                );
                aluno.setId(resultado.getInt("id"));
                lista.add(aluno);
            }
        } finally {
            conexao.closeConexao();
        }
        return lista;
    }

}
