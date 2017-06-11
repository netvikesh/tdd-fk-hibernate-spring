package net.vikesh.fk.entity;

import com.google.common.base.Strings;

import javax.persistence.*;
import java.time.Instant;
import java.util.UUID;

/**
 * Created by vikes on 11-06-2017.
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
    protected void onCreate() {
        if (Strings.isNullOrEmpty(uuid)) {
            this.uuid = UUID.randomUUID().toString();
        }
        this.createdAt = Instant.now();
    }

    public String getUuid(){
        return this.uuid;
    }

    @PreUpdate
    protected void onUpdate() {
        this.modifiedAt = Instant.now();
    }

    public Instant getCreatedAt() {
        return this.createdAt;
    }

    public Instant getModifiedAt() {
        return this.modifiedAt;
    }
}
