package app;

import interface_adapter.temp.TempViewModel;
import view.TempView;
import view.ViewManager;
import interface_adapter.ViewManagerModel;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Build the main program window, the main panel containing the
        // various cards, and the layout, and stitch them together.

        // The main application window.
        JFrame application = new JFrame("Temp View");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();

        // The various View objects. Only one view is visible at a time.
        JPanel views = new JPanel(cardLayout);
        application.add(views);

        // This keeps track of and manages which view is currently showing.
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        // Other view models here
        // LoginViewModel loginViewModel = new LoginViewModel();
        TempViewModel tempViewModel = new TempViewModel();

        // data access objects here
        // FileUserDataAccessObject userDataAccessObject;
        // try {
        //     userDataAccessObject = new FileUserDataAccessObject("./users.csv", new CommonUserFactory());
        //     userClearDataAccessObject = new FileUserDataAccessObject("./users.csv", new CommonUserFactory());
        // } catch (IOException e) {
        //     throw new RuntimeException(e);
        // }

        // create the views
        // LoggedInView loggedInView = new LoggedInView(loggedInViewModel);
        // views.add(loggedInView, loggedInView.viewName);
        TempView tempView = new TempView(tempViewModel);
        views.add(tempView, tempView.viewName);

        // set initial view
        viewManagerModel.setActiveView(tempView.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);
    }
}