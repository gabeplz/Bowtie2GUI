import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;

public class BottomPanel extends BasicPanel implements PropertyChangeListener {

    private JButton startButton;




    public BottomPanel(Context context){
        super();
        this.setContext(context);
        this.setListeners();
        this.init();

    }

    public void init() {
        //this.setBackground(Color.GRAY);
        this.setLayout(new FlowLayout());
        this.setPreferredSize(new Dimension(200, 50));

        addElements();

    }
    private void addElements() {
        startButton = new JButton("start mapping");



        this.add(startButton);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(NamingPanel.samName.getText());
                if(!NamingPanel.samName.getText().matches("") && !NamingPanel.indexName.getText().matches("")) {


                    if (NamingPanel.samName.getText().matches("[a-zA-Z_0-9]*") && NamingPanel.indexName.getText().matches("[a-zA-Z_0-9]*")) {
                        System.out.println("in if goed");
                        cont.collectBowtieBuildData(NamingPanel.indexName.getText(), NamingPanel.samName.getText());
                    } else {
                        JOptionPane.showMessageDialog(null, "<html>Use only letters, numbers and underscore \"_\" to make the names for the index and sam files.<br /> Its also NOT needed to write file extentions (.sam .txt) behind the names");
                    }

                } else {
                        JOptionPane.showMessageDialog(null, "<html>Please, fill in the index name and sam name. (without extentions(.sam .txt) behind the names)");
                }

            }
        });
    }




    @Override
    public void setListeners() {
        cont.addPropertyChangeListener("gff", this);
    }



}