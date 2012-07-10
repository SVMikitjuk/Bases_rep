package binTree;

import java.awt.Color;
import java.awt.Graphics;

public class BinTreeLink implements iBinTree
{

	private final int wBall = 20;
	private final int hBall = 20;
	private final int hLevel = 50;
	
	Link root = new Link();
	
	public void add(int value)
	{
		addNode(value, root);
	}

	private void addNode(int val, Link node)
	{
		if (node.link == null)
		{
			node.link= new NodeLink(val);
			return;
		}
		if (node.link.getValue() > val)
		{
			addNode(val, node.link.left);
			
		} else
		{
			addNode(val, node.link.right);
			
		}
	}
	
	private void show()
	{
		show_priv(root);
	}
	private void show_priv(Link node)
	{

		if (node.link == null)
		{
			return;
		}

		String left;

		if (node.link.left.link == null)
		{
			left = "not";
		} else
		{
			left = String.valueOf(node.link.left.link.value);
		}

		String right;

		if (node.link.right.link == null)
		{
			right = "not";
		} else
		{
			right = String.valueOf(node.link.right.link.value);
		}
		System.out.println("Root " + node.link.value + " leftTo " + left
				+ " rightTo " + right);

		show_priv(node.link.left);
		show_priv(node.link.right);

	}
	
	public void remove(int val)
	{
		Link x = root;
		Link y = null;

		while (x.link != null)
		{

			if (x.link.getValue() == val)
			{
				break;
			} else
			{
				y = x;
				if (x.link.getValue() > val)
				{
					x = x.link.left;
				} else
				{
					x = x.link.right;
				}
			}
		}
		if (x.link == null)
		{
			return;
		}
		if (x.link.right.link == null)
		{
			if (y.link == null)
			{
				root = x.link.left;
			} else
			{
				if (x.link == y.link.left.link)
				{
					y.link.left = x.link.left;
				} else
				{
					y.link.right = x.link.left;
				}
			}
		} else
		{
			Link leftMost = x.link.right;
			y.link = null;
			while (leftMost.link.left.link != null)
			{
				y = leftMost;
				leftMost = leftMost.link.left;
			}
			if (y.link != null)
			{
				y.link.left = leftMost.link.right;
			} else
			{
				x.link.right = leftMost.link.right;
			}

			x.link.value = leftMost.link.value;
		}
	}
	public int height()
	{
		return heightTree(root);
	}

	private int heightTree(Link node)
	{
		if (node.link == null)
		{
			return 0;
		}
		return 1 + Math.max(heightTree(node.link.left), heightTree(node.link.right));
	}

	public String printInOrder()
	{
		return printInOrder(root);
	}
	public String printInOrder(Link node)
	{
		String ret = ""; 
		if (node.link != null)
		{
			ret = ret + printInOrder(node.link.left);
			ret = ret + " " + node.link.value;
			ret = ret + printInOrder(node.link.right);
		}
		return ret;
	}

	public int find(int val)
	{
		int ret = 0;
		ret = find(val, root);
		return ret;
	}
	private int find(int val, Link node)
	{
		int ret = 0;
		if (node.link == null)
		{
			ret = 0;
		} else
		{
			if (node.link.getValue() == val)
			{
				ret = node.link.getValue();
				return ret;
			} else
			{
				if (node.link.getValue() > val)
				{
					ret = find(val, node.link.left);
				} else
				{
					ret = find(val, node.link.right);
				}
			}
		}
		return ret;
	}

	public void reverse()
	{
		reverse(root);
	}
	private void reverse(Link node)
	{
		if (node.link != null) {
		    
			reverse(node.link.left);
			reverse(node.link.right);

		    
			Link temp = node.link.left;
		    node.link.left = node.link.right;
		    node.link.right = temp;
		  } 
	}

	public int getMaxWidth()
	{
		return getMaxWidth(root);
	}
	private int getMaxWidth(Link node)
	{
		int maxWdth = 0;
		int i;
		int width = 0;
		int h = heightTree(node);
		for (i = 1; i < h; i++)
		{
			width = getWidth(node, i);
			if (width > maxWdth)
			{
				maxWdth = width;
			}
		}
		return maxWdth;
	}

	int getWidth(Link node, int level)
	{
		
		int ret = 0;
		if (node.link == null)
		{
			return 0;
		}
		if (level == 1)
		{
			return 1;
		} else if (level > 1)
		{
			return getWidth(node.link.left, level - 1) + getWidth(node.link.right, level - 1);
		}
		
		ret = getWidth(node.link.right, level - 1);
		
		return ret;
		
	}

	public int getCount() 
	{
		return getCount(root);
	
	}
	
	private int getCount(Link node)
	{
		if (node.link == null)
		{
			return 0;
		} else
		{
			return (getCount(node.link.left) + 1 + getCount(node.link.right));
		}
	}

	public int getCountList()
	{
		return getCountList(root);
	}
	private int getCountList(Link node)
	{
		int ret = 0;
		if (node.link != null)
		{
			if (node.link.left.link != null && node.link.right.link != null)
			{
				ret += getCountList(node.link.left);
				ret += getCountList(node.link.right);
			} else
			{
				ret = 1;
			}
		}
		return ret;
	}

	public int getCountNode()
	{
		return getCountNode(root);
	}
	
	private int getCountNode(Link node)
	{
		int ret = 0;
		if (node.link == null)
		{
			return 0;
		} else
		{
			if (node.link.left.link != null && node.link.right.link != null)
			{
				ret = (getCountNode(node.link.left) + 1 + getCountNode(node.link.right));
			} else if (node.link.left.link != null && node.link.right.link == null)
			{
				ret = 1 + getCountNode(node.link.left);
			} else if (node.link.left.link == null && node.link.right.link != null)
			{
				ret = 1 + getCountNode(node.link.right);
			} else
			{
				ret = 0;
			}
		}
		return ret;
	}

	void Draw(Graphics g, int x_min, int x_max)
	{
		if (root.link != null)
		{
			int x = (x_max - x_min) / 2;

			g.setColor(Color.yellow);
			g.fillOval(x, 25, wBall, hBall);

			g.setColor(Color.blue);
			g.drawString(Integer.toString(root.link.value), x + 5, hLevel / 2 + 15);

			drawLeft(root.link.left, x_min, x, hLevel / 2, g);
			drawRight(root.link.right, x, x_max, hLevel / 2, g);

		}

	}
	private void drawLeft(Link node,int x1, int x2, int p_y, Graphics g)
	{
		if (node.link == null)
		{
			return;
		} 
		
		int x = x1 + (x2 - x1) / 2;
		int y = p_y + hLevel;
		
		g.setColor(Color.blue);
		g.drawLine(x2+10, p_y+20, x+10, y+10);
		
		g.setColor(Color.yellow);
		g.fillOval(x, y, wBall, hBall);

		g.setColor(Color.blue);
		g.drawString(Integer.toString(node.link.value), x+5, y+15);
		
		if (node.link != null)
		{
			drawLeft(node.link.left, x1, x, y, g);
			drawRight(node.link.right, x, x2, y, g);
		}
	}
	private void drawRight(Link node,int x1, int x2, int p_y, Graphics g)
	{
		if (node.link == null)
		{
			return;
		} 
		
		int x = x2 - (x2 - x1) / 2;
		int y = p_y + hLevel;
		
		g.setColor(Color.blue);
		g.drawLine(x1+10, p_y+20, x+10, y+10);
		
		g.setColor(Color.yellow);
		g.fillOval(x, y, wBall, hBall);

		g.setColor(Color.blue);
		g.drawString(Integer.toString(node.link.value), x+5, y+15);
		
		if (node.link != null)
		{
			drawLeft(node.link.left, x1, x, y, g);
			drawRight(node.link.right, x, x2, y, g);
		}
	}
	
	public static void main(String[] args)
	{
		BinTreeLink ff = new BinTreeLink();
		ff.add(5);
		ff.add(3);

		ff.add(10);
		ff.add(4);
//		ff.add(10);
//		ff.add(11);
//		ff.add(7);
//		ff.add(3);
		//ff.show();
//		ff.printInOrder(ff.root);
//		System.out.println(ff.height());
		ff.remove(4);
		ff.show();
//		System.out.println(ff.height());
//		ff.printInOrder(ff.root);
//		ff.find(1, ff.root);
//		ff.reverse(ff.root);
//		ff.show();
//		 System.out.println(ff.getMaxWidth(ff.root));
//		System.out.println(ff.size(ff.root));
//		System.out.println(ff.countList());
		//System.out.println(ff.countNode());
	}

}
