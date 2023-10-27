package sprint2.product;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

public class GameOptions extends JFrame{
    private JLabel label,gameLabel, messageLabel;
    private JRadioButton simpleButton, generalButton;;
    private ButtonGroup gameChoice;
    private Font f1 = new Font("Serif Italic",Font.BOLD, 20);
    private JButton replayButton,newGameButton;
    public JTextField size;
    public Board board;
    public JPanel redPlay,bluePlay;
    GridBagLayout GLayout = new GridBagLayout();
    JPanel TopPane = new JPanel(new GridBagLayout());
    JPanel BottomPane = new JPanel(new GridBagLayout());
    public GameOptions(Board board){
        this.board = board;
        redPlay = board.getRedPanel();
        bluePlay = board.getBluePanel();

        setTitle("S-O-S");
        setLayout(GLayout);
        getContentPane().setBackground(Color.BLACK);

        setContentPane();

        // Specify an action for the close button.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(1000,600);
        setLocationRelativeTo(null);
        setVisible(true);
        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                String newMessage = board.getGameMessage();
                messageLabel.setText(newMessage);
            }
        });
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
                if (Character.isLetter(SizeChar)) { //FIXME: isLetter not active.
                    messageLabel.setText("TRY AGAIN: Enter in an Integer");
                }
                else if((userSize <= 2) || (userSize >= 13)){
                    messageLabel.setText("TRY AGAIN: size must be between 3-12");
                }
                else{
                    messageLabel.setText("Red Player Start");
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
    public void setContentPane(){
        GridBagConstraints gbc = new GridBagConstraints();

        JPanel bluePanel = bluePlay;
        JPanel redPanel = redPlay;

        //left panel dimensions
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx= 0;
        gbc.gridy= 0;
        gbc.gridheight = 4;
        gbc.weightx= 1;
        gbc.weighty= 1;
        redPanel.setBackground(Color.RED);
        redPanel.setBorder(BorderFactory.createRaisedBevelBorder());
        add(redPanel,gbc);

        //center top panel dimensions
        setTopPane();
        gbc.gridheight = 1;
        gbc.weightx= 0;
        gbc.weighty =1;
        gbc.gridx= 1;
        TopPane.setBackground(Color.PINK);
        TopPane.setBorder(BorderFactory.createRaisedBevelBorder());
        add(TopPane, gbc);

        //center board panel
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.gridy = -1;
        board.setMinimumSize(new Dimension(270,270));
        board.setBackground(Color.BLUE);
        board.setBorder(BorderFactory.createRaisedBevelBorder());
        add(board,gbc);

        //center bottom panel dimensions
        setBottomPane();
        gbc.weightx= 0;
        gbc.weighty = 1;
        gbc.gridy = -2;
        BottomPane.setBackground(Color.PINK);
        BottomPane.setBorder(BorderFactory.createRaisedBevelBorder());

        add(BottomPane, gbc);

        //right panel dimensions
        gbc.weightx= 1;
        gbc.weighty= 1;
        gbc.gridy = 0;
        gbc.gridx= 2;
        gbc.gridheight = 4;
        bluePanel.setBackground(Color.BLUE);
        bluePanel.setBorder(BorderFactory.createRaisedBevelBorder());
        add(bluePanel,gbc);
    }
    public void setBottomPane(){
        GridBagConstraints gbc = new GridBagConstraints();
        JPanel startOption = BuildStartOption();
        JPanel currentGame = CurrentGameType();
        startOption.setBackground(Color.PINK);
        currentGame.setBackground(Color.MAGENTA);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.weightx= 1;
        gbc.weighty= 0.55;

        BottomPane.add(currentGame,gbc);
        gbc.gridx=0;
        gbc.gridy=-1;
        BottomPane.add(startOption,gbc);

    }
    public void setTopPane(){
        GridBagConstraints gbc = new GridBagConstraints();
        JPanel gameType = BuildGameType();
        gameType.setBackground(Color.MAGENTA);
        JLabel title = new JLabel("S - O - S");
        title.setFont(new Font("Serif Italic",Font.BOLD, 20));

        gbc.gridx=0;
        gbc.gridy=0;
        TopPane.add(title);
        gbc.gridx=0;
        gbc.gridy=-1;

        TopPane.add(gameType, gbc);
    }

}
