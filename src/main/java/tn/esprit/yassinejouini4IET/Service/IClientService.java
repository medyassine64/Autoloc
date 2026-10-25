package tn.esprit.yassinejouini4IET.Service;

import tn.esprit.yassinejouini4IET.Domain.Client;

import java.util.List;

public interface IClientService {

    Client addClient(Client client);

    Client updateClient(Long id, Client client);

    Client getClientById(Long id);

    Client getClientByEmail(String email);

    List<Client> getAllClients();

    List<Client> searchClientsByNom(String nom);

    void deleteClient(Long id);
}