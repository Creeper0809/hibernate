package creeper0809.health;

import java.io.FileReader;
import java.io.IOException;

import org.hibernate.Session;

import com.opencsv.CSVReader;

import creeper0809.data.InfectInfo;
import creeper0809.data.InfectKinds;
import creeper0809.data.SiDoGunNumber;
import creeper0809.data.SiNum;
import creeper0809.data.infectInfoid;
import creeper0809.object.Constants;

public class ReadInfectInfo implements Scvs {
	ReadScv readScv;

	public ReadInfectInfo(ReadScv readScv) {
		this.readScv = readScv;
	}

	@Override
	public void readScv(Session session) throws IOException {
		String[] nextLine;
		CSVReader reader = new CSVReader(new FileReader(Constants.coldinfectinfo)); // 1
		InfectKinds kind = readScv.InfectName.getInfect("감기");
		for (int i = 0; i < 4; i++) {
			session.beginTransaction();
			int j = 0;
			switch (i) {
			case 0:
				reader = new CSVReader(new FileReader(Constants.coldinfectinfo));
				kind = readScv.InfectName.getInfect("감기");
				break;
			case 1:
				reader = new CSVReader(new FileReader(Constants.eyeinfectinfo));
				kind = readScv.InfectName.getInfect("눈병");
				break;
			case 2:
				reader = new CSVReader(new FileReader(Constants.skininfectinfo));
				kind = readScv.InfectName.getInfect("피부염");
				break;
			case 3:
				reader = new CSVReader(new FileReader(Constants.lunginfectinfo));
				kind = readScv.InfectName.getInfect("천식");
				break;
			}
			while ((nextLine = reader.readNext()) != null) {
				j++; 
				if (j == 1)
					continue;
				SiDoGunNumber si = readScv.SiDoGunNum.getSiDoGunNumber(nextLine[1]);
				infectInfoid id = new infectInfoid(nextLine[0], si, kind);
				InfectInfo info = new InfectInfo(nextLine[2],id);
				if(si == null) continue;
				session.save(info);
				if (j == 1000) {
					session.getTransaction().commit();
					break;
				}
			}
		}
	}
//	String date, SiDoGunNumber area, String howMany,InfectKinds kinds
}
