package com.sarvt.mufasa.mufasa.shop.service;

import com.sarvt.mufasa.mufasa.shop.model.MufazaItemModel;
import com.sarvt.mufasa.mufasa.shop.repository.ItemRepository;
import org.springframework.stereotype.Service;
import java.util.UUID;

//@Component
@Service
public class ItemService {

    private final ItemRepository itemRepository;


    //    private List<MufazaItemModel> db = List.of(new MufazaItemModel("1","yhv"));
//    private Map<String, MufazaItemModel> mp = new HashMap<>(){
//        {
//            put("1", new MufazaItemModel("1", "tct"));
//        }};

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public MufazaItemModel save(String fileName, String contentType, byte[] data) {
        MufazaItemModel item = new MufazaItemModel();
        item.setContentType(contentType);
        item.setId(UUID.randomUUID().toString());
        item.setName(fileName);
        item.setData(data);
        itemRepository.save(item);
//        itemService.save(item.getId(), item);
        return item;
    }

    public Iterable<MufazaItemModel> getAll() {
        return itemRepository.findAll();
    }

    public void remove(Integer id) {
        itemRepository.deleteById(id);
    }

    public MufazaItemModel get(Integer id) {
        return itemRepository.findById(id).orElse(null);
    }

//    public

}
