package com.thoughtworks.learning.core;

import java.util.List;
import java.util.Map;

public interface ItemsRepository{
    List<Items> findItems();
//    List<Promotions> findPromotions();
    void createInputsBarcode(Map newInstanceBean);
    List<String> findInputsBarcode();
}