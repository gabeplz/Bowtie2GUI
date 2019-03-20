import javax.swing.*;
import java.awt.*;

public class GUI {
    private JFrame frame;
    private Context context;
    //public OrganismPanel organism;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GUI window = new GUI();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    /**
     * Create the application.
     */
    public GUI() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 900, 710);
        frame.setMinimumSize(new Dimension(900, 710));
        frame.setBounds(100, 100, 760, 480);
        frame.setMinimumSize(new Dimension(760, 480));

        context = new Context(this);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        GridBagLayout gridBagLayout = new GridBagLayout();

        gridBagLayout.columnWidths = new int[]{0, 0};
        gridBagLayout.rowHeights = new int[]{0, 0};
        gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        //gridBagLayout.rowWeights = new double[]{0.0, 0.00001};
        frame.getContentPane().setLayout(gridBagLayout);



        FileTypePanel fileTypePanel = new FileTypePanel(context);

        GridBagConstraints gbcFileType = new GridBagConstraints();
        gbcFileType.fill = GridBagConstraints.HORIZONTAL;
        gbcFileType.gridx = 0;
        gbcFileType.gridy = 0;
        gbcFileType.gridwidth = 2;
     //   gbcFileType.anchor = GridBagConstraints.PAGE_START;


        frame.getContentPane().add(fileTypePanel,gbcFileType);


        FileListPanelLeft fileListPanelLeft = new FileListPanelLeft(context);
        GridBagConstraints gbcFileListPanelLeft = new GridBagConstraints();

        gbcFileListPanelLeft.gridx = 0;
        gbcFileListPanelLeft.gridy = 1;

        frame.getContentPane().add(fileListPanelLeft,gbcFileListPanelLeft);


        FileListPanelRight fileListPanelRight = new FileListPanelRight(context);
        GridBagConstraints gbcFileListPanelRight = new GridBagConstraints();

        gbcFileListPanelRight.gridx = 1;
        gbcFileListPanelRight.gridy = 1;
        gbcFileListPanelRight.weightx = 0.5;
        frame.getContentPane().add(fileListPanelRight,gbcFileListPanelRight);


        FileTypePanel fileTypePanel2 = new FileTypePanel(context);

        GridBagConstraints gbcFileType2 = new GridBagConstraints();
        gbcFileType2.fill = GridBagConstraints.HORIZONTAL;
        gbcFileType2.gridx = 0;
        gbcFileType2.gridy = 2;
        gbcFileType2.gridwidth = 2;



        frame.getContentPane().add(fileTypePanel2,gbcFileType2);
    }
}