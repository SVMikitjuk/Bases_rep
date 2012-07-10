package binTree;

import static org.junit.Assert.*;


import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class TestBinTreeParamInFun
{
	public iBinTree tree;
	String [] actual;
	int [] actualRez;
	
	int count;
	int treeKind;
	
	@Before
	public void Init()
	{
		if (treeKind == 0)
		{
			tree = new BinTree();
		}
		else if (treeKind == 1) 
		{
			tree = new BinTreeLink();
		}
		else if (treeKind == 2) 
		{
			tree = new BinTreeVisitor();
		}
		
		if(count == 1){

			tree.add(5);
			
		}else if(count > 1){
			
			tree.add(5);
			tree.add(3);
			tree.add(10);
			tree.add(4);
		}
			
	}
	
	public TestBinTreeParamInFun(int count, int treeKind, String [] actual, int [] actualRez) {
		this.count = count;
		this.treeKind = treeKind;
		this.actual = actual;
		this.actualRez = actualRez;

		
	}
	
	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][] { 
				{ 0, 0, new String []{ " 6" , "", "", ""}, new int [] {0, 0, 0, 0, 0, 0}},
				{ 1, 0, new String []{ " 5 6" , " 5", " 5", " 5"}, new int [] {0, 0, 1, 1, 0, 1}},
				{ 4, 0, new String []{ " 3 4 5 6 10", " 3 5 10", " 3 4 5 10", " 10 5 4 3"}, new int [] {3, 2, 4, 2, 2, 3}}, 
				{ 0, 1, new String []{ " 6" , "", "", ""}, new int [] {0, 0, 0, 0, 0, 0}},
				{ 1, 1, new String []{ " 5 6" , " 5", " 5", " 5"}, new int [] {0, 0, 1, 1, 0, 1}},
				{ 4, 1, new String []{ " 3 4 5 6 10", " 3 5 10", " 3 4 5 10", " 10 5 4 3"}, new int [] {3, 2, 4, 2, 2, 3}}, 
				{ 0, 2, new String []{ " 6" , "", "", ""}, new int [] {0, 0, 0, 0, 0, 0}},
				{ 1, 2, new String []{ " 5 6" , " 5", " 5", " 5"}, new int [] {0, 0, 1, 1, 0, 1}},
				{ 4, 2, new String []{ " 3 4 5 6 10", " 3 5 10", " 3 4 5 10", " 10 5 4 3"}, new int [] {3, 2, 4, 2, 2, 3}} 
				};
		return Arrays.asList(data);
	}
	
	@Test
	public void add()
	{
		tree.add(6);
		String expected = tree.printInOrder();
		assertEquals(expected, actual[0]);
	}

	@Test
	public void del()
	{
		tree.remove(4);
		String expected = tree.printInOrder();
		assertEquals(expected, actual[1]);
	}
	
	@Test
	public void find()
	{
		int expected = tree.find(3);
		assertEquals(expected, actualRez[0]);
	}

	@Test
	public void MaxWidth()
	{
		int expected = tree.getMaxWidth();
		assertEquals(expected, actualRez[1]);
	}
	@Test
	public void size()
	{
		int expected = tree.getCount();
		assertEquals(expected, actualRez[2]);
	}
	@Test
	public void countList()
	{
		int expected = tree.getCountList();
		assertEquals(expected, actualRez[3]);
	}
	@Test
	public void countNode()
	{
		int expected = tree.getCountNode();
		assertEquals(expected, actualRez[4]);
	}

	@Test
	public void printInOrder()
	{
		String expected = tree.printInOrder();
		assertEquals(expected, actual[2]);
	}
	
	@Test
	public void height()
	{
		int expected = tree.height();
		assertEquals(expected, actualRez[5]);
	}
	@Test
	public void reverse()
	{
		tree.reverse();
		String expected = tree.printInOrder();
		assertEquals(expected, actual[3]);
	}
	
}
