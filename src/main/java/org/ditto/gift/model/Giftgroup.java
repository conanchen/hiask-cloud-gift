package org.ditto.gift.model;

import com.google.common.base.Strings;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ignite.cache.query.annotations.QuerySqlField;
import org.springframework.data.annotation.Id;

/**
 * Created by admin on 2017/6/2.
 */
@NoArgsConstructor
@Data
public class Giftgroup {
    private String line;
    @Id
    public String id;
    public String groupId;
    public String subgroupId;
    public String name;
    public int sequence;
    @QuerySqlField(index = true)
    public long lastUpdated;
    public boolean active;


    private Giftgroup(String line, String id, String groupId, String subgroupId, String name, int sequence, long lastUpdated, boolean active) {
        this.line = line;
        this.id = id;
        this.groupId = groupId;
        this.subgroupId = subgroupId;
        this.name = name;
        this.sequence = sequence;
        this.lastUpdated = lastUpdated;
        this.active = active;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String line;
        private String groupId;
        private String subgroupId;
        private String name;
        private int sequence;
        private long lastUpdated;
        private boolean active;

        Builder() {
        }

        public Giftgroup build() {
            String missing = "";

            if (Strings.isNullOrEmpty(groupId)) {
                missing += " groupId";
            }


            if (Strings.isNullOrEmpty(name)) {
                missing += " name";
            }


            if (!missing.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + missing);
            }

            String id = groupId + (Strings.isNullOrEmpty(subgroupId) ? "" : subgroupId);
            return new Giftgroup(line,id, groupId, subgroupId, name, sequence, lastUpdated,active);
        }

        public Builder setLine(String line) {
            this.line = line;
            return this;
        }

        public Builder setGroupId(String groupId) {
            this.groupId = groupId;
            return this;
        }

        public Builder setSubgroupId(String subgroupId) {
            this.subgroupId = subgroupId;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setSequence(int sequence) {
            this.sequence = sequence;
            return this;
        }

        public Builder setLastUpdated(long lastUpdated) {
            this.lastUpdated = lastUpdated;
            return this;
        }

        public Builder setActive(boolean active) {
            this.active = active;
            return this;
        }
    }
}
