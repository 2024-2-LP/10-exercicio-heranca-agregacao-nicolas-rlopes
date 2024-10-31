package school.sptech;

import school.sptech.especialistas.DesenvolvedorMobile;
import school.sptech.especialistas.DesenvolvedorWeb;

import java.util.ArrayList;
import java.util.List;

public class Consultoria {

    private String nome;
    private Integer vagas;
    private List<Desenvolvedor> desenvolvedores;

    public Consultoria() {
        this.desenvolvedores = new ArrayList<>();
    }

    public void contratar(Desenvolvedor desenvolvedor) {
        if (desenvolvedores.size() < vagas) {
            desenvolvedores.add(desenvolvedor);
        }
    }

    public void contratarFullstack(DesenvolvedorWeb desenvolvedor) {

        if (desenvolvedor.isFullstack()) {
            desenvolvedores.add(desenvolvedor);
        }
    }

    public Double getTotalSalarios() {

        Double totalSalario = 0.0;
        for (int i = 0; i < desenvolvedores.size(); i++) {
            Desenvolvedor desenvolvedorAtual = desenvolvedores.get(i);

            totalSalario += desenvolvedorAtual.calcularSalario();
        }

        return totalSalario;
    }

    public Integer qtdDesenvolvedoresMobile() {

        Integer quantidade = 0;
        for (int i = 0; i < desenvolvedores.size(); i++) {
            Desenvolvedor desenvolvedorAtual = desenvolvedores.get(i);

            if (desenvolvedorAtual instanceof DesenvolvedorMobile) {
                quantidade++;
            }
        }
        return quantidade;
    }

    public List<Desenvolvedor> buscarPorSalarioMaiorIgualQue(Double salario) {

        List<Desenvolvedor> desenvolvedorMaiorIgualQue = new ArrayList<>();
        for (int i = 0; i < desenvolvedores.size(); i++) {
            Desenvolvedor desenvolvedorAtual = desenvolvedores.get(i);

            if (desenvolvedorAtual.calcularSalario() > salario) {
                desenvolvedorMaiorIgualQue.add(desenvolvedorAtual);
            }
        }
        return desenvolvedorMaiorIgualQue;
    }

    public Desenvolvedor buscarMenorSalario() {

        if (desenvolvedores.isEmpty()) {
            return null;
        }

        Desenvolvedor desenvolvedorMenorSalario = desenvolvedores.get(0);
        Double menorSalario = desenvolvedores.get(0).calcularSalario();
        for (int i = 0; i < desenvolvedores.size(); i++) {
            Desenvolvedor desenvolvedorAtual = desenvolvedores.get(i);

            if (menorSalario > desenvolvedorAtual.calcularSalario()) {
                menorSalario = desenvolvedorAtual.calcularSalario();
                desenvolvedorMenorSalario = desenvolvedorAtual;
            }
        }
        return desenvolvedorMenorSalario;
    }

    public List<Desenvolvedor> buscarPorTecnologia(String tecnologia) {

        List<Desenvolvedor> desenvolvedorPorTecnologia = new ArrayList<>();
        for (int i = 0; i < desenvolvedores.size(); i++) {
            Desenvolvedor desenvolvedorAtual = desenvolvedores.get(i);

            if (desenvolvedorAtual instanceof DesenvolvedorMobile) {

                if (((DesenvolvedorMobile) desenvolvedorAtual).getPlataforma().equalsIgnoreCase(tecnologia) || ((DesenvolvedorMobile) desenvolvedorAtual).getLinguagem().equalsIgnoreCase(tecnologia)) {
                    desenvolvedorPorTecnologia.add(desenvolvedorAtual);
                }
            }

            if (desenvolvedorAtual instanceof DesenvolvedorWeb) {

                if (((DesenvolvedorWeb) desenvolvedorAtual).getBackend().equalsIgnoreCase(tecnologia) || ((DesenvolvedorWeb) desenvolvedorAtual).getFrontend().equalsIgnoreCase(tecnologia) || ((DesenvolvedorWeb) desenvolvedorAtual).getSgbd().equalsIgnoreCase(tecnologia)) {
                    desenvolvedorPorTecnologia.add(desenvolvedorAtual);
                }
            }

        }

        return desenvolvedorPorTecnologia;

    }

    public Double getTotalSalariosPorTecnologia(String tecnologia) {
        List<Desenvolvedor> desenvolvedorPorTecnologia = buscarPorTecnologia(tecnologia);

        Double totalSalario = 0.0;
        for (int i = 0; i < desenvolvedorPorTecnologia.size(); i++) {
            Desenvolvedor desenvolvedorAtual = desenvolvedorPorTecnologia.get(i);

            totalSalario += desenvolvedorAtual.calcularSalario();
        }

        return totalSalario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }

    public List<Desenvolvedor> getDesenvolvedores() {
        return desenvolvedores;
    }
}
