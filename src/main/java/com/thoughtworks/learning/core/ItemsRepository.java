package com.thoughtworks.learning.core;

import java.util.List;

public interface ItemsRepository{
    List<Items> findItems();
    List<Promotions> findPromotions();
}