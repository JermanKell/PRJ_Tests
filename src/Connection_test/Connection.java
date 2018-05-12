package Connection_test;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class Connection {
	public static void main(String[] args) {
		Enumeration<NetworkInterface> e = null;
	    try {
			e = NetworkInterface.getNetworkInterfaces();
		} catch (SocketException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
	    while (e.hasMoreElements()){ 
	      Enumeration<InetAddress> i = e.nextElement().getInetAddresses(); 
	      while (i.hasMoreElements()){ 
	        InetAddress a = i.nextElement(); 
	        System.out.println(a.getHostName()+" -> "+a.getHostAddress()+ 
	           "\n\t isloopback? "+a.isLoopbackAddress()+ 
	           "\n\t isSiteLocalAddress? "+a.isSiteLocalAddress()+ 
	           "\n\t isIPV6? "+(a instanceof Inet6Address) 
	         ); 
	      } 
	      System.out.println("---------------"); 
	    }
	}
}
