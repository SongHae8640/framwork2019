package com.bit.framework;

import java.sql.ResultSet;
import java.sql.SQLException;

//필요한 부분만 오버라이드 해서 사용
public interface RowMapper<T> {
	//제너릭을 통해 타입 결정
	abstract T mapper(ResultSet rs) throws SQLException;
}
