package creeper0809.health;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.opencsv.CSVReader;

import creeper0809.data.SiDoGunNumber;
import creeper0809.data.SiNum;
import creeper0809.object.Constants;

public class ReadSiDoGunNum implements Scvs {
	ArrayList<SiDoGunNumber> sidogunnum = new ArrayList<SiDoGunNumber>();
	ReadScv readScv;

	public ReadSiDoGunNum(ReadScv readScv) {
		this.readScv = readScv;
	}

	public void readScv(Session session) throws IOException {
		session.beginTransaction();
		CSVReader reader = new CSVReader(new FileReader(Constants.areaNumberPath)); // 1
		String[] nextLine;
		int i = 0;
		while ((nextLine = reader.readNext()) != null) {
			i++;
			if (i == 1)
				continue;
			SiNum si = readScv.SiNum.getsinum(nextLine[0]);
			session.save(new SiDoGunNumber(nextLine[1], nextLine[2], si));
			sidogunnum.add(new SiDoGunNumber(nextLine[1], nextLine[2], si));
		}
		session.getTransaction().commit();
	}
	public SiDoGunNumber getSiDoGunNumber(String num) {
		for (int i = 0; i < sidogunnum.size(); i++) {
			if (sidogunnum.get(i).getCityNum().equals(num))
				return sidogunnum.get(i);
		}
		return null;
	}
}
