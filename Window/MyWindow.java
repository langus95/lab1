package Window;

import Connect.Source;
import Reader.AbstractReader;
import Reader.ReadFromFile;
import Reader.ReadFromWeb;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.File;
import javafx.stage.FileChooser;
import javax.swing.JTextArea;

public class MyWindow extends JFrame implements ActionListener
{
    JLabel label1;
    JTextField text;
    JTextArea done;
    JButton bBrowse, bDownload, bClear;
    
    public MyWindow()
    {
        setSize(600,500);
        setTitle("Parser - Arkadiusz Lange");
        setLocationRelativeTo(null);
        setLayout(null);
        
        label1 = new JLabel("Wprowadz adres strony lub wybierz plik");
        label1.setBounds(50,50,450,20);
        add(label1);
        
        text = new JTextField("");
        text.setBounds(50,80,450,20);
        add(text);
        
        bBrowse = new JButton("...");
        bBrowse.setBounds(510,80,30,20);
        bBrowse.addActionListener(this);
        add(bBrowse);
        
        bDownload = new JButton("Czytaj");
        bDownload.setBounds(350,110,150,20);
        bDownload.addActionListener(this);
        add(bDownload);
        
        done = new JTextArea("");
        done.setBounds(50,140,450,250);
        done.disable();
        add(done);
        
        bClear = new JButton("Wyczyść");
        bClear.setBounds(350,400,150,20);
        bClear.addActionListener(this);
        add(bClear);
    }
    
    public static void main(String[] args) {
        MyWindow window = new MyWindow();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        window.setResizable(false);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

		if(source == bDownload){
                    Source sc = new Source(text.getText());
                    AbstractReader d = null;
                    StringBuilder b = new StringBuilder();

                    if(sc.isValidLink()) d = new ReadFromWeb(sc.getSource());
                    else if(sc.isValidDiskFile()) d = new ReadFromFile(sc.getSource());

                    if(d != null) {
                    d.loadSource();

                    ArrayList<String> s = d.returnSource();

                    s.stream().forEach((x) -> {
                        b.append(x).append("\n");
                    });

            done.setText(b.toString());
            }   
                }

		else if(source == bBrowse){
			FileChooser c = new FileChooser();
                        c.setTitle("Wybierz plik...");
                        c.getExtensionFilters().add(new FileChooser.ExtensionFilter("Plik (*.html)", "*.html"));
                        File f = c.showOpenDialog(null);

                        if (f != null)
                        text.setText(f.toString());
                }
		else if(source == bClear){
			text.setText("");
                        done.setText("");
                }
    }

}