package finalProject;

public class phage {
	  String phage_name;
	  String host_name;
	  String family;
	  String receptor;
	  String RBP;
	   
	  
	    public String getPhageName() {
	        return phage_name;
	    }
	  
	    public void setPhageName(String phage_name) {
	        this.phage_name = phage_name;
	    }
	    public String getHostName() {
	        return phage_name;
	    }
	  
	    public void setHostName(String phage_name) {
	        this.phage_name = phage_name;
	    }
	    public String getFamily() {
	        return family;
	    }
	  
	    public void setSeq(String family) {
	        this.family = family;
	    }
	    public String getRBP() {
	        return RBP;
	    }
	  
	    public String getReceptor() {
	        return RBP;
	    }
	  
	    public void setReceptor(String receptor) {
	        this.RBP = RBP;
	    }
	  
	   
	  
	    public void setRBP(String RBP) {
	        this.RBP = RBP;
	    }
	  
	    phage(String phage_name, String host_name, String family,String receptor,String RBP) {
	        this.phage_name = phage_name;
	        this.host_name = host_name;
	        this.family = family;
	        this.receptor = receptor;
	        this.RBP = RBP;

}
}