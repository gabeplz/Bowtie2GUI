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
    private JLabel fileTypeLabel;




    public FileTypePanel(Context context){
        super();
        this.setContext(context);
        this.setListeners();
        this.init();

    }

    public void init() {
      //  this.setBackground(Color.GRAY);
        this.setLayout(new FlowLayout());
        this.setPreferredSize(new Dimension(200, 50));
        makeElements();
        addElements();

    }
    private void addElements() {
        this.add(fileTypeLabel);
        this.add(pairedSeparate);
        this.add(pairedSingle);
        this.add(unpaired);


    }
    private void makeElements(){
        ToolTipManager.sharedInstance().setInitialDelay(0);
        ToolTipManager.sharedInstance().setDismissDelay(50000);

        pairedSeparate = new JRadioButton("<html>1 pairedSeparate    *?*</html>");
        pairedSeparate.setSelected(true);

        pairedSeparate.setToolTipText("<html>Choose this option when the reads where generated in pairs <br />" +
                "and the first read of each pair is saved in one file and each<br />" +
                "second read in a second file<br />" +
                "Readfile_1.fastq----Readfile_2.fastq<br />" +
                "read1/1-----------------read1/2<br />" +
                "read2/1-----------------read2/2<br />" +
                "read3/1-----------------read3/2</html>");
        pairedSeparate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cont.setFileMode(1);
            }
        });


        pairedSingle = new JRadioButton("2 pairedSingle *?*");
        pairedSingle.setToolTipText("<html>Choose this option when the reads where generated in pairs <br />" +
                "and the first and second read are placed below each other in the same file.<br />" +
                "Readfile.fastq<br />" +
                "read1/1<br />" +
                "read1/2<br />" +
                "read2/1<br />" +
                "read2/2<br />" +
                "read3/1<br />" +
                "read3/2</html>");
        pairedSingle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cont.setFileMode(2);

            }
        });
        unpaired = new JRadioButton("3 unpaired *?*");
        unpaired.setToolTipText("<html>Choose this option when the reads where not generated in pairs <br />" +
                "Readfile.fastq<br />" +
                "read1<br />" +
                "read2<br />" +
                "read3</html>");

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

        fileTypeLabel = new JLabel("select the format in which the reads are distributed:");
    }

    @Override
    public void setListeners() {
        cont.addPropertyChangeListener("gff", this);
    }



}
