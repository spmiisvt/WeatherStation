package wsComponent;

import java.util.Observer;

public interface WeatherStationComponent {
    void addTempObserver(Observer o);
    void addBPObserver(Observer o);
}
