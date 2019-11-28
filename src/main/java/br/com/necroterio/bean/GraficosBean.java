package br.com.necroterio.bean;

import br.com.necroterio.dao.DefuntoDao;
import br.com.necroterio.dao.PessoaDao;
import br.com.necroterio.dto.PessoasPorEstadoDTO;
import br.com.necroterio.model.Defunto;
import br.com.necroterio.model.Pessoa;
import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.axes.cartesian.CartesianScales;
import org.primefaces.model.charts.axes.cartesian.linear.CartesianLinearAxes;
import org.primefaces.model.charts.axes.cartesian.linear.CartesianLinearTicks;
import org.primefaces.model.charts.bar.BarChartDataSet;
import org.primefaces.model.charts.bar.BarChartModel;
import org.primefaces.model.charts.bar.BarChartOptions;
import org.primefaces.model.charts.optionconfig.legend.Legend;
import org.primefaces.model.charts.optionconfig.legend.LegendLabel;
import org.primefaces.model.charts.pie.PieChartDataSet;
import org.primefaces.model.charts.pie.PieChartModel;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

@ManagedBean
public class GraficosBean implements Serializable {

    private BarChartModel barModel;
    private DefuntoDao defuntoDao;
    private PessoaDao pessoaDao;
    private List<Integer> diasDaSemana;
    private List<Pessoa> pessoas;
    private List<PessoasPorEstadoDTO> pessoasPorEstadoDTOS;

    private PieChartModel pieChartModel;

    public GraficosBean() {
        defuntoDao = new DefuntoDao();
        diasDaSemana = new ArrayList<>();
        pessoaDao = new PessoaDao();
        pessoas = new ArrayList<>();
        pessoas = pessoaDao.listarTodos();
        pessoasPorEstadoDTOS = new ArrayList<>();
        pessoasPorEstadoDTOS = pessoaDao.buscaQuantidadeDefuntoPorEstado();
    }

    @PostConstruct
    public void init() {
        createBarModel();
        createPieModel();

    }

    public void createBarModel() {
        barModel = new BarChartModel();
        ChartData data = new ChartData();
        BarChartDataSet barDataSet = new BarChartDataSet();

        barDataSet.setLabel("Quantidade de corpos que chegaram no último mês");

        List<Number> valores = new ArrayList<>();
        List<Integer> inteiros = pesquisarDiaSemana();

        for (int i = 0; i < inteiros.size(); i++) {
            Integer integer = inteiros.get(i);
            valores.add((Number) integer);
        }

        barDataSet.setData(valores);

        List<String> labels = new ArrayList<>();
        labels.add("Segunda-Feira");
        labels.add("Terça-Feira");
        labels.add("Quarta-Feira");
        labels.add("Quinta-Feira");
        labels.add("Sexta-Feira");
        labels.add("Sábado");
        labels.add("Domingo");
        data.setLabels(labels);
        barModel.setData(data);

        List<String> bgColor = new ArrayList<>();
        bgColor.add("rgba(255, 99, 132, 0.2)");
        bgColor.add("rgba(255, 159, 64, 0.2)");
        bgColor.add("rgba(255, 205, 86, 0.2)");
        bgColor.add("rgba(75, 192, 192, 0.2)");
        bgColor.add("rgba(54, 162, 235, 0.2)");
        bgColor.add("rgba(153, 102, 255, 0.2)");
        bgColor.add("rgba(201, 203, 207, 0.2)");
        barDataSet.setBackgroundColor(bgColor);

        List<String> borderColor = new ArrayList<>();
        borderColor.add("rgb(255, 99, 132)");
        borderColor.add("rgb(255, 159, 64)");
        borderColor.add("rgb(255, 205, 86)");
        borderColor.add("rgb(75, 192, 192)");
        borderColor.add("rgb(54, 162, 235)");
        borderColor.add("rgb(153, 102, 255)");
        borderColor.add("rgb(201, 203, 207)");
        barDataSet.setBorderColor(borderColor);
        barDataSet.setBorderWidth(1);

        data.addChartDataSet(barDataSet);


        //Options
        BarChartOptions options = new BarChartOptions();
        CartesianScales cScales = new CartesianScales();
        CartesianLinearAxes linearAxes = new CartesianLinearAxes();
        CartesianLinearTicks ticks = new CartesianLinearTicks();
        ticks.setBeginAtZero(true);
        linearAxes.setTicks(ticks);
        cScales.addYAxesData(linearAxes);
        options.setScales(cScales);


        Legend legend = new Legend();
        legend.setDisplay(true);
        legend.setPosition("top");
        LegendLabel legendLabels = new LegendLabel();
        legendLabels.setFontStyle("bold");
        legendLabels.setFontColor("#2980B9");
        legendLabels.setFontSize(24);
        legend.setLabels(legendLabels);
        options.setLegend(legend);

        barModel.setOptions(options);
    }

    public BarChartModel getBarModel() {
        return barModel;
    }

    public void setBarModel(BarChartModel barModel) {
        this.barModel = barModel;
    }

    public List<Integer> pesquisarDiaSemana() {
        diasDaSemana.add(0, 0);
        diasDaSemana.add(1, 0);
        diasDaSemana.add(2, 0);
        diasDaSemana.add(3, 0);
        diasDaSemana.add(4, 0);
        diasDaSemana.add(5, 0);
        diasDaSemana.add(6, 0);


        List<Defunto> defuntos = defuntoDao.listarTodos();
        Calendar cal = Calendar.getInstance();
        for (int i = 0; i < defuntos.size(); i++) {
            cal.setTime(defuntos.get(i).getDataEntrada());
            int day = cal.get(Calendar.DAY_OF_WEEK);
            switch (day) {
                case Calendar.SATURDAY:
                    diasDaSemana.set(5, diasDaSemana.get(0) + 1);
                    break;
                case Calendar.SUNDAY:
                    diasDaSemana.set(6, diasDaSemana.get(0) + 1);
                    break;
                case Calendar.MONDAY:
                    diasDaSemana.set(0, diasDaSemana.get(0) + 1);
                    break;
                case Calendar.TUESDAY:
                    diasDaSemana.set(1, diasDaSemana.get(0) + 1);
                    break;
                case Calendar.WEDNESDAY:
                    diasDaSemana.set(2, diasDaSemana.get(0) + 1);
                    break;
                case Calendar.THURSDAY:
                    diasDaSemana.set(3, diasDaSemana.get(0) + 1);
                    break;
                case Calendar.FRIDAY:
                    diasDaSemana.set(4, diasDaSemana.get(0) + 1);
                    break;
                default:
                    break;
            }
        }
        return diasDaSemana;
    }


//    _____________________________________A partir daqui, gráfico de pizza_____________________________________________

    public PieChartModel getPieChartModel() {
        return pieChartModel;
    }

    public void setPieChartModel(PieChartModel pieChartModel) {
        this.pieChartModel = pieChartModel;
    }

    private void createPieModel() {
        pieChartModel = new PieChartModel();
        ChartData data = new ChartData();

        PieChartDataSet dataSet = new PieChartDataSet();
        List<Number> values = new ArrayList<>();
        List<String> labels = new ArrayList<>();

        for (int i = 0; i < pessoasPorEstadoDTOS.size(); i++) {
            PessoasPorEstadoDTO pessoa = pessoasPorEstadoDTOS.get(i);
            values.add((Number) pessoa.getQuantidadePessoa());
            labels.add(pessoa.getEstado().getDescricao());
        }

        dataSet.setData(values);

        List<String> bgColors = new ArrayList<>();
        bgColors.add("rgb(255, 99, 132)");
        bgColors.add("rgb(54, 162, 235)");
        bgColors.add("rgb(255, 205, 86)");
        bgColors.add("rgb(80, 60, 86)");
        bgColors.add("rgb(182, 205, 86)");
        bgColors.add("rgb(140, 205, 86)");
        bgColors.add("rgb(160, 205, 86)");
        bgColors.add("rgb(120, 205, 86)");
        bgColors.add("rgb(100, 205, 86)");
        dataSet.setBackgroundColor(bgColors);


        data.addChartDataSet(dataSet);
        data.setLabels(labels);
        pieChartModel.setData(data);
    }
}

