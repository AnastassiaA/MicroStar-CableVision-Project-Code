package com.microstar.dashboards;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
  
public class JTableExamples {
    // frame
    JFrame f;
    // Table
    JTable j;
    
    private JPanel mainPanel;
  
    // Constructor
    JTableExamples()
    {
        // Frame initiallization
        f = new JFrame();
        mainPanel = new JPanel();
  
        // Frame Title
        f.setTitle("JTable Example");
  
        // Data to be displayed in the JTable
        String[][] data = {
            { "Kundan Kumar Jha", "4031", "CSE" },
            { "Anand Jha", "6014", "IT" }
        };
  
        // Column Names
        String[] columnNames = { "Name", "Roll Number", "Department" };
  
        // Initializing the JTable
        j = new JTable(data, columnNames);
        j.setBounds(30, 40, 200, 300);
  
        // adding it to JScrollPane
        JScrollPane sp = new JScrollPane(j);
        mainPanel.add(sp);
        f.add(mainPanel);
        // Frame Size
        f.setSize(500, 200);
        // Frame Visible = true
        f.setVisible(true);
    }
  
    // Driver  method
    public static void main(String[] args)
    {
        new JTableExamples();
    }
}