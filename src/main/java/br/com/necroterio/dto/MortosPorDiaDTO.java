package br.com.necroterio.dto;

import br.com.necroterio.dao.DefuntoDao;
import br.com.necroterio.model.Defunto;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MortosPorDiaDTO {

    private String diaSemana;
    private Long quantidade;
    private DefuntoDao defuntoDao;
    private List<Integer> segunda;

    public MortosPorDiaDTO(String diaSemana, Long quantidade, DefuntoDao defuntoDao) {
        this.diaSemana = diaSemana;
        this.quantidade = quantidade;
        defuntoDao = new DefuntoDao();
        segunda = new ArrayList<>();
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }


    public Number pesquisarDiaSemana() {
        List<Defunto> defuntos = defuntoDao.listarTodos();
        Calendar cal = Calendar.getInstance();
        for (int i = 0; i < defuntos.size(); i++) {
            cal.setTime(defuntos.get(i).getDataEntrada());
            int day = cal.get(Calendar.DAY_OF_WEEK);
            switch (day) {
                case Calendar.SATURDAY:
                    //Adicionar na lista de sábado
                    break;
                case Calendar.SUNDAY:
                    //Adicionar na lista de domingo
                    break;
                case Calendar.MONDAY:
                    //Adicionar na lista de segunda
                    break;
                case Calendar.TUESDAY:
                    //Adicionar na lista de terça
                    break;
                case Calendar.WEDNESDAY:
                    //Adicionar na lista de quarta
                    break;
                case Calendar.THURSDAY:
                    //Adicionar na lista de quinta
                    break;
                case Calendar.FRIDAY:
                    //Adicionar na lista de sexta
                    break;
                default:
                    break;
            }
        }
        return null;
    }
}