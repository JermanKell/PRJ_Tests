package TCP_Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeMap;

public class TCPServer implements Runnable{
	/**
	*  Sets the socket's server
	*/
	private ServerSocket socketserver = null;
	/**
	*  Active socket of the server
	*/
	private Socket socket = null;
	
	private HashMap<String, TreeMap<Float, ArrayList<Course>>> hMap = null;
	
	/**
	 * Constructor of the class
	 * @author Xavier Bouchenard
	 * @param port	Port ID to launch the server service
	 */
	public TCPServer(int port) {
		try {
			socketserver = new ServerSocket(port);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		hMap = new HashMap<String, TreeMap<Float, ArrayList<Course>>>();
	}
	
	/**
	 * Awaiting for input data to read
	 * @author Xavier Bouchenard
	 */
	@Override
	public void run() {
		System.out.println("Server is starting");
		while (true) {
			try {
				System.out.println("Awaiting for a connection attempt");
				socket = socketserver.accept();
				getData();
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			displayContent();
		}
		
	}
	
	@SuppressWarnings({ "unchecked", "unused" })
	private void getData() {
		ObjectInputStream in = null;
		
		Object obj = null;
		boolean var = true;
		String dptName = null;
		TreeMap<Float, ArrayList<Course>> map = null;
		
		
		while (var) {
			try {
				in = new ObjectInputStream(socket.getInputStream());
				obj = in.readObject();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} 
			
			dptName = (String)obj;
			if (dptName.length() != 0) {
				System.out.println("Le string reçu du client: " + dptName);
				try {
					inList = new ObjectInputStream(socket.getInputStream());
					obj = inList.readObject();
					inList.close();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				map = (TreeMap<Float, ArrayList<Course>>) obj;
				hMap.put(dptName, map);
			}
			else var = false;
		}    	
	}
	
	private void displayContent() {
		if (hMap.size() != 0) {
			Set<String> str = hMap.keySet();
			System.out.println("Voici les départements présents:");
			for (String string : str) {
				System.out.println(string);
			}
		}
		else System.out.println("Y a rien a afficher");
	}
}
