package binTree;

import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TreeDraw
{

	class Panel extends JPanel
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		BinTreeVisitor tree;
		
		private void Init()
		{
			for (int i = 0; i < 5; i++)
			{
				//tree.add(new Random().nextInt(15));
			}
			tree.add(5);
			tree.add(2);
			tree.add(10);
			tree.add(4);
			tree.add(1);
		}
		
		public Panel()
		{
			tree = new BinTreeVisitor();
			Init();
		}
		
		public void paint(Graphics g)
		{
			super.paint(g);
			tree.Draw(g, 0, 650);
		}
	}

	public TreeDraw()
	{
		// создаем форму
		JFrame jfrm = new JFrame("MyPaint");
		jfrm.setSize(650, 450);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		jfrm.add(new Panel());

		jfrm.setVisible(true);
	}

	public static void main(String[] args)
	{
		new TreeDraw();
	}
}
