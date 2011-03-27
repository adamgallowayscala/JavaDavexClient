
import javax.jcr.Credentials;
import javax.jcr.Repository;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.SimpleCredentials;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.util.List;
import javax.jcr.NamespaceRegistry;
import javax.jcr.nodetype.NodeTypeManager;
import javax.jcr.nodetype.NodeTypeTemplate;
import javax.jcr.nodetype.PropertyDefinitionTemplate;
import ch.liip.jcr.davex.DavexClient;


public class Client {


	public static void main(String[] args)  throws FileNotFoundException, MalformedURLException {
                try {
                    String url = "http://localhost:8081/server/";
                    String workspace = "default";

                    DavexClient Client = new DavexClient(url);
                    Repository repo = Client.getRepository();

                    Credentials sc = new SimpleCredentials("admin","admin".toCharArray());
                    Session s = repo.login(sc,workspace);
                    NamespaceRegistry nr = s.getWorkspace().getNamespaceRegistry();
             //       nr.registerNamespace("phpcr", "http://www.doctrine-project.org/phpcr-odm");
                    NodeTypeManager ntm = s.getWorkspace().getNodeTypeManager();
                    PropertyDefinitionTemplate pdt = ntm.createPropertyDefinitionTemplate();
                    pdt.setName("phpcr:alias");
                    NodeTypeTemplate ntt = ntm.createNodeTypeTemplate();
                    ntt.setMixin(true);
                    ntt.setName("phpcr:managed");
                    List list = ntt.getPropertyDefinitionTemplates();
                    list.add(pdt);
                    ntm.registerNodeType(ntt, true);

		} catch (RepositoryException e) {
			e.printStackTrace();
		}
	}
}
