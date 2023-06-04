import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.AttributedCharacterIterator;
import java.util.Map;
import java.util.concurrent.Callable;

public class TextEditor extends JFrame implements ActionListener {

    JTextArea textArea;
    JScrollPane scrollPane;
    JLabel fontLabel;
    JSpinner fontSizeSpinner;
    JButton fontColorButton;
    JComboBox fontBox;

    JMenuBar menuBar;
    JMenu fileMenu;
    JMenuItem openItem;
    JMenuItem saveItem;
    JMenuItem exitItem;




    TextEditor(){
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setTitle(" text Editor");
            this.setSize(500,500);
            this.setLayout(new FlowLayout());
            this.setLocationRelativeTo(null);
            this.setVisible(true);



            textArea = new JTextArea();
            textArea.setPreferredSize(new Dimension(450,450));
            this.add(textArea);
            this.setVisible(true);
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);
            textArea.setFont(new Font("Arial",Font.PLAIN,20));

            scrollPane = new JScrollPane(textArea);
            scrollPane.setPreferredSize(new Dimension(450,450));
            scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        JLabel fontLabel = new JLabel("Font: ");

            fontSizeSpinner = new JSpinner();
            fontSizeSpinner.setPreferredSize(new Dimension(50,25));
            fontSizeSpinner.setValue(20);
            fontSizeSpinner.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    textArea.setFont(new Font(textArea.getFont().getFamily(),Font.PLAIN,(int)fontSizeSpinner.getValue()));
                }
            });
        fontColorButton = new JButton("Color");
        fontColorButton.addActionListener(this);

        String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

        fontBox = new JComboBox(fonts);
        fontBox.addActionListener(this);
        fontBox.setSelectedItem("Arial");

        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        openItem = new JMenuItem("open");
        saveItem = new JMenuItem("open");
        exitItem = new JMenuItem("Exit");

        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);
        fileMenu.add(fileMenu);

        this.setJMenuBar(menuBar);
        this.add(fontLabel);
            this.add(fontSizeSpinner);
        this.add(fontColorButton);
        this.add(fontBox);
            this.add(scrollPane);
            this.setVisible(true);
        }


        @Override
        public void actionPerformed(ActionEvent e) {

        if(e.getSource()==fontColorButton){
            JColorChooser colorChooser = new JColorChooser();

            Component component;
            Color color = colorChooser.showDialog(null,"Choose a color",Color.BLACK);

            textArea.setForeground(color);


                }
        if(e.getSource()==fontBox){
            String String;
            textArea.setFont(new Font((String)fontBox.getSelectedItem(),Font.PLAIN,textArea.getFont().getSize()));
        }
            };
        }



















