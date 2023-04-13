package fp.utiles;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Utiles {
	
	public static void checkNoNull(Object e) {
		if (e.equals(null)) {
			throw new IllegalArgumentException();
		}
	}
	
	public static List<String> leerCSV(String path) {
		List<String> result= new ArrayList<>();
		try {
			result=Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
