import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeListener;

public class NamingPanel extends BasicPanel implements PropertyChangeListener {

    public static TextField indexName = new TextField();;
    public static TextField samName = new TextField();
    private JLabel indexLabel;
    private JLabel samLabel;
    private JLabel emptyLabel;




    public NamingPanel(Context context){
        super();
        this.setContext(context);
        this.setListeners();
        this.init();

    }

    public void init() {
        //this.setBackground(Color.GRAY);
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.setPreferredSize(new Dimension(200, 70));

        addElements();

    }
    private void addElements() {
        //indexName = new TextField();
       // samName = new TextField();
        //samName.setPreferredSize(new Dimension(10, 10));
        indexName.setMaximumSize(new Dimension(300, 70));
        samName.setMaximumSize(new Dimension(300, 70));

        indexLabel = new JLabel("name for the bowtie2 index.   *?*");
        indexLabel.setToolTipText("<html>the index is a collection of files bowtie2 creates with the reference sequence that allows <br />" +
                "bowtie to allign sequences faster.<br />" +
                "its recomended that the index name is based off the name of the reference sequence.<br />" +
                "this program will always build a new index and overwrite existing indexes if they have the same name.</html>");

        samLabel = new JLabel("<html>name for the resulting SAM file of the mapping.   *?*</html>");
        samLabel.setToolTipText("d");
        emptyLabel = new JLabel("");

        this.add(indexLabel);
        this.add(indexName);
        this.add(samLabel);
        this.add(samName);
    }




    @Override
    public void setListeners() {
        cont.addPropertyChangeListener("gff", this);
    }



}