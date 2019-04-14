package cn.agent.service.impl;

import cn.agent.pojo.Client;
import cn.agent.service.ClientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public
class ClientServiceImple implements ClientService {


    @Override
    public
    boolean update(Client client) {
        return false;
    }

    @Override
    public
    boolean insert(Client client) {
        return false;
    }

    @Override
    public
    List<Client> findAllClient(Client client) {
        return null;
    }

    @Override
    public
    List<Client> findPageClient(Client client, int pageSum) {
        return null;
    }

    @Override
    public
    Long getCount(Client client) {
        return null;
    }

    @Override
    public
    Client findById(Long id) {
        return null;
    }

    @Override
    public
    boolean delete(Client client) {
        return false;
    }
}
