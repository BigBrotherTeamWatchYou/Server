package com.krukun.Service;

import com.krukun.entity.Menu;

import java.util.List;

/**
 * Created by Eugeniy Krukun on 26.04.2016.
 */
public interface MenuServiceInterface {
    public List<Menu> getAll();
    public Menu getOne(long id);
    public Menu save(Menu menu);
    public void delete(long id);
}
