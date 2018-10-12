import java.io.*;
import java.net.*;
import org.jsoup.*;
import org.jsoup.nodes.*;
import java.util.*;
import com.google.gson.*;

public class BlackBOx {
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter code topic");
		String ct = br.readLine();
		System.out.println("Enter language used");
		String lang = br.readLine();
		String google = "http://ajax.googleapis.com/ajax/services/search/web?v=1.0&q=";
		String search = ct+" using "+lang+" language";
		String charset = "UTF-8";

		URL url = new URL(google + URLEncoder.encode(search, charset));
		Reader reader = new InputStreamReader(url.openStream(), charset);
		GoogleResults results = new Gson().fromJson(reader, GoogleResults.class);

		    // Show title and URL of 1st result.
		
		
		
	}

}

