import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    GridBagLayout GLayout = new GridBagLayout();
//    GridBagConstraints gbc = new GridBagConstraints();
//    GridBagConstraints gbc2 = new GridBagConstraints();
    Dimension d = new Dimension(400,600);
    JPanel RightPane = new JPanel();
    JPanel LeftPane = new JPanel();
    JPanel TopPane = new JPanel(new GridBagLayout());
    JPanel BottomPane = new JPanel(new GridBagLayout());
    Board board = new Board(6);
    GameOptions gameOptions = new GameOptions(board);
    public MainWindow() {
        // Set the title.
        setTitle("S-O-S");
        setLayout(GLayout);
        getContentPane().setBackground(new Color(50,50,50));

        setContentPane();

        // Specify an action for the close button.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(1000,600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void setContentPane(){
        GridBagConstraints gbc = new GridBagConstraints();

        JPanel bluePlay = gameOptions.BuildBluePlayer();
        JPanel redPlay = gameOptions.BuildRedPlayer();

        RightPane.add(redPlay);
        LeftPane.add(bluePlay);

        //left panel dimensions
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx= 0;
        gbc.gridy= 0;
        gbc.gridheight = 4;
        gbc.weightx= 1;
        gbc.weighty= 1;
        add(LeftPane,gbc);

        //center top panel dimensions
        setTopPane();
        gbc.gridheight = 1;
        gbc.weightx= 0;
        gbc.weighty =1;
        gbc.gridx= 1;
        TopPane.setBackground(Color.PINK);
        add(TopPane, gbc);

        //center board panel
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.gridy = -1;
        board.setMinimumSize(new Dimension(270,270));
        board.setBackground(Color.BLUE);
        add(board,gbc);

        //center bottom panel dimensions
        setBottomPane();
        gbc.weightx= 0;
        gbc.weighty = 1;
        gbc.gridy = -2;
        BottomPane.setBackground(Color.PINK);
        add(BottomPane, gbc);

        //right panel dimensions
        gbc.weightx= 1;
        gbc.weighty= 1;
        gbc.gridy = 0;
        gbc.gridx= 2;
        gbc.gridheight = 4;
        add(RightPane,gbc);
    }
    public void setBottomPane(){
        GridBagConstraints gbc = new GridBagConstraints();
        JPanel startOption = gameOptions.BuildStartOption();
        JPanel currentGame = gameOptions.CurrentGameType();
        startOption.setBackground(Color.PINK);
        currentGame.setBackground(Color.GREEN);

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
        JPanel gameType = gameOptions.BuildGameType();
        gameType.setBackground(Color.GREEN);
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