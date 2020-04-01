package com.task.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import javax.persistence.*;

@Data
@NoArgsConstructor
@Table(name = "REVIEW")
@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "PRODUCTID")
    private String productId;
    @Column(name = "USERID")
    private String userId;
    @Column(name = "PROFILENAME")
    private String profileName;
    @Column(name = "TEXT")
    @Length(max = 100000)
    private String text;

    public Review(String productId, String userId, String profileName, String text) {
        this.productId = productId;
        this.userId = userId;
        this.profileName = profileName;
        this.text = text;
    }
}
