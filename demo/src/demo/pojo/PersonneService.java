package demo.pojo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PersonneService {

	public static List<Personne> getPersonnes(){
		List<Personne> personnes = new ArrayList<Personne>();
		personnes.add(PersonneBuilder.personne().withNom("Leclercq").withPrenom("Pascal").withDtNaissance(toDate("16/06/1973")).withAdresse().withZipCode("59000").endAdresse().build());
		personnes.add(PersonneBuilder.personne().withNom("Zerr").withPrenom("Angelo").withDtNaissance(toDate("01/01/1973")).withAdresse().withZipCode("62000").endAdresse().build());
		
		return personnes;
	}

	private static Date toDate(String dtStr) {
		SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
		
		
		try {
			return sdf.parse(dtStr);
		} catch (ParseException e) {
			return null;
		}
	}
}
