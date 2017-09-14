package org.ditto.gift.model;

import com.google.common.base.Strings;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ignite.cache.query.annotations.QuerySqlField;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class Gift implements Serializable {
    private String line;
    @Id
    public String codepoint;
    public String codepointu16;
    public String groupId;
    public String subgroupId;
    public String name;
    public int sequence;
    @QuerySqlField(index = true)
    public long lastUpdated;
    public boolean active;

    private Gift(String line, String codepoint, String codepointu16, String groupId, String subgroupId, String name, int sequence, long lastUpdated, boolean active) {
        this.line = line;
        this.codepoint = codepoint;
        this.codepointu16 = codepointu16;
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
        private String codepoint;
        private String codepointu16;
        private String groupId;
        private String subgroupId;
        private String name;
        private int sequence;
        private long lastUpdated;
        private boolean active;

        Builder() {
        }

        public Gift build() {
            String missing = "";

            if (Strings.isNullOrEmpty(codepoint)) {
                missing += " codepoint";
            }

            if (Strings.isNullOrEmpty(codepointu16)) {
                missing += " codepointu16";
            }

            if (Strings.isNullOrEmpty(groupId)) {
                missing += " groupId";
            }


            if (Strings.isNullOrEmpty(subgroupId)) {
                missing += " subgroupId";
            }

            if (!missing.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + missing);
            }

            return new Gift(line,  codepoint,   codepointu16,   groupId,   subgroupId,   name,   sequence,   lastUpdated,   active) ;
        }

        public Builder setLine(String line) {
            this.line = line;
            return this;
        }

        public Builder setCodepoint(String codepoint) {
            this.codepoint = codepoint;
            return this;
        }

        public Builder setCodepointu16(String codepointu16) {
            this.codepointu16 = codepointu16;
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
