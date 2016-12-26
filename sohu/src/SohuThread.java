import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;



public class SohuThread extends Thread{

	public static int cnt = 0;
	
	public static void main(String []args){
		for (int i = 0; i < 10; i++){
			SohuThread sohuThread = new SohuThread();
			sohuThread.start();
		}
	}
	@Override
	public void run() { 
		Thread t = Thread.currentThread();
		long i = 0;
		while(true) {
			try {
				String url = "http://pv.sohu.com/pv.gif?t?=1481016822284082_1920_1080?m?=0?e?=207194907;473545180;474379841?r?=http://mp.sohu.com/profile?xpt=MjUwNDM1Mzc0MkBzaW5hLnNvaHUuY29t";
				HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
				conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
				conn.setRequestProperty("Accept-Encoding", "gzip, deflate, sdch");
				conn.setRequestProperty("referer", "http://travel.sohu.com/20161128/n474379841.shtml");
				conn.setRequestProperty("cookie", "vjuids=-8a769704d.158cd9c511d.0.17e66d4796aa; IPLOC=CN4403; SUV=1611151631160620; vjlast=1480918323.1480918323.30");
				InputStream inputStream = conn.getInputStream();
				System.out.println("Ïß³Ì: " + t.getName() + " : " + (i++));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
