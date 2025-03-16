package com.example.pos2.util.mappers;


import com.example.pos2.dto.paginated.PaginatedResponseItemDTO;
import com.example.pos2.dto.response.ItemResponseDTO;
import com.example.pos2.entity.Item;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;


@Mapper(componentModel = "spring")
public interface ItemMapper {
    List<ItemResponseDTO> entityListToDtoList ( List<Item> itemList);

    List<ItemResponseDTO>  listPageTolistDTO ( Page<Item> itemPage);



}
