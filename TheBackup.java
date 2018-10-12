import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import org.jsoup.*;
import org.jsoup.nodes.*;

import com.google.gson.Gson;
import java.util.*;


public class TheBackup implements ActionListener {
	JTextField jt1,jt2,jt3;
	JFrame main,f;
	JFileChooser jfc;
	TheBackup()
	{
		main=new JFrame("CP Main");
		main.setLayout(null);
		jfc = new JFileChooser();
		JLabel jl3 = new JLabel("Target Code");
		JLabel jl1 = new JLabel("Code Topic");
		JLabel jl2 = new JLabel("Language used");
		JButton jb = new JButton("Check");
		JButton jb2 = new JButton("Browse");
		 jt1 = new JTextField();
		 jt2 = new JTextField();
		 jt3 = new JTextField();
		 jl1.setSize(100,25);
		 jl2.setSize(120,25);
		 jl3.setSize(100,25);
		 jt1.setSize(100,25);
		 jt2.setSize(100,25);
		 jt3.setSize(100,25);
		 jb.setSize(100,25);
		 jb2.setSize(100,25);
		 jl3.setLocation(50,100);
		 jl1.setLocation(50,150);
		 jl2.setLocation(50,200);
		 jt3.setLocation(150,100);
		 jt1.setLocation(150,150);
		 jt2.setLocation(150,200);
		 jb.setLocation(100,250);
		 jb2.setLocation(275,100);
		 jt1.addActionListener(this);
		 jt2.addActionListener(this);
		 jt3.addActionListener(this);
		 jb.addActionListener(this);
		 jb2.addActionListener(this);
		 main.add(jl1);
		 main.add(jl2);
		 main.add(jl3);
		 main.add(jt1);
		 main.add(jt2);
		 main.add(jt3);
		 main.add(jb);
		 main.add(jb2);
		 main.setSize(400,400);
		 main.setVisible(true);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		
		try
		{
			int c;
			String str = e.getActionCommand();
		
			if(str.equals("Check"))
			{
				main.setVisible(false);
				f = new JFrame("Result");
				f.setLayout(null);
				f.setSize(600,600);
				String s1=jt1.getText();
				String s2=jt2.getText();
				String s3=jt3.getText();
				String tmp;
				String google = "http://ajax.googleapis.com/ajax/services/search/web?v=1.0&q=";
				String search = s1+" using "+s2+" language";
				String charset = "UTF-8";
			
				URL url = new URL(google + URLEncoder.encode(search, charset));
				Reader reader = new InputStreamReader(url.openStream(), charset);
				GoogleResults results = new Gson().fromJson(reader, GoogleResults.class);
				
				File target = new File(s3);
				File links = new File(target.getParent()+"/link.txt");
				FileOutputStream fos = new FileOutputStream(links);
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
				
				
				for(int i=0;i<results.getResponseData().getResults().size();i++)
				{
					bw.write(results.getResponseData().getResults().get(i).getUrl());
					bw.newLine();
				}
				
				bw.close();
				fos.close();
				
				FileInputStream fis = new FileInputStream(links);
				BufferedReader br = new BufferedReader(new InputStreamReader(fis));
				c=0;
				while((tmp=br.readLine())!=null)
				{
					c++;
					URL site = new URL(tmp);
					Document doc = Jsoup.parse(site,3*1000);
					String info=doc.body().text();
					File  sample = new File(target.getParent()+"/sample"+c+".txt");
					fos = new FileOutputStream(sample);
					bw = new BufferedWriter(new OutputStreamWriter(fos));
					StringTokenizer st = new StringTokenizer(info);
					while (st.hasMoreTokens())
					{
						bw.write(st.nextToken());
						bw.newLine();
					}
					bw.close();
				}	
				
				fos.close();
				fis.close();
				
				
				
			}	
					
		
		
		if(str.equals("Browse"))
		{
			jfc.showOpenDialog(main);
			jt3.setText(jfc.getSelectedFile().getPath());
		}
			
			
		
		}

		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
	
		TheBackup cpg = new TheBackup();
	}

}

