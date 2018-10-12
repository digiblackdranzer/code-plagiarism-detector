import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.StringTokenizer;
public class URLDemo {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer(br.readLine());
		String ur = " ";
		//while(st.hasMoreTokens())
		//ur.concat(st.nextToken()+"%20"); 	
		URL mo = new URL("http://en.wikipedia.org/wiki/Euclidean_algorithm");
		Document doc = Jsoup.parse(mo,3*1000);
		String ip=doc.body().text();
		System.out.println(ip);
	}
	
}
