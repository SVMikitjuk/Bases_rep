package binTree;

import java.awt.Color;
import java.awt.Graphics;

public class DrawLeftVisitor implements iVisitor
{
	private int count = 0;
	
	private final int wBall = 20;
	private final int hBall = 20;
	private final int hLevel = 50;
	
	private int x1;
	private int x2;
	private int p_y;
	private Graphics g;
	
	public DrawLeftVisitor(int x1, int x2, int p_y, Graphics g)
	{
		this.g = g;
		this.x1 = x1;
		this.x2 = x2;
		this.p_y = p_y;
	}
	@Override
	public void Visit(Node node, String str)
	{

		int x = 0, y = 0;
		
		if (str == "left")
		{
			x = x1 + (x2 - x1) / 2;
			y = p_y + hLevel;
			
		}
		else if (str == "right") 
		{
			x = x2 - (x2 - x1) / 2;
			y = p_y + hLevel;
		}
		
		g.setColor(Color.blue);
		g.drawLine(x2+10, p_y+20, x+10, y+10);
		
		g.setColor(Color.yellow);
		g.fillOval(x, y, wBall, hBall);

		g.setColor(Color.blue);
		g.drawString(Integer.toString(node.value), x+5, y+15);
		
		if (str == "left")
		{
			x2 = x;
			p_y = y;
			
		}
		else if (str == "right") 
		{
			x1 = x;
			p_y = y;
		}
		
	}
//	private void drawLeft(Node node,int x1, int x2, int p_y, Graphics g)
//	{
//		
//		int x = x1 + (x2 - x1) / 2;
//		int y = p_y + hLevel;
//		
//		g.setColor(Color.blue);
//		g.drawLine(x2+10, p_y+20, x+10, y+10);
//		
//		g.setColor(Color.yellow);
//		g.fillOval(x, y, wBall, hBall);
//
//		g.setColor(Color.blue);
//		g.drawString(Integer.toString(node.value), x+5, y+15);
//		
//		if (node.left != null)
//		{
//			drawLeft(node.left, x1, x, y, g);
//		} 
//		if (node.right !=null)
//		{
//			drawRight(node.right, x, x2, y, g);
//		}
//	}

	public int getCount()
	{
		return count;
	}
	@Override
	public void Visit(Node node)
	{
		// TODO Auto-generated method stub
		
	}
}
