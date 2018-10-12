import java.io.*;
import java.util.*;


public class CProgramizer {

	public static void main(String[] args) throws Exception{
	
		int cp=0,cb=0;
		boolean f =false;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br2 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(br.readLine()))));
		String st;
		while((st=br2.readLine())!=null)
		{
			if(st.equals("#include")||st.contains("#include"))
			f=true;
			if(f)
			{
				if(st.contains("{"))
				cb++;
				if(st.contains("("))
				cp++;
				if(st.contains(")"))
				cp--;
				if(st.contains("}"))
				cb--;
				if(st.equals("<stdio.h>")||st.equals("{")||st.equals("}")||st.equals("*/")||(st.charAt(st.length()-1)==')')||st.contains("#include<"))
				System.out.println(st);
				else
				{	if((st.charAt(st.length()-1)==';')&&(cp==0))
					System.out.println(st);
					else
					System.out.print(st+" ");
				}	
			}	
			if(st.equals("}")&&(cb==0))
			{
				st=br2.readLine();
				if(st.equals("int")||st.equals("void")||st.equals("float")||st.equals("char")||st.equals("long")||st.equals("short")||st.equals("double")||st.equals("struct"))
				{
					System.out.print(st+" ");
					continue;
				}
				else
				f=false;
				
			}
			
			}
	br2.close();
	}

}
