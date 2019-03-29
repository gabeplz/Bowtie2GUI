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

        NamingPanel namingPanel = new NamingPanel(context);
        GridBagConstraints gbcNamingPanel = new GridBagConstraints();
        gbcNamingPanel.fill = GridBagConstraints.HORIZONTAL;
        gbcNamingPanel.gridx = 0;
        gbcNamingPanel.gridy = 1;
        gbcNamingPanel.gridwidth = 2;
        //   gbcFileType.anchor = GridBagConstraints.PAGE_START;
        frame.getContentPane().add(namingPanel,gbcNamingPanel);

        ReferencePanel referencePanel = new ReferencePanel(context);
        GridBagConstraints gbcReferencePanel = new GridBagConstraints();
        gbcReferencePanel.fill = GridBagConstraints.HORIZONTAL;
        gbcReferencePanel.gridx = 0;
        gbcReferencePanel.gridy = 2;
        gbcReferencePanel.gridwidth = 2;
        //   gbcFileType.anchor = GridBagConstraints.PAGE_START;
        frame.getContentPane().add(referencePanel,gbcReferencePanel);


        FileListPanelLeft fileListPanelLeft = new FileListPanelLeft(context);
        GridBagConstraints gbcFileListPanelLeft = new GridBagConstraints();
        gbcFileListPanelLeft.gridx = 0;
        gbcFileListPanelLeft.gridy = 3;
        frame.getContentPane().add(fileListPanelLeft,gbcFileListPanelLeft);


        FileListPanelRight fileListPanelRight = new FileListPanelRight(context);
        GridBagConstraints gbcFileListPanelRight = new GridBagConstraints();
        gbcFileListPanelRight.gridx = 1;
        gbcFileListPanelRight.gridy = 3;
        gbcFileListPanelRight.weightx = 0.5;
        frame.getContentPane().add(fileListPanelRight,gbcFileListPanelRight);



        BottomPanel bottomPanel = new BottomPanel(context);
        GridBagConstraints gbcbottomPanel = new GridBagConstraints();
        gbcbottomPanel.fill = GridBagConstraints.HORIZONTAL;
        gbcbottomPanel.gridx = 0;
        gbcbottomPanel.gridy = 4;
        gbcbottomPanel.gridwidth = 2;
        frame.getContentPane().add(bottomPanel,gbcbottomPanel);
    }
    public void dialog(){}

}