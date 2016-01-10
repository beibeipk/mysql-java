package com.thoughtworks.learning.core;

import java.util.List;
import java.util.Map;

public interface ItemsRepository{
    void createInputsBarcode(Map newInstanceBean);
    List<ItemsInfo> findInputsInfo();
    List<ItemsInfo> findGiftInfo();
    Double caculateInputs();
    Double caculateGifts();
}