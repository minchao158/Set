package test3;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

//测试Set接口中HashSet,TreeSet的时间复杂度
public class Set1 {
	public static void main(String[] args)
	{
		HashSet<Integer> set1=new HashSet<Integer>();
		TreeSet<Integer> set2=new TreeSet<Integer>();
		Set1 s=new Set1();
		s.set(set1);
		s.set(set2);
	}

	//返回测试的类名称
	private String getName(Set<Integer> set) 
	{
		String name="";
		if(set instanceof HashSet)	
			name="HashSet";
		else if(set instanceof TreeSet)
			name="TreeSet";
			return name;
	}
	
	//设置规模为十万到一千万，分别测试HashSet和TreeSet类插入，查找，删除的运行时间并打印输出
	public void set(Set<Integer> set)
	{	
		for(int i=100000;i<10000000;i=i+1000000)
		{
			//currentTimeMillis()为系统当前时间，单位为毫秒
			long startTime=System.currentTimeMillis();
			for(int j=0;j<i;j++)
			{
				set.add(j);				//插入数据
			}	
			long endTime=System.currentTimeMillis();
			System.out.println("插入"+i+"个数据"+getName(set)+"需要的时间为："+(endTime-startTime));
			
			long startTime2=System.currentTimeMillis();
			for(int k=0;k<i;k++)
			{
				set.contains(k);			//查找数据
			}
			long endTime2=System.currentTimeMillis();
			System.out.println("长度为"+i+"时"+getName(set)+"的查找时间为："+(endTime2-startTime2));
			
			long startTime3=System.currentTimeMillis();
			for(int l=0;l<i;l++)
			{
				set.remove(0);				//删除数据
			}
			long endTime3=System.currentTimeMillis();
			System.out.println("长度为"+i+"时"+getName(set)+"的删除时间为："+(endTime3-startTime3)+"\n");
		}
		
	}
}
