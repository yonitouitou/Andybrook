package com.andybrook.service.stock;

import com.andybrook.dao.stock.IGlassesStockDao;
import com.andybrook.model.Glasses;
import com.andybrook.model.GlassesStockItem;
import com.andybrook.service.glasses.IGlassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.Optional;

@Service
public class GlassesStockService implements IGlassesStockService {

    @Autowired
    private IGlassesStockDao glassesStockDao;
    @Autowired
    private IGlassesService glassesService;

    @Override
    @Transactional
    public GlassesStockItem newGlassesStockItem(GlassesStockItem item) {
        Glasses savedGlasses = glassesService.updateGlasses(item.getGlasses());
        item.getGlasses().setId(savedGlasses.getId());
        return glassesStockDao.updateGlassesStockItem(item);
    }

    @Override
    @Transactional
    public GlassesStockItem updateGlassesStockItem(GlassesStockItem item) {
        glassesService.updateGlasses(item.getGlasses());
        return glassesStockDao.updateGlassesStockItem(item);
    }

    @Override
    public Optional<GlassesStockItem> getGlassesStockItem(long id) {
        return glassesStockDao.getGlassesStockItem(id);
    }

    @Override
    public Map<Long, GlassesStockItem> getAllGlassesStockItems() {
        return glassesStockDao.getAllGlassesStockItems();
    }

    @Override
    @Transactional
    public boolean removeGlassesStockItem(long id) {
        glassesStockDao.removeGlassesStockItem(id);
        glassesService.removeGlasses(id);
        return true;
    }
}
