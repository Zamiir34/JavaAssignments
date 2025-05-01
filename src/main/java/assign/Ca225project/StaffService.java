package assign.Ca225project;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class StaffService {
    private final Map<Long, Staff> StaffMap=new HashMap<>();
    private AtomicLong AutoId=new AtomicLong();

    //operators
    // get all Staff
    public Collection<Staff>getAllStaff(){
        return StaffMap.values();
    }
    // get staff by id
    public Staff getStaffById(Long id){
        return StaffMap.get(id);
    }
    //save Staff
    public void saveStaff(Staff newStaff){
        //check if the id is null
        Long staffId =newStaff.getId() != null
                ?newStaff.getId()
                :AutoId.incrementAndGet();
        newStaff.setId(staffId);
        StaffMap.put(staffId,newStaff);

    }
    // update
    public void update(Long id,Staff newStaff){
        if (!StaffMap.containsKey(id)){
            Staff oldStaff =getStaffById(id);
            oldStaff.setName(newStaff.getName());
            oldStaff.setRole(newStaff.getRole());
            StaffMap.put(id , oldStaff);
        }
    }
    //delete
    public void deleteStaff(Long id){
        StaffMap.remove(id);
    }
}
