/*
 * This file is generated by jOOQ.
 */
package fyi.sorenneedscoffee.derg_zero.db.tables;


import fyi.sorenneedscoffee.derg_zero.db.Indexes;
import fyi.sorenneedscoffee.derg_zero.db.Keys;
import fyi.sorenneedscoffee.derg_zero.db.S4D0Script;
import fyi.sorenneedscoffee.derg_zero.db.tables.records.ScriptMetaRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row2;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


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
public class ScriptMeta extends TableImpl<ScriptMetaRecord> {

    private static final long serialVersionUID = 1036703006;

    /**
     * The reference instance of <code>s4_d0_script.script_meta</code>
     */
    public static final ScriptMeta SCRIPT_META = new ScriptMeta();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ScriptMetaRecord> getRecordType() {
        return ScriptMetaRecord.class;
    }

    /**
     * The column <code>s4_d0_script.script_meta.name</code>.
     */
    public final TableField<ScriptMetaRecord, String> NAME = createField(DSL.name("name"), org.jooq.impl.SQLDataType.VARCHAR(15).nullable(false), this, "");

    /**
     * The column <code>s4_d0_script.script_meta.value</code>.
     */
    public final TableField<ScriptMetaRecord, String> VALUE = createField(DSL.name("value"), org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

    /**
     * Create a <code>s4_d0_script.script_meta</code> table reference
     */
    public ScriptMeta() {
        this(DSL.name("script_meta"), null);
    }

    /**
     * Create an aliased <code>s4_d0_script.script_meta</code> table reference
     */
    public ScriptMeta(String alias) {
        this(DSL.name(alias), SCRIPT_META);
    }

    /**
     * Create an aliased <code>s4_d0_script.script_meta</code> table reference
     */
    public ScriptMeta(Name alias) {
        this(alias, SCRIPT_META);
    }

    private ScriptMeta(Name alias, Table<ScriptMetaRecord> aliased) {
        this(alias, aliased, null);
    }

    private ScriptMeta(Name alias, Table<ScriptMetaRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> ScriptMeta(Table<O> child, ForeignKey<O, ScriptMetaRecord> key) {
        super(child, key, SCRIPT_META);
    }

    @Override
    public Schema getSchema() {
        return S4D0Script.S4_D0_SCRIPT;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.SCRIPT_META_PRIMARY);
    }

    @Override
    public UniqueKey<ScriptMetaRecord> getPrimaryKey() {
        return Keys.KEY_SCRIPT_META_PRIMARY;
    }

    @Override
    public List<UniqueKey<ScriptMetaRecord>> getKeys() {
        return Arrays.<UniqueKey<ScriptMetaRecord>>asList(Keys.KEY_SCRIPT_META_PRIMARY);
    }

    @Override
    public ScriptMeta as(String alias) {
        return new ScriptMeta(DSL.name(alias), this);
    }

    @Override
    public ScriptMeta as(Name alias) {
        return new ScriptMeta(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public ScriptMeta rename(String name) {
        return new ScriptMeta(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public ScriptMeta rename(Name name) {
        return new ScriptMeta(name, null);
    }

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row2<String, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }
}