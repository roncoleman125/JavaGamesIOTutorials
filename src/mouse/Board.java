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
package mouse;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

/**
 * Board for game play.
 * @author Ron.Coleman
 */
@SuppressWarnings("serial")
public class Board extends JPanel implements ActionListener, MouseListener {
	protected Timer timer;
	protected JFrame frame;
	protected double x, y;

	/**
	 * Constructor.
	 */
	public Board(JFrame frame) {
		this.frame = frame;
        setFocusable(true);
        setBackground(Color.BLACK);
        setDoubleBuffered(true);
        this.addMouseListener(this);
        timer = new Timer(25, this);
        timer.start();
	}

	/**
	 * Renders game state.
	 * @param g Graphics context
	 */
	public void paint(Graphics g) {
		super.paint(g);
        
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.setColor(Color.GREEN);
		
		g2d.drawString("("+x+", "+y+")",100,100); 
		
        Toolkit.getDefaultToolkit().sync();
        g2d.dispose();
	}

	/**
	 * Runs timer callback.
	 * @param event Type of event
	 */
	@Override
	public void actionPerformed(ActionEvent event) {		
		// MouseInfo gives the desktop coordinates.
        double mouseX = MouseInfo.getPointerInfo().getLocation().getX();
        double mouseY = MouseInfo.getPointerInfo().getLocation().getY();
        
        // If we want the coordinates inside the frame, we have to offset the desktop coordinates.
		Point frameLocation = frame.getLocation();
		double frameX = frameLocation.getX();
		double frameY = frameLocation.getY();
		
		double frameW = this.getWidth();
		double frameH = this.getHeight();

        // Don't change x,y if outside the frame.
        if(mouseX < frameX || mouseX > frameX+frameW || mouseY < frameY || mouseY > frameY+frameH)
        	return;
        
        x = mouseX - frameX;
        y = mouseY - frameY;
        
		repaint();
	}
	
	/**
	 * Handles mouse clicks.
	 * @param event Mouse event
	 */
	@Override
	public void mouseClicked(MouseEvent event) {
		System.out.println("clicked: ("+event.getX()+", "+event.getY()+")");
	}

	/**
	 * Handles mouse panel entry.
	 * @param event Mouse event
	 */
	@Override
	public void mouseEntered(MouseEvent event) {
		System.out.println("entered: ("+event.getX()+", "+event.getY()+")");
	}

	/**
	 * Handles mouse panel exit.
	 * @param event Mouse event
	 */
	@Override
	public void mouseExited(MouseEvent event) {		
		System.out.println("exited: ("+event.getX()+", "+event.getY()+")");
	}

	/**
	 * Handles mouse button pressed.
	 * @param event Mouse event
	 */
	@Override
	public void mousePressed(MouseEvent event) {	
		if(SwingUtilities.isLeftMouseButton(event))
			System.out.println("left mouse button clicked!");
		
		else if(SwingUtilities.isRightMouseButton(event))
			System.out.println("right mouse button clicked!");
	}

	/**
	 * Handles mouse button release.
	 * @param event Mouse event
	 */
	@Override
	public void mouseReleased(MouseEvent event) {		
	}
}
