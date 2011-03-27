
import javax.jcr.Credentials;
import javax.jcr.Node;
import javax.jcr.Repository;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.SimpleCredentials;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;

import org.apache.jackrabbit.rmi.repository.URLRemoteRepository;

public class Client {


	public static void main(String[] args)  throws FileNotFoundException, MalformedURLException {
                try {
			String workspace = "default";
                        Repository repo = new URLRemoteRepository("http://localhost:8081/rmi");


			Credentials sc = new SimpleCredentials("admin","admin".toCharArray());
			Session s = repo.login(sc,workspace);
			Node root=s.getRootNode();
			System.out.println("Root node is of type: "+root.getPrimaryNodeType().getName());

		} catch (RepositoryException e) {
			e.printStackTrace();
		}
	}
}