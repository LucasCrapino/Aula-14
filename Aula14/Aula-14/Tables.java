import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.event.*;

public class Tables extends JFrame implements ActionListener {
    private JPanel background;
    private JTable table;
    private JScrollPane bar;
    private JButton change;
    private JLabel lastChanges;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == change) {
            
        }
    }

    public Tables(ArrayList<Student> studentData) {
        super("Tabela de notas e faltas");

        lastChanges = new JLabel("Data da última atualização: ");
        lastChanges.setOpaque(true);
        lastChanges.setHorizontalAlignment(JLabel.CENTER);
        lastChanges.setVerticalAlignment(JLabel.BOTTOM);

        change = new JButton("Alterar");
        change.setFont(new Font("Arial", Font.PLAIN, 20));
        change.addActionListener(this);
        
        String[] columnNames = {"Disciplina", "P1", "P2", "Faltas"};

        
        Object[][] data = new Object[studentData.size()][4];
        for (int i = 0; i < studentData.size(); i++) {
            Student student = studentData.get(i);
            data[i][0] = student.getDiscipline();
            data[i][1] = student.getGradeOne();
            data[i][2] = student.getGradeTwo();
            data[i][3] = student.getAbsents();
        }

        
        table = new JTable(data, columnNames);
        bar = new JScrollPane(table);

        JPanel southPanel = new JPanel();
        southPanel.add(change,BorderLayout.NORTH);
        southPanel.add(lastChanges,BorderLayout.SOUTH);


        background = new JPanel();
        background.setLayout(new BorderLayout());
        background.add(bar,BorderLayout.CENTER);
        background.add(southPanel,BorderLayout.SOUTH);
        

        

        
        getContentPane().add(background);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 300);
        setVisible(true);
    }
}