package binTree;

import java.applet.Applet;
import java.awt.Graphics;
import java.util.Random;

public class BinTreeApplet extends Applet
{
	BinTree tree;
	private void Init()
	{
		for (int i = 0; i < 5; i++)
		{
			tree.add(new Random().nextInt(15));
		}
	}
	
	public BinTreeApplet()
	{
		tree = new BinTree();
		Init();
	}
	
	public void paint(Graphics g)
	{
		tree.Draw(g, 0, 650);
	}
}
