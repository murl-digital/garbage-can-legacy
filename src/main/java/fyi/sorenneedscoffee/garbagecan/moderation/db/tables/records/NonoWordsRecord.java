/*
 * This file is generated by jOOQ.
 */
package fyi.sorenneedscoffee.garbagecan.moderation.db.tables.records;


import fyi.sorenneedscoffee.garbagecan.moderation.db.tables.NonoWords;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.TableRecordImpl;


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
public class NonoWordsRecord extends TableRecordImpl<NonoWordsRecord> implements Record2<String, String> {

    private static final long serialVersionUID = -1242198751;

    /**
     * Setter for <code>s4_d0_users.nono_words.word</code>.
     */
    public void setWord(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>s4_d0_users.nono_words.word</code>.
     */
    public String getWord() {
        return (String) get(0);
    }

    /**
     * Setter for <code>s4_d0_users.nono_words.exceptions</code>.
     */
    public void setExceptions(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>s4_d0_users.nono_words.exceptions</code>.
     */
    public String getExceptions() {
        return (String) get(1);
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row2<String, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    @Override
    public Row2<String, String> valuesRow() {
        return (Row2) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return NonoWords.NONO_WORDS.WORD;
    }

    @Override
    public Field<String> field2() {
        return NonoWords.NONO_WORDS.EXCEPTIONS;
    }

    @Override
    public String component1() {
        return getWord();
    }

    @Override
    public String component2() {
        return getExceptions();
    }

    @Override
    public String value1() {
        return getWord();
    }

    @Override
    public String value2() {
        return getExceptions();
    }

    @Override
    public NonoWordsRecord value1(String value) {
        setWord(value);
        return this;
    }

    @Override
    public NonoWordsRecord value2(String value) {
        setExceptions(value);
        return this;
    }

    @Override
    public NonoWordsRecord values(String value1, String value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached NonoWordsRecord
     */
    public NonoWordsRecord() {
        super(NonoWords.NONO_WORDS);
    }

    /**
     * Create a detached, initialised NonoWordsRecord
     */
    public NonoWordsRecord(String word, String exceptions) {
        super(NonoWords.NONO_WORDS);

        set(0, word);
        set(1, exceptions);
    }
}