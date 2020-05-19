package fyi.sorenneedscoffee.derg_zero.xp.data.requests;

/**
 * @author SorenNeedsCoffee (github.com/sorenneedscoffee)
 */
public class RetrieveListRequest {
    private final String groupId;

    public RetrieveListRequest(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupId() {
        return groupId;
    }
}
