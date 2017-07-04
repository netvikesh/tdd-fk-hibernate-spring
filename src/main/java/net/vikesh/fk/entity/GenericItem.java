package net.vikesh.fk.entity;

import javax.persistence.*;
import java.time.Instant;
import java.util.UUID;

/**
 * @author Vikesh
 *         {@link GenericItem} is the superclass for all the Entity, that must have their own Table
 */
@MappedSuperclass
public abstract class GenericItem {
    @Id
    private String uuid;

    @Column(nullable = false, name = "CREATED_AT")
    private Instant createdAt;

    @Column(name = "MODIFIED_AT")
    private Instant modifiedAt;

    @PrePersist
    private final void onCreate() {
        this.uuid = UUID.randomUUID().toString();
        this.createdAt = Instant.now();
    }

    public final String getUuid() {
        return this.uuid;
    }

    @PreUpdate
    private void onUpdate() {
        this.modifiedAt = Instant.now();
    }

    public final Instant getCreatedAt() {
        return this.createdAt;
    }

    public final Instant getModifiedAt() {
        return this.modifiedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GenericItem that = (GenericItem) o;

        return uuid.equals(that.uuid);
    }

    @Override
    public int hashCode() {
        return uuid.hashCode();
    }
}
