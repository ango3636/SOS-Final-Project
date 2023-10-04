import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GameBoard implements ActionListener {
    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JLabel text = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean playerTurn;
    JPanel board = new Board();

    GameBoard(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(683,800);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());

        text.setBackground(new Color(25,25,25));
        text.setForeground(new Color(25,255,0));
        text.setFont(new Font("Ink Free", Font.BOLD,75));
        text.setHorizontalAlignment(JLabel.CENTER);
        text.setText("SOS");
        text.setOpaque(true);

        panel.setLayout(new BorderLayout());
        panel.setBounds(0,0,800,100);

        buttonPanel.setLayout(new GridLayout(3,3));
        buttonPanel.setBackground(new Color(150,150,150));

        for (int i = 0; i<9 ; i++){
            buttons[i] = new JButton();
            buttonPanel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }
        panel.add(text);

        frame.add(panel,BorderLayout.NORTH);
//        frame.add(buttonPanel);
        frame.add(board);

        frame.setVisible(true);
        System.out.println(board.getHeight());
        FirstTurn();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i<9; i++){
            if (e.getSource()==buttons[i]){
                if (playerTurn){
                    if (buttons[i].getText()==""){
                        buttons[i].setForeground(new Color(255,0,0));
                        buttons[i].setText("S");
                        playerTurn = false;
                        text.setText("Player 2's Turn");
                        check();
                    }
                }
                else{
                    if (buttons[i].getText()==""){
                        buttons[i].setForeground(new Color(0,0,255));
                        buttons[i].setText("S");
                        playerTurn = true;
                        text.setText("Player 1's Turn");
                        check();
                    }
                }
            }
        }
    }

    public void FirstTurn(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        if (random.nextInt(2) == 0){
            playerTurn = true;
            text.setText("Player 1's Turn");
        }
        else {
            playerTurn = false;
            text.setText("Player 2's Turn");
        }
    }

    public void check(){

    }

    public void Player1Wins(int a, int b, int c){

    }

    public void Player2Wins(int a, int b, int c){

    }
}
