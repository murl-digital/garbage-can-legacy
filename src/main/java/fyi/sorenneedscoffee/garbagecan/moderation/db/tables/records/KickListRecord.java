/*
 * This file is generated by jOOQ.
 */
package fyi.sorenneedscoffee.garbagecan.moderation.db.tables.records;


import fyi.sorenneedscoffee.garbagecan.moderation.db.tables.KickList;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Row1;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class KickListRecord extends UpdatableRecordImpl<KickListRecord> implements Record1<String> {

    private static final long serialVersionUID = -1436817543;

    /**
     * Setter for <code>s4_d0_users.kick_list.id</code>.
     */
    public void setId(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>s4_d0_users.kick_list.id</code>.
     */
    public String getId() {
        return (String) get(0);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record1 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row1<String> fieldsRow() {
        return (Row1) super.fieldsRow();
    }

    @Override
    public Row1<String> valuesRow() {
        return (Row1) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return KickList.KICK_LIST.ID;
    }

    @Override
    public String component1() {
        return getId();
    }

    @Override
    public String value1() {
        return getId();
    }

    @Override
    public KickListRecord value1(String value) {
        setId(value);
        return this;
    }

    @Override
    public KickListRecord values(String value1) {
        value1(value1);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached KickListRecord
     */
    public KickListRecord() {
        super(KickList.KICK_LIST);
    }

    /**
     * Create a detached, initialised KickListRecord
     */
    public KickListRecord(String id) {
        super(KickList.KICK_LIST);

        set(0, id);
    }
}