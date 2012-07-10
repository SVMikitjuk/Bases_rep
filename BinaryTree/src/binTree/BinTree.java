package binTree;

public class BinTree
{
	Node root;

	private void insert(int value)
	{
		add(value, root);
	}

	private void add(int val, Node node)
	{
		if (root == null)
		{
			root = new Node(val);
			return;
		}
		if (node.getValue() > val)
		{
			if (node.getLeft() == null)
			{
				node.left = new Node(val);
			} else
			{
				add(val, node.left);
			}
		} else
		{
			if (node.getRight() == null)
			{
				node.right = new Node(val);
			} else
			{
				add(val, node.right);
			}
		}
	}

	private void show()
	{
		show_priv(root);
	}

	private void show_priv(Node node)
	{

		if (node == null)
		{
			return;
		}

		String left;

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

		show_priv(node.left);
		show_priv(node.right);

	}

	private void remove(int val)
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

	private int height()
	{
		return height_pri(root);
	}

	private int height_pri(Node node)
	{
		if (node == null)
		{
			return 0;
		}
			
		return 1 + Math.max(height_pri(node.left), height_pri(node.right));
	}

	public void printInOrder(Node node)
	{
		if (node != null)
		{
			printInOrder(node.left);
			System.out.println("  Traversed " + node.value);
			printInOrder(node.right);
		}
	}

	private void find(int val, Node node)
	{
		if (node == null)
		{
			return;
		} else
		{
			if (node.getValue() == val)
			{
				System.out.println("  Find " + node.value);
			} else
			{
				if (node.getValue() > val)
				{
					find(val, node.left);
				} else
				{
					find(val, node.right);
				}
			}
		}
	}

	private void reverse(Node node)
	{
		Node temp;

		if (node != null)
		{
			if (node.left != null && node.right != null)
			{

				temp = node.left;
				node.left = node.right;
				node.right = temp;
				reverse(node.left);
				reverse(node.right);
			} else if (node.left != null && node.right == null)
			{
				reverse(node.left);
			} else if (node.left == null && node.right != null)
			{
				reverse(node.right);
			}
		}
	}

	int getMaxWidth(Node node)
	{
		int maxWdth = 0;
		int i;
		int width = 0;
		int h = height_pri(node);
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

	int size(Node node)
	{
		if (node == null)
		{
			return (0);
		} else
		{
			return (size(node.left) + 1 + size(node.right));
		}
	}

	int coutList(Node node)
	{
		int ret = 0;
		if (node == null)
		{
			return (0);
		} else
		{
			if (node.left != null && node.right != null)
			{
				ret += coutList(node.left);
				ret += coutList(node.right);
			} else if (node.left != null && node.right == null)
			{
				ret += coutList(node.left);
			} else if (node.left == null && node.right != null)
			{
				ret += coutList(node.right);
			} else
			{
				ret = 1;
			}
		}
		return ret;
	}

	int coutNode(Node node)
	{
		int ret = 0;
		if (node == null)
		{
			return (0);
		} else
		{
			if (node.left != null && node.right != null)
			{
				ret = (coutNode(node.left) + 1 + coutNode(node.right));
			} else if (node.left != null && node.right == null)
			{
				ret = 1 + coutNode(node.left);
			} else if (node.left == null && node.right != null)
			{
				ret = 1 + coutNode(node.right);
			} else
			{
				ret = 0;
			}
		}
		return ret;
	}

	public static void main(String[] args)
	{
		BinTree ff = new BinTree();
		ff.insert(5);
		ff.insert(1);

		ff.insert(4);
		ff.insert(2);
		ff.insert(10);
		ff.insert(11);
		ff.insert(7);
		ff.insert(3);
		ff.show();
		ff.printInOrder(ff.root);
		System.out.println(ff.height());
		ff.remove(4);
		ff.show();
		System.out.println(ff.height());
		ff.printInOrder(ff.root);
		ff.find(1, ff.root);
		ff.reverse(ff.root);
		ff.show();
		 System.out.println(ff.getMaxWidth(ff.root));
		System.out.println(ff.size(ff.root));
		System.out.println(ff.coutList(ff.root));
		System.out.println(ff.coutNode(ff.root));
	}

}
