import persistence.Scope;
import ui.MonitoringScreen;
import weatherMonitoringSystem.WeatherStation;

public class Main {
    public static void main(String[] args) {
        try {
            Scope.init();
            WeatherStation ws = new WeatherStation();
            MonitoringScreen ms = new MonitoringScreen(ws);
            for(;;)
            {
            }
        }
        catch (Exception e)
        {
            System.err.println("Invalid Toolkit" + e);
        }
    }
}
