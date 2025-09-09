package com.github.sansarch.freelance_adm_platform.bid.domain.entity;

import java.util.UUID;

public final class BidId {
    private final UUID id;

    private BidId(UUID id) {
        this.id = id;
    }

    public static BidId from(UUID id) {
        return new BidId(id);
    }

    public static BidId generate() {
        return new BidId(UUID.randomUUID());
    }

    public UUID getValue() {
        return id;
    }
}
