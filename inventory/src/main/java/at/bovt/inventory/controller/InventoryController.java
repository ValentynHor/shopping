package at.bovt.inventory.controller;

import at.bovt.inventory.dto.InventoryResponse;
import at.bovt.inventory.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> isInStock(@PathVariable List<String> skuCode){
        return inventoryService.isInStock(skuCode);
    }
}
