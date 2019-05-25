
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PIMobile.gui;

import PIMobile.Entite.Stat;
import PIMobile.Service.ServiceLivre;
import com.codename1.charts.ChartComponent;
import com.codename1.charts.models.CategorySeries;
import com.codename1.charts.renderers.DefaultRenderer;
import com.codename1.charts.renderers.SimpleSeriesRenderer;
import com.codename1.charts.util.ColorUtil;
import com.codename1.charts.views.PieChart;
import com.codename1.components.InfiniteProgress;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BorderLayout;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author hatem
 */
public class StatLivre {
    
    Form f;

    ServiceLivre ServiceLivre = new ServiceLivre();
    ArrayList<Stat> Stat = new ArrayList<>();
    
    

    public StatLivre() {
        
       }

     private DefaultRenderer buildCategoryRenderer(int[] colors) {
    DefaultRenderer renderer = new DefaultRenderer();
    renderer.setLabelsTextSize(55);
    renderer.setLegendTextSize(55);
    renderer.setMargins(new int[]{20, 30, 15, 0});
    for (int color : colors) {
        SimpleSeriesRenderer r = new SimpleSeriesRenderer();
        r.setColor(color);
        renderer.addSeriesRenderer(r);
    }
    return renderer;
}

/**
 * Builds a category series using the provided values.
 *
 * @param titles the series titles
 * @param values the values
 * @return the category series
 */
protected CategorySeries buildCategoryDataset(String title, double[] values) {
    CategorySeries series = new CategorySeries(title);
        /*int k = 0;
    for (double value : values) {
        series.add("Project " + ++k, value);
    }*/
        for (int i = 0; i < values.length; i++) {
            series.add(Stat.get(i).getTitre(), values[i]);
        }

        return series;
    }
    
    public Form createPieChartForm() {
    // Generate the values
    
    ServiceLivre=new ServiceLivre();
         Stat = ServiceLivre.getListStat();
         double[] values = new double[Stat.size()];
         //ArrayList<Double> values = new ArrayList<>();
         for(int i =0 ; i<Stat.size();i++)
         { 
             Stat v = Stat.get(i);
             values[i]=Double.valueOf(v.getNbLocation());
             //values.add(Double.valueOf(v.getNb_dispo()));
         }
    
int nbStat=Stat.size();
        System.out.println(nbStat);
   int[] colorss = new int[]{ColorUtil.BLUE, ColorUtil.GREEN, ColorUtil.MAGENTA, ColorUtil.YELLOW, ColorUtil.CYAN,ColorUtil.BLACK,ColorUtil.LTGRAY};
      int[] colors = new int[nbStat];

for(int in=0;in<nbStat;in++){
colors[in]=colorss[in];
    //System.out.println(colorss[in]);
}
    // Set up the renderer
   //int[] colors = new int[]{ColorUtil.BLUE, ColorUtil.GREEN, ColorUtil.MAGENTA, ColorUtil.YELLOW, ColorUtil.CYAN};
    DefaultRenderer renderer = buildCategoryRenderer(colors);
    renderer.setZoomButtonsVisible(true);
    renderer.setZoomEnabled(true);
    renderer.setChartTitleTextSize(100);
    renderer.setDisplayValues(true);
    renderer.setShowLabels(true);
    SimpleSeriesRenderer r = renderer.getSeriesRendererAt(0);
    r.setGradientEnabled(true);
    r.setGradientStart(0, ColorUtil.BLUE);
    r.setGradientStop(0, ColorUtil.GREEN);
    r.setHighlighted(true);
    
    PieChart chart = new PieChart(buildCategoryDataset("Project voyage", values ), renderer);

    // Wrap the chart in a Component so we can add it to a form
    ChartComponent c = new ChartComponent(chart);

    // Create a form and show it.
   Form  f = new Form("Statistique Livre", new BorderLayout());
           f.getToolbar().addCommandToLeftBar("Back", null, e->{
             Dialog ip = new InfiniteProgress().showInifiniteBlocking();
            GuiLivre gh = new GuiLivre();
            ip.dispose();
            gh.getForm_Gui_Hote().show();
           });

    f.add(BorderLayout.CENTER, c);
    return f;
    
    

}
    
    
    
        
        public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

}