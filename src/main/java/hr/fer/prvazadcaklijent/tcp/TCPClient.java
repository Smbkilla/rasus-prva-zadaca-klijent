package hr.fer.prvazadcaklijent.tcp;

import com.fasterxml.jackson.databind.ObjectMapper;
import hr.fer.prvazadcaklijent.model.SensorReading;

import java.io.*;
import java.net.Socket;

public class TCPClient {
	public TCPClient() {
	}

	public SensorReading getNeighborData(String ipAddress, int port) {

		try (Socket clientSocket = new Socket(ipAddress, port)) {
			ObjectMapper mapper = new ObjectMapper();

			String sendString1 = "kaj mjeris?";

			PrintWriter outToServer = new PrintWriter(new OutputStreamWriter(
					clientSocket.getOutputStream()), true);

			// get the socket's input stream and open a BufferedReader on it
			BufferedReader inFromServer = new BufferedReader(new InputStreamReader(
					clientSocket.getInputStream()));

			// send a String then terminate the line and flush
			outToServer.println(sendString1);//WRITE
			System.out.println("TCPClient sent: " + sendString1);

			// read a line of text
			String rcvString = inFromServer.readLine();//READ
			System.out.println("TCPClient received: " + rcvString);
			return mapper.readValue(rcvString, SensorReading.class);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}//CLOSE
	}
}
