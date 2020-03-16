package ImageHoster.model;

import javax.persistence.*;
import java.time.LocalDate;

//@Entity annotation specifies that the corresponding class is a JPA entity
@Entity
//@Table annotation provides more options to customize the mapping.
//Here the name of the table to be created in the database is explicitly mentioned as 'comment'. Hence the table named 'comment' will be created in the database with all the required columns
@Table(name = "comment")
public class Comment {
    //@Id annotation specifies that the corresponding attribute is a primary key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Column annotation specifies that the attribute will be mapped to the column in the database.
    //Here the column name is explicitly mentioned as 'id'
    @Column(name = "id")
    private Integer id;
    //Here the column name is explicitly mentioned as 'text'
    @Column(name = "text")
    private String text;
    //Here the column name is explicitly mentioned as 'createdDate'
    @Column(name = "createdDate")
    private LocalDate createdDate;
    //@ManyToOne annotation is used to specify Many to One mapping between the Comment and User entities.
    // Fetch type is EAGER since we want to load all the user details corresponding to a particular comment when the other details of post are loaded.
    // The @JoinColumn annotation is used to specify that the ‘user_id’ column create in the ‘comment’ table in the database references the ‘id’ column in the ‘users’ table.
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
