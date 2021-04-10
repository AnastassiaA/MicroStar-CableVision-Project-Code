/* Most of this code was taken from the GeeksforGeeks article titled "Multi-threaded Chat Application in Java
 * https://www.geeksforgeeks.org/multi-threaded-chat-application-set-1
 */

package server;

import java.io.*;
import java.util.*;
import java.net.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LiveChatServer {
	private ServerSocket serverSocket;
	private Socket connectionSocket;
	private int clientCount;
	
	static Vector<ClientHandler> array = new Vector<>();
	
	public LiveChatServer() {
		try {
			serverSocket = new ServerSocket(8080);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		System.out.println("The server has started: " + dtf.format(now));
		
		while(true) {
			try {
				connectionSocket = serverSocket.accept();
				
				DataInputStream dInputStream = new DataInputStream(connectionSocket.getInputStream());
				DataOutputStream dOutputStream = new DataOutputStream(connectionSocket.getOutputStream());
				
				ClientHandler clientHandler = new ClientHandler(connectionSocket, "client" + clientCount, dInputStream, dOutputStream);
				
				Thread thread = new Thread(clientHandler);
				
				array.add(clientHandler);
				
				thread.start();
				
				clientCount++;
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}
	
	class ClientHandler implements Runnable {
		Scanner scanner = new Scanner(System.in);
		private String name;
		final DataInputStream dInputStream;
		final DataOutputStream dOutputStream;
		Socket socket;
		boolean loginSuccessful;
		
		public ClientHandler(Socket socket, String name, DataInputStream dInputStream, DataOutputStream dOutputStream) {
			this.dInputStream = dInputStream;
			this.dOutputStream = dOutputStream;
			this.name = name;
			this.socket = socket;
			this.loginSuccessful = true;
		}
		
		@Override
		public void run() {
			String received;
			
			while(true) {
				try {
					received = dInputStream.readUTF();
					
					System.out.println(received);
					
					if(received.equals("logout")) {
						this.loginSuccessful=false;
						this.socket.close();
						break;
					}
					
					StringTokenizer stringToken = new StringTokenizer(received, "#");
					String messageToSend = stringToken.nextToken();
					String receiver = stringToken.nextToken();
					
					for(ClientHandler clientHandler : LiveChatServer.array) {
						if(clientHandler.name.equals(receiver) && clientHandler.loginSuccessful==true) {
							clientHandler.dOutputStream.writeUTF(this.name + " : " + messageToSend);
							break;
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			try {
				this.dInputStream.close();
				this.dOutputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}
}
