package nowcoder;

import java.util.Scanner;
import java.awt.List;
import java.math.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

class DataNode
{
	int index;//数组的标号
	int arr[];
	double dis;
	
	public DataNode(int index,int a[])
	{
		this.index = index;
		arr = a;
	}
}

class DisComparator implements Comparator
{
	public  int compare(Object obj1,Object obj2)
	{
		DataNode d1 = (DataNode)obj1;
		DataNode d2 = (DataNode)obj2;
		return new Double(d1.dis).compareTo(d2.dis);
	}
}

public class Distance {
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext())
		{
			int n = sc.nextInt();
			int k = sc.nextInt();
			DataNode dn[] = new DataNode[n];
			for(int i=0;i<n;i++)
			{
				int a[] = new int[k];
				for(int j=0;j<k;j++)
				{
					a[j] = sc.nextInt();
				}
				dn[i] = new DataNode(i,a);
			}
			
			int queryNum = sc.nextInt();//问题个数
			for(int i=0;i<queryNum;i++)
			{
				int arr[] = new int[k];//目标向量
				for(int j=0;j<k;j++)//输入目标向量
				{
					arr[j] = sc.nextInt();
				}
				int num = sc.nextInt();//找最近的几个数
				for(int j=0;j<n;j++)
				{
					dn[j].dis = distance(dn[j].arr,arr);
				}
//				QuickSort(dn,0,dn.length-1);//按照类中的距离排序
				ArrayList<DataNode> list = new ArrayList<DataNode>();
				list = new ArrayList(Arrays.asList(dn));
				
				Comparator comp=new DisComparator();//创建比较器的对象
				Collections.sort(list,comp);//
				System.out.println("the closest "+num+" points are:");
				for(int j=0;j<num;j++)
				{
					for(int nm=0;nm<k-1;nm++)
					{
						System.out.print(list.get(j).arr[nm]+" ");
					}
					System.out.println(list.get(j).arr[k-1]);
				}
			}
		}
	}
	
	public static double distance(int a[],int b[])
	{
		double dis = 0;
		for(int i=0;i<a.length;i++)
		{
			dis +=(a[i]-b[i])*(a[i]-b[i]);
		}
		return Math.sqrt(dis); 
	}
	
	
	
	public static void QuickSort(DataNode da[],int left,int right)
	{
		if(left>=right)
			return ;
		int i = left;
		int j = right;
		DataNode key = da[i]; 
		
		while(i<j)
		{
			for(;i<j&&key.dis<da[j].dis;j--);
			da[i] = da[j];
			for(;i<j&&key.dis>=da[i].dis;i++);
			da[j]=da[i];
		}
		da[i] = key;
		
		QuickSort(da,left,i-1);
		QuickSort(da,i+1,right);
	}
}
