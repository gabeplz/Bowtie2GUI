import java.awt.event.*;
import javax.swing.*;

public class BuildingDialog extends JDialog implements ActionListener {

    JButton button;

    public BuildingDialog() {
        button = new JButton("Close");
        button.addActionListener(this);
        add(button);
        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        dispose();
    }
}
