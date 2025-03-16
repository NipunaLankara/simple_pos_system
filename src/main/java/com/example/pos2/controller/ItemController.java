package com.example.pos2.controller;

import com.example.pos2.dto.paginated.PaginatedResponseItemDTO;
import com.example.pos2.dto.requst.ItemSaveDTO;
import com.example.pos2.dto.response.ItemResponseDTO;
import com.example.pos2.service.ItemService;
import com.example.pos2.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/item")
@CrossOrigin

public class ItemController {
    @Autowired
    private ItemService itemService;

//    @PostMapping("/save-1")
//    public String itemSave (@RequestBody ItemSaveDTO itemSaveDTO) {
//        String massage = itemService.saveItem(itemSaveDTO);
//        return massage;
//
//    }

    @PostMapping("/save-1")
    public ResponseEntity<StandardResponse> itemSave(@RequestBody ItemSaveDTO itemSaveDTO) {
        String massage = itemService.saveItem(itemSaveDTO);

        ResponseEntity<StandardResponse> response = new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "Item Saved", massage), HttpStatus.CREATED
        );

        return response;

    }


//    @GetMapping(path = "/get-by-name", params = "name")
//    public List<ItemResponseDTO> getItemByName(@RequestParam(value = "name") String name) {
//        List<ItemResponseDTO> itemDTOList = itemService.getItemByName(name);
//        return itemDTOList;
//
//    }

    @GetMapping(path = "/get-by-name", params = "name")
    public ResponseEntity<StandardResponse> getItemByName(@RequestParam(value = "name") String name) {
        List<ItemResponseDTO> itemDTOList = itemService.getItemByName(name);

        ResponseEntity<StandardResponse> response = new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "Success", itemDTOList), HttpStatus.OK
        );

        return response;
    }

//    @GetMapping (
//            path = "/get-by-name-active-status",
//            params = "name"
//    )
//    public List<ItemResponseDTO> getItemByNameAndStatus (@RequestParam (value = "name") String name){
//       List<ItemResponseDTO> itemResponseDTOList = itemService.getItemByNameAndStatus(name);
//       return  itemResponseDTOList;
//    }

    @GetMapping(
            path = "/get-by-name-active-status",
            params = "name"
    )
    public ResponseEntity<StandardResponse> getItemByNameAndStatus(@RequestParam(value = "name") String name) {
        List<ItemResponseDTO> itemResponseDTOList = itemService.getItemByNameAndStatus(name);

//        ResponseEntity<StandardResponse> response = new ResponseEntity<StandardResponse>(
//                new StandardResponse(201,"Success",itemResponseDTOList),HttpStatus.OK
//        );
//        return response;

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "Success", itemResponseDTOList),
                HttpStatus.OK
        );
    }

//    @GetMapping (
//            path = "/get-by-name-active-status-mapstruct",
//            params = "name"
//    )
//    public List<ItemResponseDTO> getItemByNameAndStatusByMapstruct (@RequestParam (value = "name") String name){
//        List<ItemResponseDTO> itemResponseDTOList = itemService.getItemByNameAndStatusByMapstruct(name);
//        return  itemResponseDTOList;
//    }

    @GetMapping(
            path = "/get-by-name-active-status-mapstruct",
            params = "name"
    )
    public ResponseEntity<StandardResponse> getItemByNameAndStatusByMapstruct(@RequestParam(value = "name") String name) {
        List<ItemResponseDTO> itemResponseDTOList = itemService.getItemByNameAndStatusByMapstruct(name);

        ResponseEntity<StandardResponse> response = new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "Success", itemResponseDTOList), HttpStatus.OK
        );

        return response;
    }

    @GetMapping(path = "get-all-items")
    public ResponseEntity<StandardResponse> getAllItems() {
        List<ItemResponseDTO> allItems = itemService.getAllItems();

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "Success Show Items", allItems),
                HttpStatus.OK
        );
    }

    @GetMapping(
            path = "/get-all-items-Paginate",
            params = {"pageNumber", "size"}
    )
    public ResponseEntity<StandardResponse> getAllItemsWithPaginated(
            @RequestParam(value = "pageNumber") int pageNumber,
            @RequestParam(value = "size") int size
    ) {

        PaginatedResponseItemDTO itemDTO =  itemService.getAllItemsWithPaginated(pageNumber,size);

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "Success Show Items", itemDTO),
                HttpStatus.OK
        );

    }


}
