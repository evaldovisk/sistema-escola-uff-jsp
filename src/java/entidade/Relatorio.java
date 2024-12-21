/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidade;

/**
 *
 * @author evaldovisk
 */

public class Relatorio {
    private final String disciplina;
    private final String turma;
    private final String aluno;
    private final float nota;

    public Relatorio(String disciplina, String turma, String aluno, float nota) {
        this.disciplina = disciplina;
        this.turma = turma;
        this.aluno = aluno;
        this.nota = nota;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public String getTurma() {
        return turma;
    }

    public String getAluno() {
        return aluno;
    }

    public float getNota() {
        return nota;
    }
}