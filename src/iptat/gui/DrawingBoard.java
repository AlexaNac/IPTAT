package iptat.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import iptat.util.Polygon2D;
import iptat.listeners.MouseEventListener;

public class DrawingBoard extends JPanel {
	
	private Polygon2D polygon;
	
	public DrawingBoard() {
		super.setBackground(Color.WHITE);
		
		polygon = new Polygon2D();
		super.addMouseListener(new MouseEventListener(this, polygon));
	}
	
	@Override
	protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);

		Graphics2D g2 = (Graphics2D) graphics;
		// draw with sub-pixel precision
		g2.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL,
                RenderingHints.VALUE_STROKE_PURE);
		
		polygon.draw(g2);
	}
	
	public Polygon2D getPolygon() {
		return polygon;
	}
}