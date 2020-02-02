/*
 * This file is generated by jOOQ.
 */
package fyi.sorenneedscoffee.derg_zero.db;


import fyi.sorenneedscoffee.derg_zero.db.tables.Script;
import fyi.sorenneedscoffee.derg_zero.db.tables.ScriptMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


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
public class S4D0Script extends SchemaImpl {

    private static final long serialVersionUID = -1940810793;

    /**
     * The reference instance of <code>s4_d0_script</code>
     */
    public static final S4D0Script S4_D0_SCRIPT = new S4D0Script();

    /**
     * The table <code>s4_d0_script.script</code>.
     */
    public final Script SCRIPT = fyi.sorenneedscoffee.derg_zero.db.tables.Script.SCRIPT;

    /**
     * The table <code>s4_d0_script.script_meta</code>.
     */
    public final ScriptMeta SCRIPT_META = fyi.sorenneedscoffee.derg_zero.db.tables.ScriptMeta.SCRIPT_META;

    /**
     * No further instances allowed
     */
    private S4D0Script() {
        super("s4_d0_script", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        List result = new ArrayList();
        result.addAll(getTables0());
        return result;
    }

    private final List<Table<?>> getTables0() {
        return Arrays.<Table<?>>asList(
            Script.SCRIPT,
            ScriptMeta.SCRIPT_META);
    }
}
