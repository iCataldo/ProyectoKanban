import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Este es un panel que tiene otros tres paneles, cada uno para To Do, In Process y Done.
// También tiene un panel inferior con botones para las acciones, AddTask, Move Next y Remove.
public class CentralGrid extends JPanel {
    private int i = 1;

    public CentralGrid() {

        //Panel principal
        this.setLayout(new BorderLayout());
        JPanel Panel = new JPanel();
        Panel.setLayout(new GridLayout(1, 3));

        //Paneles contenidos en Panel principal
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        panel1.setBorder(BorderFactory.createLineBorder(Color.black));
        panel2.setBorder(BorderFactory.createLineBorder(Color.black));
        panel3.setBorder(BorderFactory.createLineBorder(Color.black));
        Panel.add(panel1);
        Panel.add(panel2);
        Panel.add(panel3);

        //Listas de tareas de cada "sub-panel"
        DefaultListModel<String> model1 = new DefaultListModel<>();
        DefaultListModel<String> model2 = new DefaultListModel<>();
        DefaultListModel<String> model3 = new DefaultListModel<>();
        JList<String> list1 = new JList<String>(model1);
        JList<String> list2 = new JList<String>(model2);
        JList<String> list3 = new JList<String>(model3);
        list1.setOpaque(true);
        list1.setForeground(Color.black);
        list1.setBorder(BorderFactory.createLineBorder(Color.black));
        list2.setOpaque(true);
        list2.setForeground(Color.black);
        list2.setBorder(BorderFactory.createLineBorder(Color.black));
        list3.setOpaque(true);
        list3.setForeground(Color.black);
        list3.setBorder(BorderFactory.createLineBorder(Color.black));
        panel1.add(list1);
        panel2.add(list2);
        panel3.add(list3);

        this.add(Panel, BorderLayout.CENTER);

        //Panel de Botones
        JPanel ButtonPanel = new JPanel();

        //Botón para crear nuevas Tareas
        JButton addTaskButton = new JButton("Add Task");

        //Botón para mover tareas hacia el siguiente panel
        JButton moveNextButton = new JButton("Move Next");

        //Botón para eliminar tareas de un panel
        JButton removeButton = new JButton("Remove");

        ActionListener AddTaskActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Tasks tasks = new Tasks("Tarea " + String.valueOf(i));
                i = i + 1;
                model1.addElement(tasks.getTareatxt());
                System.out.println(tasks.getTareatxt());
            }
        };
        addTaskButton.addActionListener(AddTaskActionListener);

        ActionListener MoveNextActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String elemento1 = list1.getSelectedValue();
                if (elemento1 != null) {
                    model1.removeElement(elemento1);
                    model2.addElement(elemento1);
                }
                String elemento2 = list2.getSelectedValue();
                if (elemento2 != null) {
                    model2.removeElement(elemento2);
                    model3.addElement(elemento2);
                }
            }
        };
        moveNextButton.addActionListener(MoveNextActionListener);

        ActionListener RemoveActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String elemento1 = list1.getSelectedValue();
                String elemento2 = list2.getSelectedValue();
                String elemento3 = list3.getSelectedValue();
                if (elemento1 != null){
                model1.removeElement(elemento1);
                }
                if (elemento2 != null){
                model2.removeElement(elemento2);
                }
                if (elemento3 != null){
                model3.removeElement(elemento3);
                }
            }
        };
        removeButton.addActionListener(RemoveActionListener);

        ButtonPanel.add(addTaskButton);
        ButtonPanel.add(moveNextButton);
        ButtonPanel.add(removeButton);
        this.add(ButtonPanel, BorderLayout.SOUTH);
    }
}