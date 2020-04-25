package client_side.expression;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class MyDataServer implements DataServer {

	private HashMap<String, Double> values;
	private volatile boolean open;

	private static class MyServerHolder {
		public static final MyDataServer ds = new MyDataServer();
	}

	private MyDataServer() {
		values = new HashMap<String, Double>();
		open = false;
	}

	public static DataServer getServer() {
		return MyServerHolder.ds;
	}

	@Override
	public double get(String path) {
		return values.get(path);
	}

	@Override
	public void open(int port, int freq, String[] paths) {
		if (open)
			return;
		open = true;
		Thread server_thread = new Thread(() -> {
			try {
				ServerSocket server = new ServerSocket(port);
				server.setSoTimeout(3000);
				Socket aClient = server.accept();
				InputStream in = aClient.getInputStream();
				BufferedReader inputFromClient = new BufferedReader(new InputStreamReader(in));
				while (open) {

					String[] new_values = inputFromClient.readLine().split(",");
					for (int i = 0; i < new_values.length; i++) {
						String path = paths[i];
						double value = Double.parseDouble(new_values[i]);
						values.put(path, value);
					}

					Thread.sleep(1000 / freq);

				}
				aClient.close();
				server.close();

			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		});
		server_thread.start();

	}

	@Override
	public void close() {
		if (!open)
			return;
		this.open = false;
	}

}
