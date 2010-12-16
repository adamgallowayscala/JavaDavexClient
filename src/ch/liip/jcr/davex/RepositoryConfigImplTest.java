package ch.liip.jcr.davex;

import org.apache.jackrabbit.spi.RepositoryService;
import org.apache.jackrabbit.spi.commons.conversion.PathResolver;
import org.apache.jackrabbit.spi2davex.BatchReadConfig;
import org.apache.jackrabbit.spi2dav.RepositoryServiceImpl;
import org.apache.jackrabbit.spi.Path;
import org.apache.jackrabbit.spi.commons.name.NameFactoryImpl;
import org.apache.jackrabbit.spi.commons.name.PathFactoryImpl;
import org.apache.jackrabbit.spi.commons.identifier.IdFactoryImpl;
import org.apache.jackrabbit.spi.commons.value.*;
import org.apache.jackrabbit.spi.SessionInfo;
import java.util.HashMap;

import java.util.Map;


import javax.jcr.NamespaceException;
import javax.jcr.RepositoryException;

public class RepositoryConfigImplTest  extends AbstractRepositoryConfig {

	private final RepositoryService service;
	private final Map<SessionInfo, QValueFactoryImpl> qvFactories = new HashMap<SessionInfo, QValueFactoryImpl>();

	public RepositoryConfigImplTest(String uri) throws RepositoryException {
		super();
		service = createService(uri);
	}

	private static RepositoryService createService(String uri) throws RepositoryException {
		return new RepositoryServiceImpl(uri, IdFactoryImpl.getInstance(),  NameFactoryImpl.getInstance(),
				PathFactoryImpl.getInstance(), QValueFactoryImpl.getInstance());
	}

	public RepositoryService getRepositoryService() throws RepositoryException {
		return service;
	}
	
	
}
