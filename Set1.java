package test3;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

//����Set�ӿ���HashSet,TreeSet��ʱ�临�Ӷ�
public class Set1 {
	public static void main(String[] args)
	{
		HashSet<Integer> set1=new HashSet<Integer>();
		TreeSet<Integer> set2=new TreeSet<Integer>();
		Set1 s=new Set1();
		s.set(set1);
		s.set(set2);
	}

	//���ز��Ե�������
	private String getName(Set<Integer> set) 
	{
		String name="";
		if(set instanceof HashSet)	
			name="HashSet";
		else if(set instanceof TreeSet)
			name="TreeSet";
			return name;
	}
	
	//���ù�ģΪʮ��һǧ�򣬷ֱ����HashSet��TreeSet����룬���ң�ɾ��������ʱ�䲢��ӡ���
	public void set(Set<Integer> set)
	{	
		for(int i=100000;i<10000000;i=i+1000000)
		{
			//currentTimeMillis()Ϊϵͳ��ǰʱ�䣬��λΪ����
			long startTime=System.currentTimeMillis();
			for(int j=0;j<i;j++)
			{
				set.add(j);				//��������
			}	
			long endTime=System.currentTimeMillis();
			System.out.println("����"+i+"������"+getName(set)+"��Ҫ��ʱ��Ϊ��"+(endTime-startTime));
			
			long startTime2=System.currentTimeMillis();
			for(int k=0;k<i;k++)
			{
				set.contains(k);			//��������
			}
			long endTime2=System.currentTimeMillis();
			System.out.println("����Ϊ"+i+"ʱ"+getName(set)+"�Ĳ���ʱ��Ϊ��"+(endTime2-startTime2));
			
			long startTime3=System.currentTimeMillis();
			for(int l=0;l<i;l++)
			{
				set.remove(0);				//ɾ������
			}
			long endTime3=System.currentTimeMillis();
			System.out.println("����Ϊ"+i+"ʱ"+getName(set)+"��ɾ��ʱ��Ϊ��"+(endTime3-startTime3)+"\n");
		}
		
	}
}
