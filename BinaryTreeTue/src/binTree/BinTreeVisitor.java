package binTree;

import java.awt.Color;
import java.awt.Graphics;

public class BinTreeVisitor implements iBinTree
{
	private final int wBall = 20;
	private final int hBall = 20;
	private final int hLevel = 50;
	
	Node root;

	public void add(int value)
	{
		if (root == null)
		{
			root = new Node(value);
		}		
		else
		{
			addNode(value, root);
		}
	}

	private void addNode(int val, Node node)
	{
		if (node.getValue() > val)
		{
			if (node.getLeft() == null)
			{
				node.left = new Node(val);
			} else
			{
				addNode(val, node.left);
			}
		} else
		{
			if (node.getRight() == null)
			{
				node.right = new Node(val);
			} else
			{
				addNode(val, node.right);
			}
		}
	}

	public void show()
	{
		showTree(root);
	}

	private void showTree(Node node)
	{
		String left;		
		if (node == null)
		{
			return;
		}

		if (node.left == null)
		{
			left = "not";
		} else
		{
			left = String.valueOf(node.left.value);
		}

		String right;

		if (node.right == null)
		{
			right = "not";
		} else
		{
			right = String.valueOf(node.right.value);
		}
		System.out.println("Root " + node.value + " leftTo " + left
				+ " rightTo " + right);

		showTree(node.left);
		showTree(node.right);

	}

	public void remove(int val)
	{
		Node x = root;
		Node y = null;

		while (x != null)
		{

			if (x.getValue() == val)
			{
				break;
			} else
			{
				y = x;
				if (x.getValue() > val)
				{
					x = x.left;
				} else
				{
					x = x.right;
				}
			}
		}
		if (x == null)
		{
			return;
		}
		if (x.right == null)
		{
			if (y == null)
			{
				root = x.left;
			} else
			{
				if (x == y.left)
				{
					y.left = x.left;
				} else
				{
					y.right = x.left;
				}
			}
		} else
		{
			Node leftMost = x.right;
			y = null;
			while (leftMost.left != null)
			{
				y = leftMost;
				leftMost = leftMost.left;
			}
			if (y != null)
			{
				y.left = leftMost.right;
			} else
			{
				x.right = leftMost.right;
			}

			x.value = leftMost.value;
		}
	}

	public int height()
	{
		return heightTree(root);
	}

	private int heightTree(Node node)
	{
		if (node == null)
		{
			return 0;
		}
		return 1 + Math.max(heightTree(node.left), heightTree(node.right));
	}
	
	private void TraverseRVL(Node node, iVisitor v)
	{
		if(node==null)
		{
			return;
		}
		TraverseRVL(node.right, v);
		v.Visit(node);
		TraverseRVL(node.left, v);
	} 
	
	private void TraverseLVR(Node node, iVisitor v)
	{
		if(node==null)
		{
			return;
		}
		TraverseLVR(node.left, v);
		v.Visit(node);
		TraverseLVR(node.right, v);
	} 
 

	public String printInOrder()
	{
		PrintOderVisitor vis = new PrintOderVisitor();
		TraverseLVR(root, vis);
		return vis.getTreeString();
	}

	public int find(int val)
	{
		int ret = 0;
		ret = find(val, root);
		return ret;
	}
	private int find(int val, Node node)
	{
		int ret = 0;
		if (node == null)
		{
			ret = 0;
		} else
		{
			if (node.getValue() == val)
			{
				ret = node.getValue();
				return ret;
			} else
			{
				if (node.getValue() > val)
				{
					ret = find(val, node.left);
				} else
				{
					ret = find(val, node.right);
				}
			}
		}
		return ret;
	}

	public void reverse()
	{
		reverse(root);
	}
	private void reverse(Node node)
	{
		if (node != null) {
		    
			reverse(node.left);
			reverse(node.right);

		    
		    Node temp = node.left;
		    node.left = node.right;
		    node.right = temp;
		  } 
	}

	public int getMaxWidth()
	{
		return getMaxWidth(root);
	}
	int getMaxWidth(Node node)
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

	int getWidth(Node node, int level)
	{
		
		int ret = 0;
		if (node == null)
		{
			return 0;
		}
		if (level == 1)
		{
			return 1;
		} else if (level > 1)
		{
			return getWidth(node.left, level - 1) + getWidth(node.right, level - 1);
		}
		
		ret = getWidth(node.right, level - 1);
		
		return ret;
		
	}
	
	
	public int getCountNode()
	{
		CountNodeVisitor vis = new CountNodeVisitor();
		TraverseLVR(root, vis);
		return vis.getCount();
	}

	public int getCountList()
	{
		CountListVisitor vis = new CountListVisitor();
		TraverseLVR(root, vis);
		return vis.getCount();
	}

	public int getCount()
	{
		CountVisitor vis = new CountVisitor();
		TraverseLVR(root, vis);
		return vis.getCount();
	}
	
	private void TraverseVLR(Node node, iVisitor v, String str)
	{
		if(node==null)
		{
			return;
		}

		TraverseVLR(node.left, v, "left");
		v.Visit(node, str);
		TraverseVLR(node.right, v, "right");
	} 
 

	void Draw(Graphics g, int x_min, int x_max)
	{
		if (root == null)
		{
			return;
		} 
		
		int x = (x_max - x_min) / 2;
		
		g.setColor(Color.yellow);
		g.fillOval(x, 25, wBall, hBall);
		
		g.setColor(Color.blue);
		g.drawString(Integer.toString(root.value), x + 5, hLevel / 2 + 15);
		
		DrawLeftVisitor vis_left = new DrawLeftVisitor(x_min, x, 25, g);
		DrawLeftVisitor vis_right = new DrawLeftVisitor(x, x_max, 25, g);
		TraverseVLR(root.left, vis_left, "left");
		TraverseVLR(root.right, vis_right, "right");
		//return vis.getCount();
		
//		if (root.left != null)
//		{
//			drawLeft(root.left, x_min, x, hLevel / 2, g);
//		} 
//		if (root.right !=null)
//		{
//			drawRight(root.right, x, x_max, hLevel / 2, g);
//		}

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
//	private void drawRight(Node node,int x1, int x2, int p_y, Graphics g)
//	{
//		
//		int x = x2 - (x2 - x1) / 2;
//		int y = p_y + hLevel;
//		
//		g.setColor(Color.blue);
//		g.drawLine(x1+10, p_y+20, x+10, y+10);
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

	public static void main(String[] args)
	{
//		BinTreeVisitor ff = new BinTreeVisitor();
//		ff.add(5);
//		ff.add(1);
//
//		ff.add(4);
//		ff.add(2);
//		ff.add(10);
//		ff.add(11);
//		ff.add(7);
//		ff.add(3);
//		ff.show();
//		//ff.printInOrder(ff.root);
//		System.out.println(ff.height());
//		//ff.remove(4);
//		ff.show();
//		System.out.println(ff.height());
//		//ff.printInOrder(ff.root);
//		ff.find(1, ff.root);
//		ff.reverse();
//		ff.show();
//		 System.out.println(ff.getMaxWidth(ff.root));
//		//System.out.println(ff.size());
//		 
//		System.out.println(ff.getTreeString());
//		System.out.println(ff.getCount());
//		System.out.println(ff.getCountList());
//		System.out.println(ff.getCountNode());
	}

}
