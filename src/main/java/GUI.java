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
        System.out.println(GUI.class.getResource("GUI.class"));


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

        ReferencePanel referencePanel = new ReferencePanel(context);
        GridBagConstraints gbcReferencePanel = new GridBagConstraints();
        gbcReferencePanel.fill = GridBagConstraints.HORIZONTAL;
        gbcReferencePanel.gridx = 0;
        gbcReferencePanel.gridy = 1;
        gbcReferencePanel.gridwidth = 2;
        //   gbcFileType.anchor = GridBagConstraints.PAGE_START;
        frame.getContentPane().add(referencePanel,gbcReferencePanel);


        FileListPanelLeft fileListPanelLeft = new FileListPanelLeft(context);
        GridBagConstraints gbcFileListPanelLeft = new GridBagConstraints();
        gbcFileListPanelLeft.gridx = 0;
        gbcFileListPanelLeft.gridy = 2;
        frame.getContentPane().add(fileListPanelLeft,gbcFileListPanelLeft);


        FileListPanelRight fileListPanelRight = new FileListPanelRight(context);
        GridBagConstraints gbcFileListPanelRight = new GridBagConstraints();
        gbcFileListPanelRight.gridx = 1;
        gbcFileListPanelRight.gridy = 2;
        gbcFileListPanelRight.weightx = 0.5;
        frame.getContentPane().add(fileListPanelRight,gbcFileListPanelRight);



        FileTypePanel fileTypePanel3 = new FileTypePanel(context);
        GridBagConstraints gbcFileType3 = new GridBagConstraints();
        gbcFileType3.fill = GridBagConstraints.HORIZONTAL;
        gbcFileType3.gridx = 0;
        gbcFileType3.gridy = 3;
        gbcFileType3.gridwidth = 2;
        frame.getContentPane().add(fileTypePanel3,gbcFileType3);
    }
}