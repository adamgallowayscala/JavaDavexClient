
import javax.jcr.Credentials;
import javax.jcr.Node;
import javax.jcr.Repository;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.SimpleCredentials;
import javax.jcr.version.*;
import ch.liip.jcr.davex.DavexClient;

public class Client {
	
	
	public static void main(String[] args) {
		try {
			
			String url = "http://localhost:8081/server/";
			String workspace = "default";
			
			DavexClient Client = new DavexClient(url);
			Repository repo = Client.getRepository();
			Credentials sc = new SimpleCredentials("admin","admin".toCharArray());
			Session s = repo.login(sc,workspace);
			Node t;
			Node root = s.getRootNode();
			if (s.nodeExists("/foo")) {
				t = root.getNode("foo");
			} else {
				t = root.addNode("foo");
			}
			t.addMixin("mix:versionable");
			s.save();
			VersionManager vm = s.getWorkspace().getVersionManager();
			vm.checkout("/foo");
			
			t.setProperty("bar","foo");
			s.save();
			Version v = vm.checkin("/foo");
			
			VersionHistory history = vm.getVersionHistory("/foo");
			for (VersionIterator it = history.getAllVersions(); it.hasNext();) {
				Version version = (Version) it.next();
				System.out.println(version.getCreated().getTime());
			}
			
		} catch (RepositoryException e) {
			e.printStackTrace();
		}
	}
}
