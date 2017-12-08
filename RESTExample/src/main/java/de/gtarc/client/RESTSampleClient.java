package de.gtarc.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

import com.google.gson.Gson;

public class RESTSampleClient {
	
	/**
	 * Step1: Generate data to send in json format
	 * @return
	 */
	private String generateData() {
		Gson builder = new Gson();
		return builder.toJson(new SampleData());
	}
	
	/**
	 * Step2: Now pass JSON Data to REST Service
	 * 
	 * @param dataToSend
	 * @return
	 */
	private URLConnection sendData(String dataToSend) {
		URLConnection connection = null;
		try {
			URL url = new URL("http://localhost:8080/RESTExample/rest/sampleService");
			connection = url.openConnection();
			connection.setDoOutput(true);
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(5000);
			OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
			out.write(dataToSend);
			out.close();
		} catch (Exception e) {
			System.out.println("\nError while calling REST Service");
			System.out.println(e);
		}
		return connection;
	}
	
	/**
	 * Step3: Receive REST Response
	 * 
	 * @param connection
	 */
	private void receiveResponse(URLConnection connection){
		try {
			BufferedReader in= new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String response;
			while ((response = in.readLine()) != null) {
				System.out.println("Response from server: " + response);
			}
				System.out.println("REST Service Invoked Successfully.." );
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * sample service request and response
	 */
	public void sendTemplateData() {
		String data = generateData();
		URLConnection connection = sendData(data);
		receiveResponse(connection);
	}
	/**
	 * no args
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		RESTSampleClient client = new RESTSampleClient();
		client.sendTemplateData();
	}
}
