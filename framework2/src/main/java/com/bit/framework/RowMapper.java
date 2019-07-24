package com.bit.framework;

import java.sql.ResultSet;
import java.sql.SQLException;

//필요한 부분만 오버라이드 해서 사용
public interface RowMapper {
	abstract Object mapper(ResultSet rs) throws SQLException;
}
