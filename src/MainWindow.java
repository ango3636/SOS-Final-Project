import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    GridBagLayout GLayout = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();
    Dimension d = new Dimension(400,600);
    JPanel MidPane = new JPanel();
    JPanel RightPane = new JPanel();
    JPanel LeftPane = new JPanel();
    JPanel TopPane = new JPanel();
    JPanel BottomPane = new JPanel(new GridBagLayout());
    JPanel blank = new JPanel();
    public MainWindow() {
        // Set the title.
        setTitle("S-O-S");
        setLayout(GLayout);
        getContentPane().setBackground(new Color(50,50,50));

        // Specify an action for the close button.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GameOptions gameOptions = new GameOptions();
        Board board = new Board();
        JPanel bluePlay = gameOptions.BuildBluePlayer();
        JPanel redPlay = gameOptions.BuildRedPlayer();
        JPanel startOption = gameOptions.BuildStartOption();
        JPanel gameType = gameOptions.BuildGameType();
        startOption.setBackground(Color.DARK_GRAY);

        MidPane.add(new JLabel("test"));
        RightPane.add(redPlay);
        LeftPane.add(bluePlay);

//        startOption.setPreferredSize(new Dimension(300,50));
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.gridheight = 4;
        BottomPane.add(startOption,gbc);
        gbc.gridy =-1;
        gbc.anchor = GridBagConstraints.PAGE_END;
        BottomPane.add(gameType,gbc);

        //left panel dimensions
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx= 0;
        gbc.gridy= 0;
        gbc.gridheight = 4;
        gbc.weightx= 0.4;
        gbc.weighty= 1;
        add(LeftPane,gbc);

        //center top panel dimensions
        gbc.gridheight = 1;
        gbc.weightx= 0;
        gbc.weighty =0.10;
        gbc.gridx= 1;
        TopPane.add(new JLabel("S - O - S"));
        TopPane.setBackground(Color.CYAN);
        add(TopPane, gbc);

        //board dimensions
        gbc.weightx = 0.2;
        gbc.weighty = 0.5;
        gbc.gridy = -1;
        board.setPreferredSize(new Dimension(250,250));
        board.setBackground(Color.BLUE);
        add(board,gbc);

        //center bottom panel dimensions
        gbc.weightx= 0;
        gbc.weighty = 0.25;
        gbc.gridy = -2;
        BottomPane.setBackground(Color.MAGENTA);
        add(BottomPane, gbc);

        //right panel dimensions
        gbc.weightx= 0.4;
        gbc.weighty= 1;
        gbc.gridy = 0;
        gbc.gridx= 2;
        gbc.gridheight = 4;
        add(RightPane,gbc);

        setSize(1000,600);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}