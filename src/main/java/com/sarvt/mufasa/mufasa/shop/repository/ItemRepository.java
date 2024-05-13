package com.sarvt.mufasa.mufasa.shop.repository;

import com.sarvt.mufasa.mufasa.shop.model.MufazaItemModel;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<MufazaItemModel, Integer> {

}
