package mesCommandes;

import jakarta.servlet.http.Cookie;

public class Identification {

	public static String chercheNom(Cookie[] cookies) {
		 // cherche dans les cookies la valeur de celui qui se nomme "nom"
		  String name ="nom";
		 
		 for ( int i=0; i<cookies.length; i++) {
          
			 Cookie cookie = cookies[i];
		       
		       if (name.equals(cookie.getName())) {
		    	   
		    	  name=cookie.getValue();
		    	  
		       }
		 }
		 return name;
	}

}
