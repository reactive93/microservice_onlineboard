package account.service.dao;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "group_entity")
public class Group implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;


    @JoinColumn(name = "creator_id", table = "user_entity", insertable = false, updatable = false)
//    @Column(name = "creator_id")
    private Long creator_id;


    @JoinColumn(name = "user_id", table = "user_entity", insertable = false, updatable = false)
//    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "link")
    private String link;

    @Column(name = "is_creator")
    private Boolean is_creator;

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCreator_id() {
        return creator_id;
    }

    public void setCreator_id(Long creator_id) {
        this.creator_id = creator_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Boolean isIs_creator() {
        return is_creator;
    }

    public void setIs_creator(Boolean is_creator) {
        this.is_creator = is_creator;
    }


}
