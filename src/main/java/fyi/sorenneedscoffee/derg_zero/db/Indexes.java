/*
 * This file is generated by jOOQ.
 */
package fyi.sorenneedscoffee.derg_zero.db;


import fyi.sorenneedscoffee.derg_zero.db.tables.Script;
import fyi.sorenneedscoffee.derg_zero.db.tables.ScriptMeta;

import javax.annotation.Generated;

import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.Internal;


/**
 * A class modelling indexes of tables of the <code>s4_d0_script</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index SCRIPT_PRIMARY = Indexes0.SCRIPT_PRIMARY;
    public static final Index SCRIPT_META_PRIMARY = Indexes0.SCRIPT_META_PRIMARY;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Indexes0 {
        public static Index SCRIPT_PRIMARY = Internal.createIndex("PRIMARY", Script.SCRIPT, new OrderField[] { Script.SCRIPT.INDEX }, true);
        public static Index SCRIPT_META_PRIMARY = Internal.createIndex("PRIMARY", ScriptMeta.SCRIPT_META, new OrderField[] { ScriptMeta.SCRIPT_META.NAME }, true);
    }
}
