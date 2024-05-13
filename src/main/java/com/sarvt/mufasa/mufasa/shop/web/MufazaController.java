package com.sarvt.mufasa.mufasa.shop.web;

import com.sarvt.mufasa.mufasa.shop.model.MufazaItemModel;
import com.sarvt.mufasa.mufasa.shop.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.*;

@RestController
public class MufazaController {

//    @Autowired

    public final ItemService itemService;

    public MufazaController(ItemService itemService){
        this.itemService = itemService;
    }

    @GetMapping("/")
    public String Greet(){
        return "Welcome User!";
    }

    @GetMapping("/items")
    public Iterable<MufazaItemModel> getItems(){
        return itemService.getAll();
    }
    @GetMapping("/items/{id}")
    public MufazaItemModel getItem(@PathVariable Integer id){
        MufazaItemModel item = itemService.get(id);
        if (item == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return item;
    }

    @DeleteMapping("/items/{id}")
    public void deleteItem(@PathVariable String id){
        itemService.remove(Integer.valueOf(id));
//        if (item == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//        return item;
    }

    @PostMapping("/items")
    public MufazaItemModel addItem(@RequestPart("data") MultipartFile file) throws IOException {
        MufazaItemModel item = itemService.save(file.getOriginalFilename(), file.getContentType(), file.getBytes());
        return item;
    }
}