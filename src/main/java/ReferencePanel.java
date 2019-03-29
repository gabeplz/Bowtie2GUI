import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.io.File;

public class ReferencePanel extends BasicPanel implements PropertyChangeListener {
    private JScrollPane selectedFiles;
    private DefaultListModel model;
    private JList<String> selectedFilesList;
    private JButton browseButton;
    private JButton deleteButton;
    private JLabel referenceLabel;
    private TextField indexName;


    public ReferencePanel(Context context){
        super();
        this.setContext(context);
        this.setListeners();
        this.init();

    }

    public void init() {
        //this.setBackground(Color.GRAY);
       // this.setLayout(new FlowLayout());
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.setPreferredSize(new Dimension(200, 100));
        addElements();
    }

    private void addElements() {
        selectedFiles = new JScrollPane();
        model = new DefaultListModel();
        selectedFilesList = new JList(model);
        //selectedFilesList.setPreferredSize();
        selectedFilesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        selectedFiles.setViewportView(selectedFilesList);
        selectedFiles.setPreferredSize(new Dimension(400,80));
        selectedFiles.setMaximumSize(new Dimension(500,10));

        browseButton = new JButton("choose file");
        deleteButton = new JButton("Delete file");

        referenceLabel = new JLabel("dadadccccccccccccccccc   ccc");


        browseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cont.addReferencePathway();
                fillModel();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cont.deleteReferencePathway(selectedFilesList.getSelectedIndex());
                fillModel();
            }
        });

        indexName = new TextField();

        referenceLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        //i   setAlignmentX(Component.LEFT_ALIGNMENT);
        selectedFiles.setAlignmentX(Component.LEFT_ALIGNMENT);
        browseButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        deleteButton.setAlignmentX(Component.LEFT_ALIGNMENT);


        this.add(referenceLabel);
       // this.add(indexName);

        this.add(selectedFiles);
        this.add(browseButton);
        this.add(deleteButton);

    }

    public void fillModel() {
        model.removeAllElements();
        for (int i = 0; i < cont.getReferencePathways().size(); i++) {
            File file = new File(cont.getReferencePathways().get(i));

            model.addElement(file.getName());
        }
    }
    @Override
    public void setListeners() {
        cont.addPropertyChangeListener("gff", this);
    }
}
