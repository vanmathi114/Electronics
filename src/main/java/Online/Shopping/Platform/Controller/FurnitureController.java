//package Online.Shopping.Platform.Controller;
//
//import Online.Shopping.Platform.Entity.Furniture;
//import Online.Shopping.Platform.Service.FurnitureService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.math.BigDecimal;
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/furniture")
//public class FurnitureController {
//
//    @Autowired
//    private FurnitureService furnitureService;
//
//    // Get all furniture items
//    @GetMapping
//    public List<Furniture> getAllFurniture() {
//        return furnitureService.getAllFurniture();
//    }
//
//    // Get a specific furniture item by ID
//    @GetMapping("/{id}")
//    public Furniture getFurnitureById(@PathVariable String id) {
//        return furnitureService.findFurnitureById(id);
//    }
//
//    // Add new furniture
//    @PostMapping
//    public Furniture addFurniture(@RequestBody Furniture furniture) {
//        return furnitureService.addFurniture(furniture);
//    }
//
//    // Update the cost of furniture (for admin use)
//    @PutMapping("/{id}/update-cost")
//    public Furniture updateFurnitureCost(@PathVariable String id, @RequestParam BigDecimal cost) {
//        return furnitureService.updateFurnitureCost(id, cost);
//    }
//}
