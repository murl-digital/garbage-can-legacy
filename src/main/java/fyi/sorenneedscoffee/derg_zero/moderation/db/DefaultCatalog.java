/*
 * This file is generated by jOOQ.
 */
package fyi.sorenneedscoffee.derg_zero.moderation.db;


import org.jooq.Schema;
import org.jooq.impl.CatalogImpl;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @author SorenNeedsCoffee (github.com/sorenneedscoffee)
 */
@Generated(
        value = {
                "http://www.jooq.org",
                "jOOQ version:3.12.4"
        },
        comments = "This class is generated by jOOQ"
)
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class DefaultCatalog extends CatalogImpl {

    public static final DefaultCatalog DEFAULT_CATALOG = new DefaultCatalog();
    private static final long serialVersionUID = -933410487;
    public final S4D0Users S4_D0_USERS = fyi.sorenneedscoffee.derg_zero.moderation.db.S4D0Users.S4_D0_USERS;

    private DefaultCatalog() {
        super("");
    }

    @Override
    public final List<Schema> getSchemas() {
        List result = new ArrayList();
        result.addAll(getSchemas0());
        return result;
    }

    private final List<Schema> getSchemas0() {
        return Arrays.<Schema>asList(
                S4D0Users.S4_D0_USERS);
    }
}
