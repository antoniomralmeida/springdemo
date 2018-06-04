package br.com.opencare.springdemo.config;

public class GlobalLib {
	public static String getError(Exception e) {
		final String erros[] = {"org.springframework.dao.DataIntegrityViolationException"};
		for (String s : erros) 
			if (e.getClass().getName().equals(s))
				return s;
		return "unknown.error";			
	}

}
