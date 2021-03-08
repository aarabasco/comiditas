package clients;
import java.io.Serializable;
import java.util.ArrayList;
import clients.Client;
public class RepositoryClients implements Serializable{
	 private ArrayList<Client> clients;
	 
	 private static RepositoryClients mirepository; 
	 
	 private RepositoryClients(ArrayList<Client> clients){
		 this.clients=clients; 
	 }
	 
	 
	 public  static RepositoryClients getMiRepository(ArrayList<Client> clients) {
		 if (mirepository==null) {
			 mirepository=new RepositoryClients(clients);
		 }
		 return mirepository;
	 }
	 
	 public  static RepositoryClients getMiRepository() {
		 if (mirepository==null) {
			 mirepository=new RepositoryClients(new ArrayList<Client>());
		 }
		 return mirepository;
	 }

	public ArrayList<Client> getClientsByName(String nombre) {
		ArrayList <Client> result=null;
		if(nombre != null) {
			for(int i=0;i<clients.size();i++) {
				
				if(clients.get(i)!=null&&clients.get(i).getName()!=null) {
					if(clients.get(i).getName().equals(nombre)) {
						if(result==null) {
							result=new ArrayList<Client>();
						}
						result.add(clients.get(i));
					}
				}
			}
		}
		return clients;
	 }
	 
	public void setclients(ArrayList<Client> clients) {
		this.clients = clients;
	 }
	
	public ArrayList<Client> getAllClients(){
		if(clients != null) {
			return clients;
		}
		return null;
	}
	
	public ArrayList<Client> searchClientsName(){
		return clients;
	}
	
	public boolean updateClient(Client newCliente) {
		
		if(newCliente!=null&&newCliente.getDni()!=null) {
			for (int i = 0; i < clients.size(); i++) {
				if(clients.get(i)!=null&&clients.get(i).getDni()!=null&&clients.get(i).equals(newCliente)) {
					clients.add(i, newCliente);
					clients.remove(i+1);
					return true;
					
				}
			}
		}
		
		return false;
	}
	
	public boolean addClient(Client newCliente){
		if (newCliente != null) {
			if(!(clients.contains(newCliente))) {
				clients.add(newCliente);
				return true;
			}
		}
		return false;
	}
	
	public boolean deleteClient(String dni){
			if (dni != null) {
				for(int i=0;i<clients.size();i++) {
					if(clients.get(i)!=null&&clients.get(i).getName()!=null) {
						if(clients.get(i).getName().equals(dni)) {
							clients.remove(i);
							return true;
						}
					}
				}
			}
		return false;
		
	}

	public ArrayList<Client> searchClientsDNI(String dni) {
		// TODO Auto-generated method stub
		return null;
	}
}