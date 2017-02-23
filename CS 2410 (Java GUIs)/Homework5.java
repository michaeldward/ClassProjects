import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by michael on 10/15/14.
 */
public class GUI extends JFrame implements ItemListener, ActionListener{
    private final int WIDTH = 600, LENGTH = 600;
    private int node = 0;
    private JButton yesButton, noButton, startOver;
    private JTextField outputArea;
    private JLabel questionLabel, titleLabel;


    public GUI(){
        super();
        this.setLayout(null);
        yesButton = new JButton("Yes");
        yesButton.addItemListener(this);
        noButton = new JButton("No");
        noButton.addItemListener(this);
        outputArea = new JTextField("");
        titleLabel = new JLabel("Star Wars Episode I character 20 questions.");
        questionLabel = new JLabel("Press either button to begin.");
        startOver = new JButton("Start Over");
        startOver.addActionListener(this);

        yesButton.setLocation(100, 150);
        yesButton.setSize(100, 100);
        yesButton.addActionListener(this);
        noButton.setLocation(400, 150);
        noButton.setSize(100, 100);
        noButton.addActionListener(this);
        outputArea.setLocation(200, 350);
        outputArea.setSize(200, 150);
        outputArea.setEditable(false);
        titleLabel.setLocation(0, 0);
        titleLabel.setSize(600, 100);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        questionLabel.setLocation(0, 50);
        questionLabel.setSize(600, 100);
        questionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        startOver.setLocation(250, 510);
        startOver.setSize(100, 50);
        startOver.setVisible(false);
        outputArea.setHorizontalAlignment(SwingConstants.CENTER);

        Container pane = getContentPane();
        pane.add(yesButton);
        pane.add(noButton);
        pane.add(outputArea);
        pane.add(questionLabel);
        pane.add(titleLabel);
        pane.add(startOver);

        this.setTitle("20 Questions");
        this.setVisible(true);
        this.setSize(LENGTH, WIDTH);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    @Override
    public void itemStateChanged(ItemEvent e){

    }

    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == yesButton){
            switch (node){
                case 0: node = 1; break;
                case 1: node = 2; break;
                case 2: node = 4; break;
                case 3: node = 6; break;
                case 4: node = 8; break;
                case 5: node = 10; break;
                case 6: node = 12; break;
                case 7: node = 14; break;
                default: node = 0;
            }
        } else if (e.getSource() == noButton){
            switch (node){
                case 0: node = 1; break;
                case 1: node = 3; break;
                case 2: node = 5; break;
                case 3: node = 7; break;
                case 4: node = 9; break;
                case 5: node = 11; break;
                case 6: node = 13; break;
                case 7: node = 15; break;
            }
        } else if (e.getSource() == startOver){
            node = 0;
            questionLabel.setText("Press either button to begin.");
            startOver.setVisible(false);
            yesButton.setEnabled(true);
            noButton.setEnabled(true);
            outputArea.setText("");
        }
        switch (node){
            case 1:
                questionLabel.setText("Is the character good?"); break;
            case 2:
                questionLabel.setText("Is the character a jedi?"); break;
            case 3:
                questionLabel.setText("Is the character a sith?"); break;
            case 4:
                questionLabel.setText("Does the character have a green lightsaber?"); break;
            case 5:
                questionLabel.setText("Was the character raised on the planet of Tatooine?"); break;
            case 6:
                questionLabel.setText("Does the character's lightsaber have two blades?"); break;
            case 7:
                questionLabel.setText("Does the character get killed less than a minute after appearing?"); break;
            case 8:
                done(); outputArea.setText("Qui-Gon Jinn"); break;
            case 9:
                done(); outputArea.setText("Obi-Wan Kenobi"); break;
            case 10:
                done(); outputArea.setText("Anakin Skywalker"); break;
            case 11:
                done(); outputArea.setText("Queen Amidala"); break;
            case 12:
                done(); outputArea.setText("Darth Maul"); break;
            case 13:
                done(); outputArea.setText("Darth Sidious"); break;
            case 14:
                done(); outputArea.setText("Battle Droid"); break;
            case 15:
                done(); outputArea.setText("Nute Gunray"); break;
        }
    }

    public void done(){
        questionLabel.setText("");
        startOver.setVisible(true);
        yesButton.setEnabled(false);
        noButton.setEnabled(false);
    }
    public static void main(String [] args){
        GUI gui = new GUI();
    }

}
