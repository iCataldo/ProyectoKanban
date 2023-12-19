import javax.swing.*;
import java.awt.*;

//Este es un Panel que contiene 3 Labels, para To Do, In Process, Done.
public class NameGrid extends JPanel {
    public NameGrid(){
        this.setLayout(new GridLayout(1,3));

        //Primer Label para To Do
        JLabel ToDo = new JLabel();
        ToDo.setText("To Do");
        ToDo.setBorder(BorderFactory.createLineBorder(Color.black));
        ToDo.setVerticalAlignment(SwingConstants.CENTER);
        ToDo.setHorizontalAlignment(SwingConstants.CENTER);

        //Segundo Label para In Process
        JLabel InProcess = new JLabel();
        InProcess.setText("In Process");
        InProcess.setBorder(BorderFactory.createLineBorder(Color.black));
        InProcess.setVerticalAlignment(SwingConstants.CENTER);
        InProcess.setHorizontalAlignment(SwingConstants.CENTER);

        //Tercer Label para Done
        JLabel Done = new JLabel();
        Done.setText("Done");
        Done.setBorder(BorderFactory.createLineBorder(Color.black));
        Done.setVerticalAlignment(SwingConstants.CENTER);
        Done.setHorizontalAlignment(SwingConstants.CENTER);

        this.add(ToDo);
        this.add(InProcess);
        this.add(Done);

    }
}
