package creeper0809.health;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

public interface Scvs {
	void readScv(Session session) throws IOException;
}
