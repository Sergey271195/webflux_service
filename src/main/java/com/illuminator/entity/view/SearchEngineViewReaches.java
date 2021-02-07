package com.illuminator.entity.view;

import com.illuminator.entity.ReachesSuperclass;
import com.illuminator.entity.source.SearchEngine;

import javax.persistence.*;

@Entity
@Table(
        name = "search_engine_views",
        uniqueConstraints = @UniqueConstraint(columnNames = {"sourceid", "date", "counterid"})
)
public class SearchEngineViewReaches extends ReachesSuperclass<SearchEngine> {

    private long id;

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "search_engine_views_reaches_seq"
    )
    @SequenceGenerator(name = "search_engine_views_reaches_seq")
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

}
