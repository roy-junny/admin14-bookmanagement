package bookrental;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="BookManagement_table")
public class BookManagement {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String bookName;
    private Date regTime;
    private Integer rentalFee;

    public BookManagement() {
        Date date = new Date();
        this.regTime = new Timestamp(date.getTime());
        System.out.println("regTime!! : " + this.regTime);
    }

    @PostPersist
    public void onPostPersist(){
        BookRegistered bookRegistered = new BookRegistered();
        BeanUtils.copyProperties(this, bookRegistered);
        bookRegistered.publishAfterCommit();


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }
    public Integer getRentalFee() {
        return rentalFee;
    }

    public void setRentalFee(Integer rentalFee) {
        this.rentalFee = rentalFee;
    }




}
