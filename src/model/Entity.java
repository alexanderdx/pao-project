package model;

import java.util.Date;
import java.util.UUID;

public abstract class Entity {
    private final UUID uuid;
    private final Date creationDate;

    public Entity() {
        uuid = UUID.randomUUID();
        creationDate = new Date();
    }

    public Entity(UUID id) {
        uuid = id;
        creationDate = new Date();
    }

    public UUID getUUID() {
        return uuid;
    }

    public Date getCreationDate() {
        return creationDate;
    }
}
