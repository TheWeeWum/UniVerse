package interface_adapter.temp;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TempViewModel extends ViewModel {
    public final String TITLE_LABEL = "Temporary View";

    private TempState state = new TempState();

    public static final String TEMP_BUTTON_LABEL = "Temp";
    private String tempUser;

    public TempViewModel() {
        super("temp");
    }

    public void setState(TempState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public TempState getState() {
        return state;
    }
}
