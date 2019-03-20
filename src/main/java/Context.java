import java.beans.PropertyChangeEvent;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Collections;

public class Context implements PropertyChangeListener {

    GUI gui;
    private PropertyChangeSupport pcs = new PropertyChangeSupport(this);
    private int fileMode;
    ArrayList<String> readPathways1 = new ArrayList<>();
    ArrayList<String> readPathways2 = new ArrayList<>();



    public Context(GUI gui) {
        this.gui = gui;
        this.addPropertyChangeListener(this);

    }

    public void setFileMode(int x) {
        if (x == 1) {
            fileMode = x;
            pcs.firePropertyChange("pairedSeparate", null, null);
        }
        if (x == 2) {
            fileMode = x;
            pcs.firePropertyChange("pairedSingle", null, null);
        }
        if (x == 3) {
            fileMode = x;
            pcs.firePropertyChange("unPaired", null, null);
        }
    }

    public ArrayList<String> getReadPathways1(){
        return this.readPathways1;
    }

    public void addReadPathway1(){
        FileChooser chooser = new FileChooser();
        String path = chooser.startChooser();
        System.out.println(path);
        if (path != "") {
            readPathways1.add(path);
        }
    }
    public ArrayList<String> getReadPathways2(){
        return this.readPathways2;
    }

    public void addReadPathway2(){
        FileChooser chooser = new FileChooser();
        String path = chooser.startChooser();
        System.out.println(path);
        if (path != "") {
            readPathways2.add(path);
        }
    }

    public void deleteReadPathway1(int index){
        readPathways1.remove(index);
    }
    public void deleteReadPathway2(int index){
        readPathways2.remove(index);
    }

    public void swapIndex1(int index1, int index2){
        Collections.swap(readPathways1, index1, index2);
    }

    public void propertyChangeIsMandatory(){
        pcs.firePropertyChange("gff", null, null);
    }

    /**
     * encapsulatie van de property change support
     * @param listener het element dat geinformeerd wil worden
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }

    /**
     * encapsulatie van de property change support
     * @param topic het topic waarop geluisterd moet worden.
     * @param listener het element dat geinformeerd wil worden
     */
    public void addPropertyChangeListener(String topic, PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(topic, listener);
    }
    /**
     * Dit object luistert ook naar zichzelf om hulper objecten te updaten.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        String name = evt.getPropertyName();

        }



}
