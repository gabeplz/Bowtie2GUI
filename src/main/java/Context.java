import javax.swing.*;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;

public class Context implements PropertyChangeListener {

    GUI gui;
    private PropertyChangeSupport pcs = new PropertyChangeSupport(this);
    private int fileMode;
    private ArrayList<String> readPathways1 = new ArrayList<>();
    private ArrayList<String> readPathways2 = new ArrayList<>();
    private ArrayList<String> referencePathways = new ArrayList<>();


    public Context(GUI gui) {

        this.gui = gui;
        this.addPropertyChangeListener(this);
       // try{
            scrijf();
      //  } catch (IOException e){

        //}

    }

    public void scrijf(){
        //ClassLoader classLoader = getClass().getClassLoader();

       // InputStream defaultProperties = classLoader.getResourceAsStream("ikbengeschreven.txt");
        System.out.println(GUI.class.getResource("GUI.class"));
    }

    public void setFileMode(int x) {
        if (x == 1) {
            this.fileMode = x;
            pcs.firePropertyChange("pairedSeparate", null, null);
        }
        if (x == 2) {
            this.fileMode = x;
            pcs.firePropertyChange("pairedSingle", null, null);
        }
        if (x == 3) {
            this.fileMode = x;
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
            this.readPathways1.add(path);
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
            this.readPathways2.add(path);
        }
    }

    public void deleteReadPathway1(int index){
        this.readPathways1.remove(index);
    }
    public void deleteReadPathway2(int index){
        this.readPathways2.remove(index);
    }

    public void swapIndex1(int index1, int index2){
        Collections.swap(this.readPathways1, index1, index2);
    }

    public void deleteReferencePathway(int index){
        this.referencePathways.remove(index);
    }

    public ArrayList<String> getReferencePathways(){
        return this.referencePathways;
    }

    public void addReferencePathway(){
        FileChooser chooser = new FileChooser();
        String path = chooser.startChooser();
        System.out.println(path);
        if (path != "") {
            this.referencePathways.add(path);
        }
    }

    public void collectBowtieBuildData(String indexName, String samName){
        String pathdeel1 = GUI.class.getResource("GUI.class").toString();
        String pathdeel2 = pathdeel1.split("/",2 )[1];

        String pathdeel3 = pathdeel2.substring(0, pathdeel2.lastIndexOf("!"));
        //String pathdeel3 = pathdeel2.substring(0, pathdeel2.lastIndexOf("/"));

        String pathdeel4 = pathdeel3.substring(0, pathdeel3.lastIndexOf("/"));
        String pathdeel5 = ("/"+pathdeel4);
        System.out.println(pathdeel5+"kaas");


        CommandBuilder.build(pathdeel5, indexName, getReferencePathways());

        if (this.fileMode == 1 || this.fileMode == 0) {
            CommandBuilder.mapSeparate(pathdeel5, indexName, samName, getReadPathways1(), getReadPathways2());
        }
        if (this.fileMode == 2){
            CommandBuilder.mapInterleaved(pathdeel5, indexName, samName, getReadPathways1());
        }



        System.out.println("is het klaar");





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
