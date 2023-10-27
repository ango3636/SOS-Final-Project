package sprint2.product;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class BluePlayer extends JPanel{
    private JLabel label;
    private JRadioButton humanButton, computerButton,S_button,O_button;
    private ButtonGroup playerChoice,letterChoice;
    private Font f1 = new Font("Serif Italic",Font.BOLD, 20);
    String fromThisString = "S";
    BluePlayer(){add(BuildBluePlayer());}
    public JPanel BuildLetterChoice(){
        JPanel pane = new JPanel(new GridLayout(5,1));
        S_button = new JRadioButton("S");
        S_button.setMnemonic(KeyEvent.VK_S);
        S_button.setActionCommand("S");
        S_button.setSelected(true);
        S_button.addActionListener(new BluePlayer.letterChoiceListener());

        O_button = new JRadioButton("O");
        O_button.setMnemonic(KeyEvent.VK_S);
        O_button.setActionCommand("S");
        O_button.setSelected(true);
        O_button.addActionListener(new BluePlayer.letterChoiceListener());

        letterChoice = new ButtonGroup();
        letterChoice.add(S_button);
        letterChoice.add(O_button);
        pane.add(S_button);
        pane.add(O_button);
        pane.setBackground(Color.BLUE);
        pane.setBorder(new EmptyBorder(0,6,0,0));
        return pane;
    }
    public JPanel BuildBluePlayer(){
        JPanel pane = new JPanel();
        label = new JLabel("Blue Player");
        label.setFont(f1);
        humanButton = new JRadioButton("Human");
        humanButton.setMnemonic(KeyEvent.VK_KP_UP);
        humanButton.setActionCommand("Human");
        humanButton.setSelected(true);

        computerButton = new JRadioButton("Computer");
        computerButton.setMnemonic(KeyEvent.VK_KP_DOWN);
        computerButton.setActionCommand("Computer");
        computerButton.setSelected(true);

        playerChoice = new ButtonGroup();
        playerChoice.add(humanButton);
        playerChoice.add(computerButton);

        JPanel secondaryPane = BuildLetterChoice();

        pane.add(label);
        pane.add(humanButton);
        pane.add(secondaryPane);
        pane.add(computerButton);
        pane.setLayout(new GridLayout(10,1));
        pane.setBackground(Color.BLUE);
        return pane;
    }

    private class letterChoiceListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            S_button.setActionCommand("S");
            O_button.setActionCommand("O");
            if(letterChoice.getSelection().getActionCommand() == "S"){
                fromThisString = "S";
            }
            else if (letterChoice.getSelection().getActionCommand() == "O") {
                fromThisString = "O";
            }
        }
    }
    public String getFromThisString(){
        return fromThisString;
    }
}
