package client_side.expression;

public interface DataServer extends DataGetter {
	  void open(int port, int freq, String[] paths,Object lock);
	    void close();
}
