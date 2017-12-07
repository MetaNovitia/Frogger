// FroggerFrame.java
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*
 Implements the Frogger window.
*/
public class FroggerFrame extends JFrame implements KeyListener, ActionListener
{
	public static final int DELAY = 400;  // milliseconds
    
    public static final String WORLD = "world.txt";
    
    private javax.swing.Timer myTimer;
    private FroggerComponent frogger;
    JButton new_game;
    JLabel label;
    
    int level = 1;
    int round = 0;
    
    public FroggerFrame()
    {
        setTitle("Frogger");
        Container content = getContentPane();
        content.setLayout(new BorderLayout());
        
        frogger = new FroggerComponent(WORLD);
        content.add(frogger, BorderLayout.CENTER);
        frogger.addKeyListener(this);
        frogger.setFocusable(true);
        
        JPanel panel = new JPanel();
        
        new_game = new JButton("New Game");
        panel.add(new_game);
        new_game.addActionListener(this);
        new_game.setFocusable(false);
        
        label = new JLabel("Level " + level);
        panel.add(label);
        
        content.add(panel, BorderLayout.SOUTH);
        
        myTimer = new javax.swing.Timer(DELAY, this);
        frogger.reset();
        myTimer.start();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        frogger.requestFocusInWindow();
        setVisible(true);
    }
    
    public void keyTyped(KeyEvent e)
    {
        
    }
	
    public void keyReleased(KeyEvent e)
    {
        
    }
    
    public void keyPressed(KeyEvent e)
    {
        frogger.key(e.getKeyCode());
    }
	
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource().equals(new_game))
        {
            frogger.reset();
            myTimer.setDelay((int) (DELAY));
            myTimer.start();
            level = 1;
            label.setText("Level " + level);
            frogger.requestFocusInWindow();
        }
        
        if (e.getSource().equals(myTimer))
        {
            frogger.tick(round);
            round++;
            if(frogger.isWin())
            {
                level++;
                label.setText("Level " + level);
                myTimer.setDelay((int)(DELAY*0.85));
                frogger.reset();
            }
        }
    }
    
	public static void main(String[] args) {
		FroggerFrame frame = new FroggerFrame();		
	}
}

	
