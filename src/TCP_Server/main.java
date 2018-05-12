package TCP_Server;

public class main {

	public static void main(String[] args) {
		new Thread(new TCPServer(3000)).start();
	}

}
