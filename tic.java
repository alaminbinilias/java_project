import java.awt.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class tic extends JFrame {
    Container c;
    JLabel lbl;
    JPanel bpnl = new JPanel();
    GridLayout g1;
    JButton btn[][];
    String playerX = "X";
    String playerY = "O";
    String CurrentPalyer = playerX;
    int cnt=0;
    Font f1 = new Font("arial", Font.BOLD, 50);
    boolean game = false;
    JButton bt=new JButton("Reset");
    //JPanel jp=new JPanel();



    tic() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100, 100, 650, 650);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        c = this.getContentPane();
        this.setLayout(new BorderLayout());
        this.setTitle("TIC_TAC_TOE");


        lbl1();
    }

    public void lbl1() {
        lbl = new JLabel("Tic_Tac_Toe");
        lbl.setBackground(Color.darkGray);
        lbl.setForeground(Color.white);
        lbl.setHorizontalAlignment(JLabel.CENTER);
        lbl.setFont(f1);
        lbl.setOpaque(true);
        c.add(lbl);
        bt.setFocusable(false);
        c.add(lbl, BorderLayout.SOUTH);
        c.add(bt,BorderLayout.NORTH);
        bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i=0;i<3;++i){
                    for(int j=0;j<3;++j){
                        btn[i][j].setText("");
                        btn[i][j].setBackground(Color.darkGray);
                        btn[i][j].setForeground(Color.white);
                    }
                }
                cnt=0;
                game=false;
                lbl.setText("Tic_Tac_Toe");

            }
            
        });
        pnl();
    }

    public void pnl() 
    {
        g1 = new GridLayout(3, 3);
        bpnl.setLayout(g1);
        g1.setHgap(0);
        g1.setVgap(0);
        c.add(bpnl);

        btn = new JButton[3][3];
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                JButton tile = new JButton();
                btn[i][j] = tile;
                tile.setBackground(Color.darkGray);
                bpnl.add(btn[i][j]);
                tile.setBackground(Color.darkGray);
                tile.setForeground(Color.white);
                tile.setFont(f1);
                tile.setFocusable(false);
                //reset();
                // tile.setText(CurrentPalyer);


                    /*if (game != true) {
                            cnt++;
                            if (tile.getText() == "") {
                                if (CurrentPalyer == playerX) {
                                    lbl.setText(playerY + "'s turn");
                                    tile.setText(CurrentPalyer);
                                    CurrentPalyer = playerY;
                                } else {
                                    lbl.setText(playerX + "'s turn");
                                    tile.setText(CurrentPalyer);
                                    CurrentPalyer = playerX;
                                }
                            //}
                            chack();
                        }
                    }*/

                    tile.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        if(game!=true)
                        {
                            cnt++;
                            if(tile.getText()=="")
                            {
                                if(CurrentPalyer==playerX)
                                {
                                    tile.setText(CurrentPalyer);
                                    CurrentPalyer=playerY;
                                    lbl.setText(CurrentPalyer+"'S turn");
                                    //tile.setEnabled(false);
                                }
                                else{
                                    tile.setText(CurrentPalyer);
                                    CurrentPalyer=playerX;
                                    lbl.setText(CurrentPalyer+"'S Turn");
                                    //tile.setEnabled(false);
                                }
                            }
                            chack();
                            //reset();
                        }///for game false;
                        
                    }
                    });
            }
        }
    }

    public void chack()
    {
        ///horizontal

        for(int i=0;i<3;++i)
        {
            if(btn[i][0].getText()!=""&&btn[i][1].getText()!=""&&
            btn[i][2].getText()!="")
            {
                if(btn[i][0].getText()==btn[i][1].getText()&&
                btn[i][1].getText()==btn[i][2].getText())
                {
                    winner(btn[i][0]);
                    winner(btn[i][1]);
                    winner(btn[i][2]);
                    game=true;
                    return;
                }
            }
        }

        ///vartical

        for(int i=0;i<3;++i)
        {
            if(btn[0][i].getText()!=""&&btn[1][i].getText()!=""&&btn[2][i].getText()!="")
            {
                if(btn[0][i].getText()==btn[1][i].getText()&&
                btn[1][i].getText()==btn[2][i].getText())
                {
                    winner(btn[0][i]);
                    winner(btn[1][i]);
                    winner(btn[2][i]);
                    game=true;
                    return;

                }
            }
        }

        ///diagonal

        if(btn[0][0].getText()!=""&&btn[1][1].getText()!=""&&
        btn[2][2].getText()!="")
        {
            if(btn[0][0].getText()==btn[1][1].getText()&&
            btn[1][1].getText()==btn[2][2].getText())
            {
                winner(btn[0][0]);
                winner(btn[1][1]);
                winner(btn[2][2]);
                game=true;
                return;

            }
        }

        ///antidiagonal
        if(btn[0][2].getText()!=""&&btn[1][1].getText()!=""&&
        btn[2][0].getText()!="")
        {
            if(btn[0][2].getText()==btn[1][1].getText()&&
            btn[1][1].getText()==btn[2][0].getText())
            {
                winner(btn[0][2]);
                winner(btn[1][1]);
                winner(btn[2][0]);
                game=true;
                return;

            }
        } 
        
        //tie

        if(cnt==9)
        {
            for(int i=0;i<3;++i)
            {
                for(int j=0;j<3;++j)
                {
                    bk(btn[i][j]);
                }
            }
            game=true;
            return;
        }
 

    }
    void winner(JButton pp) {
        pp.setBackground(Color.darkGray);
        pp.setForeground(Color.GREEN);
        String k = pp.getText();
        lbl.setText(k + " is the Winner");

    }

    void bk(JButton pp)
    {
        pp.setForeground(Color.magenta);
        pp.setBackground(Color.GRAY);
        lbl.setText("Tie");
    }

    public void reset()
    {
        for(int i=0;i<3;++i)
        {
            for(int j=0;j<3;++j)
            {
                btn[i][j].setText("");
            }
        }
    }

    public static void main(String[] args) {
        tic fme = new tic();
        fme.setVisible(true);
        
    }
}