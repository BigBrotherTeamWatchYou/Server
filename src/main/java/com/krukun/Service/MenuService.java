package com.krukun.Service;

import com.krukun.entity.Menu;
import com.krukun.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Eugeniy Krukun on 26.04.2016.
 */
@Service
public class MenuService implements MenuServiceInterface {
    @Autowired
    private MenuRepository repository;
    @Override
    public List<Menu> getAll() {
        return repository.findAll();
    }

    @Override
    public Menu getOne(long id) {
        return repository.findOne(id);
    }

    @Override
    public Menu save(Menu menu) {
        return repository.saveAndFlush(menu);
    }

    @Override
    public void delete(long id) {
        repository.delete(id);
    }
}
