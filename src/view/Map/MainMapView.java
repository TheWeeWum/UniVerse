package view.Map;

import interface_adapter.mainMap.MainMapViewModel;
import interface_adapter.temp.TempViewModel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class MainMapView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "main map";
    private final MainMapViewModel mainMapViewModel;

    final JButton button;
    private JLabel image;

    /**
     * A window with a title and a JButton.
     */
    public MainMapView(MainMapViewModel mainMapViewModel) {
        this.mainMapViewModel = mainMapViewModel;
        this.mainMapViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("Main Map View");
        JPanel buttons = new JPanel();
        JPanel images = new JPanel();

        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        String currentDir = System.getProperty("user.dir");
        String imagePath = "\\src\\view\\Map\\UofTMap.png";
        String fileName = currentDir + imagePath;
        try {
            File f = new File(fileName);
            BufferedImage myPicture = ImageIO.read(f);
            image = new JLabel(new ImageIcon(myPicture));
            images.add(image);
        } catch (IOException e) {
            System.out.println("Image not found at path name " + fileName);
        }


        button = new JButton(mainMapViewModel.TEMP_BUTTON_LABEL);
        buttons.add(button);

        button.addActionListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(buttons);
        this.add(images);
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