package Clientes;
import java.util.ArrayList;
import java.util.List;

public class RepositoryClients {
	 private List<Client> clients;
	 
	 private static RepositoryClients mirepository; 
	 
	 private RepositoryClients(List<Client> clients){
		 this.clients=clients; 
	 }
	 
	 
	 public  static RepositoryClients getMiRepository(List<Client> clients) {
		 if (mirepository==null) {
			 mirepository=new RepositoryClients(clients);
		 }
		 return mirepository;
	 }

	public List<Client> getclients(String nombre) {
		ArrayList <Client> result=null;
		if(nombre != null) {
			for(int i=0;i<clients.size();i++) {
				
				if(clients.get(i).getName()!=null) {
					if(clients.get(i).getName().equals(nombre)) {
						if(result==null) {
							result=new ArrayList<>();
						}
						result.add(clients.get(i));
					}
				}
			}
		}
		return clients;
	 }
	 
	public void setclients(List<Client> clients) {
		this.clients = clients;
	 }
	
	public List<Client> getAllClients(){
		if(clients != null) {
			return clients;
		}
		return null;
	}
	
	public List<Client> searchClientsName(){
		return clients;
	}
	
	public List<Client> updateClients(){
		
		return clients;
	}
	
	public List<Client> addClients(){
		clients.add(null);
		return clients;
	}
	
	public boolean deleteClients(String dni){
		boolean result = false;
			if (dni != null) {
				for(int i=0;i<clients.size();i++) {
					if(clients.get(i).getName()!=null) {
						if(clients.get(i).getName().equals(dni)) {
							clients.remove(i);
							return true;
						}
					}
				}
			}
		return result;
		
	}
	
	public List<Client> searchClientsDNI(){
		return clients;
	}
}
