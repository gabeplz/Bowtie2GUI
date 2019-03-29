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
        samLabel = new JLabel("name for the resulting SAM file of the mapping.   *?*");
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