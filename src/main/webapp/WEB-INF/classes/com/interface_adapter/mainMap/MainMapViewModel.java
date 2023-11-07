package com.interface_adapter.mainMap;

import com.interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class MainMapViewModel extends ViewModel {
    public final String TITLE_LABEL = "Main Map View";

    private MainMapState state = new MainMapState();

    public static final String TEMP_BUTTON_LABEL = "Temp";
    public MainMapViewModel() {
        super("main map");
    }

    public void setState(MainMapState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public MainMapState getState() {
        return state;
    }
}
