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
                cont.collectBowtieBuildData(NamingPanel.indexName.getText(),NamingPanel.samName.getText());
            }
        });
    }




    @Override
    public void setListeners() {
        cont.addPropertyChangeListener("gff", this);
    }



}