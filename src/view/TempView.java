package view;

import interface_adapter.temp.TempViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class TempView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "temp";
    private final TempViewModel tempViewModel;

    JLabel temp;

    final JButton button;

    /**
     * A window with a title and a JButton.
     */
    public TempView(TempViewModel tempViewModel) {
        this.tempViewModel = tempViewModel;
        this.tempViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("Temporary Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel usernameInfo = new JLabel("Temp: ");
        temp = new JLabel();

        JPanel buttons = new JPanel();
        button = new JButton(tempViewModel.TEMP_BUTTON_LABEL);
        buttons.add(button);

        button.addActionListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(buttons);
    }

    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}