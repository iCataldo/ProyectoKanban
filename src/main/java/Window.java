import javax.swing.*;
import java.awt.*;

//Crea un Frame que contiene el programa
public class Window extends JFrame{
    JFrame frame = new JFrame();

    public Window(){

        frame.setSize(700,700);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        NameGrid nameGrid = new NameGrid();
        frame.add(nameGrid, BorderLayout.NORTH);
        CentralGrid centralGrid = new CentralGrid();
        frame.add(centralGrid);
    }
}
