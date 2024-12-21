package model;

import entidade.Relatorio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class RelatorioDAO {

    public ArrayList<Relatorio> gerarRelatorio() throws Exception {
        Conexao conexao = new Conexao();
        ArrayList<Relatorio> listaRelatorio = new ArrayList<>(); 
        try {
            String sql
                    = "SELECT "
                    + "    d.nome AS disciplina, "
                    + "    t.nome AS turma, "
                    + "    a.nome AS aluno, "
                    + "    n.nota "
                    + "FROM "
                    + "    Turma t "
                    + "JOIN Disciplina d ON t.id_disciplina = d.id "
                    + "JOIN Matricula m ON m.id_turma = t.id "
                    + "JOIN Aluno a ON a.id = m.id_aluno "
                    + "LEFT JOIN Nota n ON n.id_matricula = m.id "
                    + "ORDER BY d.nome, t.nome, a.nome"; 
            PreparedStatement preparedStatement = conexao.getConexao().prepareStatement(sql);
            ResultSet resultado = preparedStatement.executeQuery(); 

            while (resultado.next()) {
                Relatorio relatorio = new Relatorio(
                        resultado.getString("disciplina"),
                        resultado.getString("turma"),
                        resultado.getString("aluno"),
                        resultado.getFloat("nota")
                );
                listaRelatorio.add(relatorio);
            }
        } finally {
            conexao.closeConexao(); 
        }
        return listaRelatorio; 
    }
}