package com.example.pos2.service;

import com.example.pos2.dto.paginated.PaginatedResponseItemDTO;
import com.example.pos2.dto.requst.ItemSaveDTO;
import com.example.pos2.dto.response.ItemResponseDTO;

import java.util.List;

public interface ItemService {
    String saveItem(ItemSaveDTO itemSaveDTO);

    List<ItemResponseDTO> getItemByName(String name);


    List<ItemResponseDTO> getItemByNameAndStatus(String name);

    List<ItemResponseDTO> getItemByNameAndStatusByMapstruct(String name);


    List<ItemResponseDTO> getAllItems();

    PaginatedResponseItemDTO getAllItemsWithPaginated(int page, int size);
}
