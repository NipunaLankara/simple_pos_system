package com.example.pos2.dto.paginated;

import com.example.pos2.dto.response.ItemResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class PaginatedResponseItemDTO {
    List<ItemResponseDTO> itemGetDTOList;
    private long dataCount;

}
