//package Online.Shopping.Platform.Controller;
//
//import Online.Shopping.Platform.Entity.Smartwatch;
//import Online.Shopping.Platform.Service.ProductService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.math.BigDecimal;
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/smartwatches")
//public class SmartWatchController {
//
//    @Autowired
//    private SmartWatchService smartWatchService;
//
//    // Get all smartwatches
//    @GetMapping
//    public List<SmartWatches> getAllSmartWatches() {
//        return smartWatchService.getAllSmartWatches();
//    }
//
//    // Get a specific smartwatch by ID
//    @GetMapping("/{id}")
//    public SmartWatches getSmartWatchById(@PathVariable String id) {
//        return smartWatchService.findSmartWatchById(id);
//    }
//
//    // Add a new smartwatch
//    @PostMapping
//    public SmartWatches addSmartWatch(@RequestBody SmartWatches smartWatch) {
//        return smartWatchService.addElectronicItem(smartWatch);
//    }
//
//    // Update the cost of a smartwatch (for admin use)
//    @PutMapping("/{id}/update-cost")
//    public SmartWatches updateSmartWatchCost(@PathVariable String id, @RequestParam BigDecimal cost) {
//        return smartWatchService.updateSmartWatchCost(id, cost);
//    }
//}
