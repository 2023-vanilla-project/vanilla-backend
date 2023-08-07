package com.vanilla.vanillasns.entity;

import javax.persistence.*;

public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private PostCategory postCategory;
    @ManyToOne
    @JoinColumn(name = "user_id")
}
