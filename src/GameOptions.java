import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class GameOptions{
    private JLabel label;
    JLabel gameLabel, messageLabel;
    private JRadioButton humanButton, computerButton,S_button,O_button,simpleButton, generalButton;;
    private ButtonGroup playerChoice,letterChoice,gameChoice;
    private Font f1 = new Font("Serif Italic",Font.BOLD, 20);
    private JButton replayButton,newGameButton;
    public JTextField size;
    public Board reBuild;
    public Board board;
    public GameOptions(Board board){this.board = board;}
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
        newGameButton.addActionListener(new GameOptions.newGameButtonListener());

        label = new JLabel("      BOARD SIZE --->");
        size = new JTextField("Enter an Integer");

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
        simpleButton.setSelected(true);

        generalButton = new JRadioButton("General Game");
        generalButton.setMnemonic(KeyEvent.VK_G);
        generalButton.setSelected(true);

        gameChoice = new ButtonGroup();
        gameChoice.add(simpleButton);
        gameChoice.add(generalButton);

        pane.add(label);
        pane.add(simpleButton);
        pane.add(generalButton);
        return pane;
    }
    public JPanel CurrentGameType(){
        JPanel pane = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gameLabel = new JLabel("GAME TYPE");
        messageLabel = new JLabel("");

        gbc.gridx=0;
        gbc.gridy=0;
        pane.add(gameLabel,gbc);
        gbc.gridx=0;
        gbc.gridy=-1;
        pane.add(messageLabel,gbc);
        return pane;
    }
    private class newGameButtonListener implements ActionListener {
        //when new game is pressed: board size changes, game type is displayed
        public void actionPerformed(ActionEvent e){
            int userSize = Integer.parseInt(size.getText());
            simpleButton.setActionCommand("S");
            generalButton.setActionCommand("G");
            if (e.getSource() == newGameButton) {
                //board size verification
                char SizeChar = size.getText().charAt(0);
                if (Character.isLetter(SizeChar)) {
                    messageLabel.setText("TRY AGAIN: Enter in an Integer");
                }
                else if((userSize <= 2) || (userSize >= 16)){
                    messageLabel.setText("TRY AGAIN: size must be between 3-15");
                }
                else{
                    messageLabel.setText("Blue Player Start");
                    board.newSize(userSize);

                    //choice of game type
                    if(gameChoice.getSelection().getActionCommand() == "S"){
                        gameLabel.setText("Now playing: Simple Game");
                    }
                    else if(gameChoice.getSelection().getActionCommand() == "G"){
                        gameLabel.setText("Now playing: General Game");

                    }
                }
            }
        }
    }

    public void GameStart(){

    }

}
