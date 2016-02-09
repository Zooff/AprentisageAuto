package graphicalInterface;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Drawing extends JPanel implements MouseListener, MouseMotionListener{
	
	private int x1, x2, y1, y2 = -1;
	
	private BufferedImage img;
	private Graphics2D g2;
	
	public Drawing(){
		super();
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		
		reset();
	}
	
	public void reset(){
		x1 = x2 = y1 = y2 = -1;
		img = newDraw();
		repaint();
	}
	
	public BufferedImage getImg(){
		return img;
	}
	
	public BufferedImage newDraw(){
		img = new BufferedImage(200, 150, BufferedImage.TYPE_INT_ARGB);
		g2 = img.createGraphics();
		g2.setBackground(Color.WHITE);
		g2.setColor(Color.BLACK);
		g2.setStroke(new BasicStroke(4));
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		return img;
	}
	
	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (x1 != -1 && y1 != -1 && x2 != -1 && y2 != -1) {
            g2.drawLine(x1, y1, x2, y2);
        }

        g.drawImage(img, 0, 0, g2.getBackground(), this);
    }
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		x2 = x1;
		y2 = y1;
		x1 = e.getX();
		y1 = e.getY();
		
		repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		x1 = e.getX();
		y1 = e.getY();
		x2 = x1;
		y2 = y1;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		x2 = e.getX();
		y2 = e.getY();
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		x1 = e.getX();
		y1 = e.getY();
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
