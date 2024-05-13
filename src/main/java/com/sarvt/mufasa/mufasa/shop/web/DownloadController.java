package com.sarvt.mufasa.mufasa.shop.web;

import com.sarvt.mufasa.mufasa.shop.model.MufazaItemModel;
import com.sarvt.mufasa.mufasa.shop.service.ItemService;
import org.springframework.data.relational.core.sql.In;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class DownloadController {
    private final ItemService itemService;

    public DownloadController(ItemService itemService){
        this.itemService = itemService;
    }

    @GetMapping("/dwn/{id}")
    public ResponseEntity<byte[]> dwn(@PathVariable Integer id){
        MufazaItemModel item = itemService.get(id);
        if (item==null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        byte[] data = item.getData();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf(item.getContentType()));
        ContentDisposition build = ContentDisposition.builder("attachment").filename(item.getName()).build();
        headers.setContentDisposition(build);
        return new ResponseEntity<>(data, headers, HttpStatus.OK);
    }

}
