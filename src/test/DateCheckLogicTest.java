package test;

import java.text.SimpleDateFormat;

import org.junit.jupiter.api.Test;

class DateCheckLogicTest {

	@Test
	//	今日の日付
	String testAcquireServerDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
		return sdf.format(new java.util.Date());
	}

	@Test
	//	イベント開始日
	String testAcquireEventDate() {
		//TODO SQL作成後差し替え

		String startDay = null;



		//SQL部
		//appendでSQLを作る?
		//構造決定次第
		/*
		 *   //変数定義
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        //DB接続情報を設定する
        String path = ;  //接続パス
        String id = ;  //ログインID
        String pw = ;  //ログインパスワード

		StringBuilder sql = new StringBuilder("");
		sql.append("SELECT ");
		sql.append("");//フィールド。イベント開始日
		sql.append("FROM ");
		sql.append("");//テーブル名。
		sql.append("WHERE");
		sql.append("[イベントを判別できる何か] = ?");//条件。該当イベントを指定

		Class.forName("oracle.jdbc.driver.OracleDriver");
		//DBへのコネクションを作成する
		conn = DriverManager.getConnection(path, id, pw);
		//実行するSQL文とパラメータを指定する
		ps = conn.prepareStatement(sql);
		ps.setString(1, "");パラメータにイベント判別要素をset

		rs = ps.executeQuery();

		startDay = rs;
		*/

		//とりあえず固定値
		startDay = "180804";

		return startDay;

	}

	//	開催から何日目
	int testGetDay() {
		String today = testAcquireServerDate();

		String startDay = testAcquireEventDate();

        int day = Integer.parseInt(today) - Integer.parseInt(startDay)+1;

        return day;

	}
}
