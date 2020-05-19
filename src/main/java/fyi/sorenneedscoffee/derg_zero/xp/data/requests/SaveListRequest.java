package fyi.sorenneedscoffee.derg_zero.xp.data.requests;


import fyi.sorenneedscoffee.derg_zero.xp.data.models.LevelRoleList;

/**
 * @author SorenNeedsCoffee (github.com/sorenneedscoffee)
 */
public class SaveListRequest {
    private final String groupId;
    private final LevelRoleList list;

    public SaveListRequest(String groupId, LevelRoleList list) {
        this.groupId = groupId;
        this.list = list;
    }

    public String getGroupId() {
        return groupId;
    }

    public LevelRoleList getList() {
        return list;
    }
}
