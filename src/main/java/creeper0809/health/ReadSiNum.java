package creeper0809.health;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.opencsv.CSVReader;

import creeper0809.data.SiNum;
import creeper0809.object.Constants;

public class ReadSiNum implements Scvs {
	
	ArrayList<SiNum> sinum = new ArrayList<SiNum>();
	
	public void readScv(Session session) throws IOException {
		session.beginTransaction();
		CSVReader reader = new CSVReader(new FileReader(Constants.cityNumberPath)); // 1
		String[] nextLine;
		int i = 0;
		while ((nextLine = reader.readNext()) != null) {
			i++;
			if (i == 1)
				continue;
			session.save(new SiNum(nextLine[0], nextLine[1]));
			sinum.add(new SiNum(nextLine[0], nextLine[1]));
		}
		session.getTransaction().commit();
	}
	
	public SiNum getsinum(String num) {
		for(int i = 0;i<sinum.size();i++) {
			if(sinum.get(i).getAreanum().equals(num)) return sinum.get(i);
		}
		return null;
	}
}
