/*
 * (C) Copyright 2003-2017, by Barak Naveh and Contributors.
 *
 * JGraphT : a free Java graph-theory library
 *
 * This program and the accompanying materials are dual-licensed under
 * either
 *
 * (a) the terms of the GNU Lesser General Public License version 2.1
 * as published by the Free Software Foundation, or (at your option) any
 * later version.
 *
 * or (per the licensee's choosing)
 *
 * (b) the terms of the Eclipse Public License v1.0 as published by
 * the Eclipse Foundation.
 */

import java.awt.*;
import java.awt.geom.*;

import javax.swing.*;

import org.jgraph.*;
import org.jgraph.graph.*;
import org.jgrapht.*;
import org.jgrapht.ext.*;
import org.jgrapht.graph.*;
// resolve ambiguity
import org.jgrapht.graph.DefaultEdge;

/**
 * A demo applet that shows how to use JGraph to visualize JGraphT graphs.
 *
 * @author Barak Naveh
 * @since Aug 3, 2003
 */
public class JGraphAdapterDemo
    extends JApplet
{
    private static final long serialVersionUID = 3256444702936019250L;
    private static final Color DEFAULT_BG_COLOR = Color.decode("#FAFBFF");
    private static final Dimension DEFAULT_SIZE = new Dimension(530, 320);

    //
    private JGraphModelAdapter<String, DefaultWeightedEdge> jgAdapter;

    /**
     * An alternative starting point for this demo, to also allow running this applet as an
     * application.
     *
     * @param args ignored.
     */
    public static void main(String[] args)
    {
        JGraphAdapterDemo applet = new JGraphAdapterDemo();
        applet.init();

        JFrame frame = new JFrame();
        frame.getContentPane().add(applet);
        frame.setTitle("JGraphT Adapter to JGraph Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void init()
    {
        // create a JGraphT graph
        CitiesGraph citiesList = new CitiesGraph();


        // create a visualization using JGraph, via an adapter
        jgAdapter = new JGraphModelAdapter<>(citiesList.getGraph());

        JGraph jgraph = new JGraph(jgAdapter);

        adjustDisplaySettings(jgraph);
        getContentPane().add(jgraph);
        resize(DEFAULT_SIZE);

        citiesList.addVertex("KBH");
        citiesList.addVertex("Helsingør");
        citiesList.addVertex("Slagelse");
        citiesList.addVertex("Nyborg");
        citiesList.addVertex("Odense");
        citiesList.addVertex("Vejle");
        citiesList.addVertex("Aarhus");


        citiesList.addEdge("KBH", "Helsingør", 120);
        citiesList.addEdge("KBH", "Slagelse", 140);
        citiesList.addEdge("KBH", "Odense", 260);
        citiesList.addEdge("Helsingør", "Odense", 380);
        citiesList.addEdge("Slagelse", "Nyborg", 90);
        citiesList.addEdge("Slagelse", "Aarhus", 370);
        citiesList.addEdge("Nyborg", "Odense", 30);
        citiesList.addEdge("Nyborg", "Vejle", 90);
        citiesList.addEdge("Nyborg", "Aarhus", 280);
        citiesList.addEdge("Odense", "Vejle", 60);
        citiesList.addEdge("Vejle", "Aarhus", 190);

    }

    private void adjustDisplaySettings(JGraph jg)
    {
        jg.setPreferredSize(DEFAULT_SIZE);

        Color c = DEFAULT_BG_COLOR;
        String colorStr = null;

        try {
            colorStr = getParameter("bgcolor");
        } catch (Exception e) {
        }

        if (colorStr != null) {
            c = Color.decode(colorStr);
        }

        jg.setBackground(c);
    }
    
}

// End JGraphAdapterDemo.java
