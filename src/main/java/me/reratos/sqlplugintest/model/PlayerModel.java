package me.reratos.sqlplugintest.model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table (name = "player")
public class PlayerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private UUID uuid;

    @Column
    private String name;
//
//    public PlayerModel(long id) {
//        super(id);
//    }

    /* Getters e Setters */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
