import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class GameOptions {
    private JLabel label;
    private JRadioButton humanButton, computerButton,S_button,O_button,simpleButton, generalButton;;
    private ButtonGroup playerChoice,letterChoice,gameChoice;
    private Font f1 = new Font("Serif Bold Italic",Font.BOLD, 20);
    private JButton replayButton,newGameButton;
    public JTextField size;

    public JPanel BuildLetterChoice(){
        JPanel pane = new JPanel(new GridLayout(5,1));
        S_button = new JRadioButton("S");
        S_button.setMnemonic(KeyEvent.VK_S);
        S_button.setActionCommand("S");
        S_button.setSelected(true);

        O_button = new JRadioButton("O");
        O_button.setMnemonic(KeyEvent.VK_S);
        O_button.setActionCommand("S");
        O_button.setSelected(true);

        letterChoice = new ButtonGroup();
        letterChoice.add(S_button);
        letterChoice.add(O_button);
        pane.add(S_button);
        pane.add(O_button);
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
        return pane;
    }
    public JPanel BuildRedPlayer(){
        JPanel pane = new JPanel();
        label = new JLabel("Red Player");
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
        return pane;
    }
    public JPanel BuildStartOption(){
        GridLayout gridLayout = new GridLayout(2,2);
        JPanel pane = new JPanel(gridLayout);
        replayButton = new JButton("Replay");

        newGameButton = new JButton("New Game");

        label = new JLabel("      BOARD SIZE --->");
        size = new JTextField("Enter A Integer");

        pane.add(label);
        pane.add(size);
        pane.add(replayButton);
        pane.add(newGameButton);
        return pane;
    }
    public JPanel BuildGameType(){
        JPanel pane = new JPanel();
        label = new JLabel("SOS");
        simpleButton = new JRadioButton("Simple Game");
        simpleButton.setMnemonic(KeyEvent.VK_S);
        simpleButton.setActionCommand("Simple Game");
        simpleButton.setSelected(true);

        generalButton = new JRadioButton("General Game");
        generalButton.setMnemonic(KeyEvent.VK_G);
        generalButton.setActionCommand("General Game");
        generalButton.setSelected(true);

        gameChoice = new ButtonGroup();
        gameChoice.add(simpleButton);
        gameChoice.add(generalButton);

        pane.add(label);
        pane.add(simpleButton);
        pane.add(generalButton);
        return pane;
    }



}
