package com.ninja_squad.dbsetup.bind;

import java.sql.ParameterMetaData;
import java.sql.SQLException;
import java.sql.Types;


public class PostgresBinderConfiguration extends DefaultBinderConfiguration {

    /**
     * Adds support for Postgres type placeholders when the column metadata
     * indicates that the {@link java.sql.Types} is OTHER (e.g. a custom type or
     * jsonb) See also {@link CustomTypeBinder} for implementation details
     */
    @Override
    public Binder getBinder(ParameterMetaData metadata, int param) throws SQLException {

        if (metadata.getParameterType(param) == Types.OTHER) {
            return new CustomTypeBinder();
        }

        return super.getBinder(metadata, param);
    }

}
