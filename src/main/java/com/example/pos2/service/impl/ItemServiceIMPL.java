package com.example.pos2.service.impl;

import com.example.pos2.dto.paginated.PaginatedResponseItemDTO;
import com.example.pos2.dto.requst.ItemSaveDTO;
import com.example.pos2.dto.response.ItemResponseDTO;
import com.example.pos2.entity.Item;
import com.example.pos2.exception.DuplicateKeyException;
import com.example.pos2.exception.NotFoundException;
import com.example.pos2.repo.ItemRepo;
import com.example.pos2.service.ItemService;
import com.example.pos2.util.mappers.ItemMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceIMPL implements ItemService {
    @Autowired
    private ItemRepo itemRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ItemMapper itemMapper;


    @Override
    public String saveItem(ItemSaveDTO itemSaveDTO) {
        Item item = modelMapper.map(itemSaveDTO, Item.class);
//        item.setStatus(true);
        if (!itemRepo.existsById(item.getItemId())) {
            itemRepo.save(item);
            return item.getItemName() + " Saved Successfully";

        } else {
            throw new DuplicateKeyException("Already Added");
        }
    }

    @Override
    public List<ItemResponseDTO> getItemByName(String name) {
        List<Item> itemList = itemRepo.findAllByItemNameEquals(name);

        List<ItemResponseDTO> itemResponseDTOList = new ArrayList<>();

        for (Item item : itemList) {
            ItemResponseDTO itemResponseDTO = new ItemResponseDTO(
                    item.getItemId(),
                    item.getItemName(),
                    item.getQuantity(),
                    item.getSupplierPrice(),
                    item.getSellingPrice(),
                    item.isStatus()
            );
            itemResponseDTOList.add(itemResponseDTO);
        }

        return itemResponseDTOList;
    }

    @Override
    public List<ItemResponseDTO> getItemByNameAndStatus(String name) {
        List<Item> itemList = itemRepo.findAllByItemNameEqualsAndStatusEquals(name, true);

        if (itemList.size() > 0) {
            List<ItemResponseDTO> itemGetDTOList = modelMapper.map(itemList, new TypeToken<List<ItemResponseDTO>>() {
            }.getType());
            return itemGetDTOList;
        } else {
            throw new RuntimeException("Item Not Active");
        }

    }

    @Override
    public List<ItemResponseDTO> getItemByNameAndStatusByMapstruct(String name) {
        List<Item> itemList = itemRepo.findAllByItemNameEqualsAndStatusEquals(name, true);

        if (itemList.size() > 0) {
            List<ItemResponseDTO> responseDTOList = itemMapper.entityListToDtoList(itemList);
            return responseDTOList;

        } else {
            throw new NotFoundException("No Match Item..");
        }
    }

    @Override
    public List<ItemResponseDTO> getAllItems() {
        List<Item> itemList = itemRepo.findAll();

        if (itemList.size() > 0) {
            List<ItemResponseDTO> dtoList = modelMapper.map(itemList, new TypeToken<List<ItemResponseDTO>>() {}.getType());
            return dtoList;

        } else {
            throw new NotFoundException("Empty..");
        }
    }

    @Override
    public PaginatedResponseItemDTO getAllItemsWithPaginated(int pageNumber, int size) {
        Page<Item> itemPage = itemRepo.findAll(PageRequest.of(pageNumber, size));

        if (itemPage.getSize() > 0) {
            long count = itemRepo.count();
            PaginatedResponseItemDTO paginatedResponseItemDTO = new PaginatedResponseItemDTO(
                    itemMapper.listPageTolistDTO(itemPage), count
            );
          return paginatedResponseItemDTO;

        } else {
            throw new NotFoundException("No Data Found..");
        }
    }


}
