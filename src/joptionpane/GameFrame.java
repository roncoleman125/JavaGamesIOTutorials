/*
 Copyright Ron Coleman

 Permission is hereby granted, free of charge, to any person obtaining
 a copy of this software and associated documentation files (the
 "Software"), to deal in the Software without restriction, including
 without limitation the rights to use, copy, modify, merge, publish,
 distribute, sublicense, and/or sell copies of the Software, and to
 permit persons to whom the Software is furnished to do so, subject to
 the following conditions:

 The above copyright notice and this permission notice shall be
 included in all copies or substantial portions of the Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
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

@SuppressWarnings("serial")
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
