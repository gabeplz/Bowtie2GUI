import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class FileTypePanel extends BasicPanel implements PropertyChangeListener{

    private JRadioButton pairedSingle;
    private JRadioButton pairedSeparate;
    private JRadioButton unpaired;




    public FileTypePanel(Context context){
        super();
        this.setContext(context);
        this.setListeners();
        this.init();

    }

    public void init() {
        this.setBackground(Color.GRAY);
        this.setLayout(new FlowLayout());
        this.setPreferredSize(new Dimension(200, 50));
        makeFileBoxes();
        addElements();

    }
    private void addElements() {
        this.add(pairedSeparate);
        this.add(pairedSingle);
        this.add(unpaired);
    }
    private void makeFileBoxes(){

        pairedSeparate = new JRadioButton("1 pairedSeparate");
        pairedSeparate.setSelected(true);
        pairedSeparate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cont.setFileMode(1);
            }
        });
        pairedSingle = new JRadioButton("2 pairedSingle");
        pairedSingle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cont.setFileMode(2);

            }
        });
        unpaired = new JRadioButton("3 unpaired");
        unpaired.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cont.setFileMode(3);
            }
        });

        ButtonGroup group = new ButtonGroup();
        group.add(pairedSeparate);
        group.add(pairedSingle);
        group.add(unpaired);
    }

    @Override
    public void setListeners() {
        cont.addPropertyChangeListener("gff", this);
    }



}
