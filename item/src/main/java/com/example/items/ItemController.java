package com.example.items;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/items")
public class ItemController {
    private final ItemService itemService;

    private final MeterRegistry meterRegistry;

    @Autowired
    public ItemController(ItemService itemService, MeterRegistry meterRegistry) {
        this.itemService = itemService;
        this.meterRegistry = meterRegistry;
    }

    @GetMapping("/all")
    public String getAllItems(Model model) {
        meterRegistry.counter("requests_to_items_all").increment();
        model.addAttribute("items", itemService.getAllItems());
        return "items";
    }
}
