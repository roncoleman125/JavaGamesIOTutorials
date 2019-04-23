package joptionpane;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GameFrame extends JFrame {

    public GameFrame() {

        initUI();
    }

    private void initUI() {
        add(new Board(this));

        pack();

        setTitle("Bardejov");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
        	GameFrame ex = new GameFrame();
            ex.setVisible(true);
        });
    }
}

@SuppressWarnings("serial")
class Board extends JPanel implements MouseListener {

    private Image bardejov;
    private int w, h;
    private JFrame parent;

    public Board(JFrame parent) {
        initBoard();
        
        this.parent = parent;
    }
    
    private void initBoard() {
        loadImage();
        
        w = bardejov.getWidth(this);
        h =  bardejov.getHeight(this);
        
        setPreferredSize(new Dimension(w, h));   
        
        this.addMouseListener(this);
    }
    
    private void loadImage() {
        
        ImageIcon ii = new ImageIcon("src/res/bardejov.png");
        bardejov = ii.getImage();        
    }

    @Override
    public void paintComponent(Graphics g) {
    	Graphics2D g2d = (Graphics2D)g;
        
        g2d.drawImage(bardejov, 0, 0, null);
    }

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		System.out.println("got mouse click");
		String name = JOptionPane.showInputDialog(parent, "Enter your name");
		System.out.println(name);
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
