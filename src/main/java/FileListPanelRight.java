import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;

public class FileListPanelRight extends BasicPanel implements PropertyChangeListener {
    private JScrollPane selectedFiles;
    private DefaultListModel model;
    private JList<String> selectedFilesList;
    private JButton browseButton;
    private JButton moveUpButton;
    private JButton moveDownButton;
    private JButton deleteButton;
    private JLabel fileListLabel;

    public FileListPanelRight(Context context) {
        super();
        this.setContext(context);
        this.setListeners();
        this.init();

    }

    public void init() {
        //this.setBackground(Color.GRAY);
        this.setLayout(new GridBagLayout());
        this.setPreferredSize(new Dimension(380, 300));
        addElements();
    }

    private void setComponentEnabling(boolean b) {
        browseButton.setEnabled(b);
        selectedFiles.setEnabled(b);
        selectedFilesList.setEnabled(b);
        moveUpButton.setEnabled(b);
        moveDownButton.setEnabled(b);
        deleteButton.setEnabled(b);
    }

    private void addElements() {

        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.gridx = 1;
        gbc1.gridy = 1;
        gbc1.weightx = 0.5;
        gbc1.weighty = 0.01;
        gbc1.gridheight = 3;
        gbc1.gridwidth = 1;
        gbc1.fill = GridBagConstraints.BOTH;
        selectedFiles = new JScrollPane();
        model = new DefaultListModel();
        selectedFilesList = new JList(model);
        selectedFilesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        selectedFiles.setViewportView(selectedFilesList);


        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.gridx = 1;
        gbc2.gridy = 0;
        gbc2.weightx = 0.01;
        gbc2.weighty = 0.01;
        browseButton = new JButton("choose read file");


        GridBagConstraints gbc3 = new GridBagConstraints();
        gbc3.gridx = 0;
        gbc3.gridy = 1;
        gbc3.weightx = 0.5;
        gbc3.weighty = 0.01;
        moveUpButton = new JButton("move up");

        GridBagConstraints gbc4 = new GridBagConstraints();
        gbc4.gridx = 0;
        gbc4.gridy = 2;
        gbc4.weightx = 0.5;
        gbc4.weighty = 0.01;
        moveDownButton = new JButton("move down");

        GridBagConstraints gbc5 = new GridBagConstraints();
        gbc5.gridx = 0;
        gbc5.gridy = 3;
        gbc5.weightx = 0.5;
        gbc5.weighty = 0.01;
        deleteButton = new JButton("Delete");

        GridBagConstraints gbc6 = new GridBagConstraints();
        gbc6.gridx = 0;
        gbc6.gridy = 0;
        gbc6.weightx = 0.01;
        gbc6.weighty = 0.01;
        fileListLabel = new JLabel("file list 2 *?*");

        browseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cont.addReadPathway2();
                fillModel();
            }
        });

        moveUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedFilesList.getSelectedIndex() != 0){
                    System.out.println(selectedFilesList.getSelectedIndex());
                    cont.swapIndex2(selectedFilesList.getSelectedIndex(), selectedFilesList.getSelectedIndex()-1);
                    fillModel();
                }
            }
        });

        moveDownButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedFilesList.getSelectedIndex() != selectedFilesList.getModel().getSize()-1) {
                    cont.swapIndex2(selectedFilesList.getSelectedIndex(), selectedFilesList.getSelectedIndex() + 1);
                    fillModel();
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cont.deleteReadPathway1(selectedFilesList.getSelectedIndex());
                fillModel();
            }
        });

        this.add(selectedFiles, gbc1);
        this.add(browseButton, gbc2);
        this.add(moveUpButton, gbc3);
        this.add(moveDownButton, gbc4);
        this.add(deleteButton, gbc5);
        this.add(fileListLabel, gbc6);


    }

    public void fillModel() {
        model.removeAllElements();
        for (int i = 0; i < cont.getReadPathways2().size(); i++) {
            File file = new File(cont.getReadPathways2().get(i));

            model.addElement(file.getName());
        }
    }

    @Override
    public void setListeners() {
        cont.addPropertyChangeListener("pairedSeparate", this);
        cont.addPropertyChangeListener("pairedSingle", this);
        cont.addPropertyChangeListener("unPaired", this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("pairedSingle") || evt.getPropertyName().equals("unPaired")) {
            setComponentEnabling(false);
        }
        if (evt.getPropertyName().equals("pairedSeparate")) {
            setComponentEnabling(true);
        }

    }
}