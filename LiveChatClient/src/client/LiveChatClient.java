/* Most of this code was taken from the GeeksforGeeks article titled "Multi-threaded Chat Application in Java
 * https://www.geeksforgeeks.org/multi-threaded-chat-application-set-2
 */

package client;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class LiveChatClient{
	
	final static int ServerPort = 8080;
	
	public static void main(String args[]) throws UnknownHostException, IOException {
		Scanner scanner = new Scanner(System.in);
		
		InetAddress ip = InetAddress.getByName("localhost");
		
		Socket connectionSocket = new Socket(ip, ServerPort);
		
		DataInputStream dInputStream = new DataInputStream(connectionSocket.getInputStream());
		DataOutputStream dOutputStream = new DataOutputStream(connectionSocket.getOutputStream());
		
		Thread sendMessage = new Thread(new Runnable() {
			@Override
			
			public void run() {
				while (true) {
					String message = scanner.nextLine();
					
					try {
						dOutputStream.writeUTF(message);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		Thread readMessage = new Thread(new Runnable() {

			@Override
			public void run() {
				while(true) {
					try {
						String message = dInputStream.readUTF();
						System.out.println(message);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				
			}
		});
		
		sendMessage.start();
		readMessage.start();
	}
}
