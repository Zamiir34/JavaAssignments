package assign.Ca225project;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/staffs/")

public class staffController {
    private final StaffService service;
     public staffController(StaffService service){
         this.service=service;
     }
    //requests
    //get all books
    @GetMapping("all")
    public Collection<Staff>getStaffs(){
         return service.getAllStaff();
    }

    @GetMapping("{id}")
    //get book by id
    public Staff getStaff(@PathVariable Long id){
         return service.getStaffById(id);
    }
    //save book
    @PostMapping("/save")
    public void save(@RequestBody Staff newStaff){
        service.saveStaff(newStaff);
    }
    //update
    @RequestMapping(method = RequestMethod.PUT, path = "{id}")
    public void update(@PathVariable Long id,
                      @RequestBody Staff newStaff ){
         service.update(id , newStaff);
    }
    //delete
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        service.deleteStaff(id);
    }
}
