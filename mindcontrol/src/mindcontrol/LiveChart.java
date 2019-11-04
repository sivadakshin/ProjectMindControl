/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mindcontrol;

/**
 *
 * @author siva
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import static javax.swing.WindowConstants.HIDE_ON_CLOSE;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.demo.charts.ExampleChart;
import org.knowm.xchart.demo.charts.RealtimeExampleChart;
import org.knowm.xchart.style.Styler.ChartTheme;

/**
 * Real-time XY Chart
 *
 * <p>Demonstrates the following:
 *
 * <ul>
 *   <li>real-time chart updates with SwingWrapper
 *   <li>Matlab Theme
 */
public class LiveChart extends JFrame{
 List<XYChart> charts = new ArrayList<XYChart>();
 public static SwingWrapper<XYChart> swingWrapper;
  private XYChart eegchart,meditationchart,attentionchart,deltachart,thetachart,low_alphachart,high_alphachart,low_betachart,high_betachart,low_gammachart,mid_gammachart,blinkchart;
int checker=0;
  private List<Double> eegData,meditationData,attentionData,deltaData,thetaData,low_alphaData,high_alphaData,low_betaData,high_betaData,low_gammaData,mid_gammaData,blinkData;
  public static final String SERIES_NAME = "EEGWAVES";
  public void show(){
      if(swingWrapper!=null){
      swingWrapper.displayChartMatrix().setDefaultCloseOperation(HIDE_ON_CLOSE);
    
      }
      else{
          Debug.sendprintmsg("swingwrapper is null");
      }
  }
  public void start() {
    // Setup the panel
    //final LiveChart graph = new LiveChart();
        charts.add(getEegchart());
	charts.add(getMeditationchart());
        charts.add(getAttentionchart());
        charts.add(getDeltachart());
        charts.add(getThetachart());
        charts.add(getLow_alphachart());
        charts.add(getHigh_alphachart());
        charts.add(getLow_betachart());
        charts.add(getHigh_betachart());
        charts.add(getLow_gammachart());
        charts.add(getMid_gammachart());
        charts.add(getBlinkchart());
    swingWrapper = new SwingWrapper<XYChart>(charts);
    //Debug.sendprintmsg("s: "+charts.size()+swingWrapper.toString());
    
  }


  public XYChart getEegchart() {
	eegData=new ArrayList<Double>();
    eegData.add((double)0);
    // Create Chart with 0
    eegchart =
        new XYChartBuilder()
            .width(500)
            .height(400)
            .theme(ChartTheme.Matlab)
            .title("RAW EEG")
            .build();
    eegchart.addSeries(SERIES_NAME, null, eegData);
    return eegchart;
  }
  public XYChart getMeditationchart() {
	meditationData=new ArrayList<Double>();
    meditationData.add((double)0);

    // Create Chart
    meditationchart =
        new XYChartBuilder()
            .width(500)
            .height(400)
            .theme(ChartTheme.Matlab)
            .title("Meditation")
            .build();
    meditationchart.addSeries(SERIES_NAME, null, meditationData);

    return meditationchart;
  }
    public XYChart getAttentionchart() {
	attentionData=new ArrayList<Double>();
    attentionData.add((double)0);
    // Create Chart
    attentionchart =
        new XYChartBuilder()
            .width(500)
            .height(400)
            .theme(ChartTheme.Matlab)
            .title("Attention")
            .build();
    attentionchart.addSeries(SERIES_NAME, null, attentionData);
    return attentionchart;
  }
     public XYChart getDeltachart() {
	deltaData=new ArrayList<Double>();
    deltaData.add((double)0);
    // Create Chart
    deltachart =
        new XYChartBuilder()
            .width(500)
            .height(400)
            .theme(ChartTheme.Matlab)
            .title("Delta")
            .build();
    deltachart.addSeries(SERIES_NAME, null, deltaData);
    return deltachart;
  }
         public XYChart getThetachart() {
	thetaData=new ArrayList<Double>();
    thetaData.add((double)0);
    // Create Chart
    thetachart =
        new XYChartBuilder()
            .width(500)
            .height(400)
            .theme(ChartTheme.Matlab)
            .title("Theta")
            .build();
    thetachart.addSeries(SERIES_NAME, null, thetaData);
    return thetachart;
  }
    public XYChart getLow_alphachart() {
    low_alphaData=new ArrayList<Double>();
    low_alphaData.add((double)0);
    // Create Chart
    low_alphachart =
        new XYChartBuilder()
            .width(500)
            .height(400)
            .theme(ChartTheme.Matlab)
            .title("Low_alpha")
            .build();
    low_alphachart.addSeries(SERIES_NAME, null, low_alphaData);
    return low_alphachart;
  }
                     public XYChart getHigh_alphachart() {
	high_alphaData=new ArrayList<Double>();
    high_alphaData.add((double)0);
    // Create Chart
    high_alphachart =
        new XYChartBuilder()
            .width(500)
            .height(400)
            .theme(ChartTheme.Matlab)
            .title("High_alpha")
            .build();
    high_alphachart.addSeries(SERIES_NAME, null, high_alphaData);
    return high_alphachart;
  }
    public XYChart getLow_betachart() {
    low_betaData=new ArrayList<Double>();
    low_betaData.add((double)0);
    // Create Chart
    low_betachart =
        new XYChartBuilder()
            .width(500)
            .height(400)
            .theme(ChartTheme.Matlab)
            .title("Low_beta")
            .build();
    low_betachart.addSeries(SERIES_NAME, null, low_betaData);
    return low_betachart;
  }
       public XYChart getHigh_betachart() {
    high_betaData=new ArrayList<Double>();
    high_betaData.add((double)0);
    // Create Chart
    high_betachart =
        new XYChartBuilder()
            .width(500)
            .height(400)
            .theme(ChartTheme.Matlab)
            .title("High_beta")
            .build();
    high_betachart.addSeries(SERIES_NAME, null, high_betaData);
    return high_betachart;
  }
    public XYChart getLow_gammachart() {
    low_gammaData=new ArrayList<Double>();
    low_gammaData.add((double)0);
    // Create Chart
    low_gammachart =
        new XYChartBuilder()
            .width(500)
            .height(400)
            .theme(ChartTheme.Matlab)
            .title("Low_gamma")
            .build();
    low_gammachart.addSeries(SERIES_NAME, null, low_gammaData);
    return low_gammachart;
  }
    public XYChart getMid_gammachart() {
    mid_gammaData=new ArrayList<Double>();
    mid_gammaData.add((double)0);
    // Create Chart
    mid_gammachart =
        new XYChartBuilder()
            .width(500)
            .height(400)
            .theme(ChartTheme.Matlab)
            .title("Mid_gamma")
            .build();
    mid_gammachart.addSeries(SERIES_NAME, null, mid_gammaData);
    return mid_gammachart;
  }
    public XYChart getBlinkchart() {
    blinkData=new ArrayList<Double>();
    blinkData.add((double)0);
    // Create Chart
    blinkchart =
        new XYChartBuilder()
            .width(500)
            .height(400)
            .theme(ChartTheme.Matlab)
            .title("Blink")
            .build();
    blinkchart.addSeries(SERIES_NAME, null, blinkData);
    return blinkchart;
  }
    
  public void updateeegData(int[] data) {
    // Get some new data
    List<Double> newData = new ArrayList<Double>();
for (int i : data)
{
    newData.add((double)i);
}
    eegData.addAll(newData);
    // Limit the total number of points
    while (eegData.size() > 512) {
      eegData.remove(0);
    }
    eegchart.updateXYSeries(SERIES_NAME, null, eegData, null);
	javax.swing.SwingUtilities.invokeLater(
                new Runnable() {
                  @Override
                  public void run() {					
                    swingWrapper.repaintChart(0);
                 
                  }
                });
  }
  
  public void updatemeditationData(int data) {
    // Get some new data
     // Debug.sendprintmsg("s: "+charts.size()+swingWrapper.toString());
    List<Double> newData = new ArrayList<Double>();;
    newData.add((double)data);
    meditationData.addAll(newData);
    // Limit the total number of points
    while (meditationData.size() > 20) {
      meditationData.remove(0);
    }
    meditationchart.updateXYSeries(SERIES_NAME, null, meditationData, null);
	javax.swing.SwingUtilities.invokeLater(
                new Runnable() {
                  @Override
                  public void run() {					
                    swingWrapper.repaintChart(1);
                  }
                });
  }
    public void updateattentionData(int data) {
    // Get some new data
    List<Double> newData = new ArrayList<Double>();;
    newData.add((double)data);
    attentionData.addAll(newData);
    // Limit the total number of points
    while (attentionData.size() > 20) {
      attentionData.remove(0);
    }
    attentionchart.updateXYSeries(SERIES_NAME, null, attentionData, null);
	javax.swing.SwingUtilities.invokeLater(
                new Runnable() {
                  @Override
                  public void run() {					
                    swingWrapper.repaintChart(2);
                  }
                });
  }
      public void updatedeltaData(int data) {
    // Get some new data
    List<Double> newData = new ArrayList<Double>();;
    newData.add((double)data);
    deltaData.addAll(newData);
    // Limit the total number of points
    while (deltaData.size() > 20) {
      deltaData.remove(0);
    }
    deltachart.updateXYSeries(SERIES_NAME, null, deltaData, null);
	javax.swing.SwingUtilities.invokeLater(
                new Runnable() {
                  @Override
                  public void run() {					
                    swingWrapper.repaintChart(3);
                  }
                });
  }
        public void updatethetaData(int data) {
    // Get some new data
    List<Double> newData = new ArrayList<Double>();;
    newData.add((double)data);
    thetaData.addAll(newData);
    // Limit the total number of points
    while (thetaData.size() > 20) {
      thetaData.remove(0);
    }
    thetachart.updateXYSeries(SERIES_NAME, null, thetaData, null);
	javax.swing.SwingUtilities.invokeLater(
                new Runnable() {
                  @Override
                  public void run() {					
                    swingWrapper.repaintChart(4);
                  }
                });
  }
          public void updatelow_alphaData(int data) {
    // Get some new data
    List<Double> newData = new ArrayList<Double>();;
    newData.add((double)data);
    low_alphaData.addAll(newData);
    // Limit the total number of points
    while (low_alphaData.size() > 20) {
      low_alphaData.remove(0);
    }
    low_alphachart.updateXYSeries(SERIES_NAME, null, low_alphaData, null);
	javax.swing.SwingUtilities.invokeLater(
                new Runnable() {
                  @Override
                  public void run() {					
                    swingWrapper.repaintChart(5);
                  }
                });
  }
            public void updatehigh_alphaData(int data) {
    // Get some new data
    List<Double> newData = new ArrayList<Double>();;
    newData.add((double)data);
    high_alphaData.addAll(newData);
    // Limit the total number of points
    while (high_alphaData.size() > 20) {
      high_alphaData.remove(0);
    }
    high_alphachart.updateXYSeries(SERIES_NAME, null, high_alphaData, null);
	javax.swing.SwingUtilities.invokeLater(
                new Runnable() {
                  @Override
                  public void run() {					
                    swingWrapper.repaintChart(6);
                  }
                });
  }
    public void updatelow_betaData(int data) {
    // Get some new data
    List<Double> newData = new ArrayList<Double>();;
    newData.add((double)data);
    low_betaData.addAll(newData);
    // Limit the total number of points
    while (low_betaData.size() > 20) {
      low_betaData.remove(0);
    }
    low_betachart.updateXYSeries(SERIES_NAME, null, low_betaData, null);
	javax.swing.SwingUtilities.invokeLater(
                new Runnable() {
                  @Override
                  public void run() {					
                    swingWrapper.repaintChart(7);
                  }
                });
  }
            
    public void updatehigh_betaData(int data) {
    // Get some new data
    List<Double> newData = new ArrayList<Double>();;
    newData.add((double)data);
    high_betaData.addAll(newData);
    // Limit the total number of points
    while (high_betaData.size() > 20) {
      high_betaData.remove(0);
    }
    high_betachart.updateXYSeries(SERIES_NAME, null, high_betaData, null);
	javax.swing.SwingUtilities.invokeLater(
                new Runnable() {
                  @Override
                  public void run() {					
                    swingWrapper.repaintChart(8);
                  }
                });
  }        
     public void updatelow_gammaData(int data) {
    // Get some new data
    List<Double> newData = new ArrayList<Double>();;
    newData.add((double)data);
    low_gammaData.addAll(newData);
    // Limit the total number of points
    while (low_gammaData.size() > 20) {
      low_gammaData.remove(0);
    }
    low_gammachart.updateXYSeries(SERIES_NAME, null, low_gammaData, null);
	javax.swing.SwingUtilities.invokeLater(
                new Runnable() {
                  @Override
                  public void run() {					
                    swingWrapper.repaintChart(9);
                  }
                });
  }
      public void updatemid_gammaData(int data) {
    // Get some new data
    List<Double> newData = new ArrayList<Double>();;
    newData.add((double)data);
    mid_gammaData.addAll(newData);
    // Limit the total number of points
    while (mid_gammaData.size() > 20) {
      mid_gammaData.remove(0);
    }
    mid_gammachart.updateXYSeries(SERIES_NAME, null, mid_gammaData, null);
	javax.swing.SwingUtilities.invokeLater(
                new Runnable() {
                  @Override
                  public void run() {					
                    swingWrapper.repaintChart(10);
                  }
                });
  }
       public void updateblinkData(int data) {
    // Get some new data
    List<Double> newData = new ArrayList<Double>();;
    newData.add((double)data);
    blinkData.addAll(newData);
    // Limit the total number of points
    while (blinkData.size() > 20) {
      blinkData.remove(0);
    }
    blinkchart.updateXYSeries(SERIES_NAME, null, blinkData, null);
	javax.swing.SwingUtilities.invokeLater(
                new Runnable() {
                  @Override
                  public void run() {					
                    swingWrapper.repaintChart(11);
                  }
                });
  }
  
  private List<Double> getRandomData(int numPoints) {

    List<Double> data = new CopyOnWriteArrayList<Double>();
    for (int i = 0; i < numPoints; i++) {
      data.add(Math.random() * 100);
    }
    return data;
  }
}