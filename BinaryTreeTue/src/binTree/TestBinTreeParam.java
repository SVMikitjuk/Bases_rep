package binTree;

import static org.junit.Assert.*;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class TestBinTreeParam
{
	public BinTree tree;
	String [] actual;
	int [] actualRez;
	
	int count;
	
	public void Init()
	{
		tree = new BinTree();
		
		if(count == 1){

			tree.add(5);
			
		}else if(count > 1){
			
			tree.add(5);
			tree.add(3);
			tree.add(10);
			tree.add(4);
		}
			
	}
	
	public TestBinTreeParam(int count, String [] actual, int [] actualRez) {
		this.count = count;
		this.actual = actual;
		this.actualRez = actualRez;

		
	}
	
	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][] { 
				{ 0, new String []{ " 6" , "", "", ""}, new int [] {0, 0, 0, 0, 0, 0}},
				{ 1, new String []{ " 5 6" , " 5", " 5", " 5"}, new int [] {0, 0, 1, 1, 0, 1}},
				{ 4, new String []{ " 3 4 5 6 10", " 4 5 10", " 3 4 5 10", " 10 5 4 3"}, new int [] {3, 2, 4, 2, 2, 3}} 
				};
		return Arrays.asList(data);
	}
	
	@Test
	public void add()
	{
		Init();
		tree.add(6);
		String expected = tree.printInOrder();
		assertEquals(expected, actual[0]);
	}

	@Test
	public void del()
	{
		Init();
		tree.remove(3);
		String expected = tree.printInOrder();
		assertEquals(expected, actual[1]);
	}
	
	@Test
	public void find()
	{
		Init();
		int expected = tree.find(3);
		assertEquals(expected, actualRez[0]);
	}

	@Test
	public void MaxWidth()
	{
		Init();
		int expected = tree.getMaxWidth();
		assertEquals(expected, actualRez[1]);
	}
	@Test
	public void size()
	{
		Init();
		int expected = tree.size();
		assertEquals(expected, actualRez[2]);
	}
	@Test
	public void countList()
	{
		Init();
		int expected = tree.countList();
		assertEquals(expected, actualRez[3]);
	}
	@Test
	public void countNode()
	{
		Init();
		int expected = tree.countNode();
		assertEquals(expected, actualRez[4]);
	}

	@Test
	public void printInOrder()
	{
		Init();
		String expected = tree.printInOrder();
		assertEquals(expected, actual[2]);
	}
	
	@Test
	public void height()
	{
		Init();
		int expected = tree.height();
		assertEquals(expected, actualRez[5]);
	}
	@Test
	public void reverse()
	{
		Init();
		tree.reverse();
		String expected = tree.printInOrder();
		assertEquals(expected, actual[3]);
	}
	
}
