package org.hibernate.services;

import org.hibernate.models.Item;
import org.hibernate.models.ItemDescription;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;
class ItemServiceTest {

    @Test
    void createItem() {
        ItemService itemService = new ItemService();
        itemService.createItem(new Item("watch",new ItemDescription(2,1,10)));
        assertThat(itemService.getItems()).extracting(Item::getName).contains("watch");
    }
}