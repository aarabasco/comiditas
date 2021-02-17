package Clientes;
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

	public List<Client> getclients() {
		return clients;
	 }
	 
	public void setclients(List<Client> clients) {
		this.clients = clients;
	 }
	
	public List<Client> getAllClients(){
		return clients;
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
	
	public List<Client> deleteClients(){
		clients.remove(0);
		return clients;
	}
	
	public List<Client> searchClientsDNI(){
		return clients;
	}
}