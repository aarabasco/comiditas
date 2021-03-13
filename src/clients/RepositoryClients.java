package clients;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import clients.Client;
import orders.Order;
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

	public ArrayList<Client> searchClientsByName(String nombre) {
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
	
	public void loadFile() {
		try {
			FileInputStream fi=new FileInputStream("Client.dat");
			ObjectInputStream oi=new ObjectInputStream(fi);

			clients=(ArrayList<Client>)oi.readObject();
			System.out.println(clients);
			oi.close();
		} catch (FileNotFoundException e) {
			System.out.println("No se han encontrado Client.dat");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void safeFile() {
		try {
			FileOutputStream fo=new FileOutputStream(new File("Client.dat"));
			ObjectOutputStream oo=new ObjectOutputStream(fo);
			oo.writeObject(clients);
			oo.flush();
			oo.close();
		} catch (FileNotFoundException e) {
			System.out.println("No hay clientes que cargar.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}