import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    GridBagLayout GLayout = new GridBagLayout();
//    GridBagConstraints gbc = new GridBagConstraints();
//    GridBagConstraints gbc2 = new GridBagConstraints();
    Dimension d = new Dimension(400,600);
    JPanel MidPane = new JPanel();
    JPanel RightPane = new JPanel();
    JPanel LeftPane = new JPanel();
    JPanel CenterPane = new JPanel(new GridBagLayout());
    JPanel TopPane = new JPanel(new GridBagLayout());
    JPanel BottomPane = new JPanel(new GridBagLayout());
    Board board = new Board();
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
        JPanel startOption = gameOptions.BuildStartOption();
        startOption.setBackground(Color.DARK_GRAY);

        MidPane.add(new JLabel("test"));
        RightPane.add(redPlay);
        LeftPane.add(bluePlay);
        BottomPane.add(startOption);

        setTopPane();

        //left panel dimensions
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx= 0;
        gbc.gridy= 0;
        gbc.gridheight = 4;
        gbc.weightx= 1;
        gbc.weighty= 1;
        add(LeftPane,gbc);

        //center top panel dimensions
        gbc.gridheight = 1;
        gbc.weightx= 0;
        gbc.weighty =1;
        gbc.gridx= 1;
        TopPane.setBackground(Color.CYAN);
        add(TopPane, gbc);

        //center board panel
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.gridy = -1;
        board.setMinimumSize(new Dimension(270,270));
        board.setBackground(Color.BLUE);
        add(board,gbc);

        //center bottom panel dimensions
        gbc.weightx= 0;
        gbc.weighty = 1;
        gbc.gridy = -2;
        BottomPane.setBackground(Color.MAGENTA);
        add(BottomPane, gbc);

        //right panel dimensions
        gbc.weightx= 1;
        gbc.weighty= 1;
        gbc.gridy = 0;
        gbc.gridx= 2;
        gbc.gridheight = 4;
        add(RightPane,gbc);
    }
    public void setTopPane(){
        GridBagConstraints gbc = new GridBagConstraints();
        JPanel gameType = gameOptions.BuildGameType();

        gbc.gridx=0;
        gbc.gridy=0;
        TopPane.add(new JLabel("S - O - S"));
        gbc.gridx=0;
        gbc.gridy=-1;

        TopPane.add(gameType, gbc);
    }
}