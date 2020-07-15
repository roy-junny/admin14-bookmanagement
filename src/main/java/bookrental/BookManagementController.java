package bookrental;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

 @RestController
 public class BookManagementController {
  @Autowired
  BookManagementRepository bookManagementRepository ;

  @PostMapping("/register")
  public BookRegistered registered(@RequestBody BookRegistered bookRegistered ){
   BookManagement bookManagement = new BookManagement();
   bookManagement.setBookName(bookRegistered.getBookName());
   bookManagement.setRentalFee(bookRegistered.getRentalFee());
   bookManagement.setRegTime(new Date());
   bookManagementRepository.save(bookManagement) ;
   return bookRegistered ;
  }
 }
