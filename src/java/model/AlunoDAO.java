package model;

import entidade.Aluno;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AlunoDAO {

    public ArrayList<Aluno> getAlunoAll() throws SQLException {

        ArrayList<Aluno> resultAluno = new ArrayList<>();
        Conexao conexao = new Conexao();
        PreparedStatement sql = conexao.getConexao().prepareStatement("select * from alunos");

        ResultSet resultado = sql.executeQuery();

        if (resultado != null) {

            while (resultado.next()) {
                Aluno aluno = new Aluno();
                aluno.setId(Integer.parseInt(resultado.getString("id")));
                aluno.setNome(resultado.getString("nome"));
                resultAluno.add(aluno);
            }
        }
        
        return resultAluno;
        
    }

}
