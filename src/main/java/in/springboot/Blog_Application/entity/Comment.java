package in.springboot.Blog_Application.entity;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Table(name = "COMMENT_TBL")
@Getter
@Setter
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    @Lob
    private String content;
    @CreationTimestamp
    private LocalDate createdOn;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;
}
