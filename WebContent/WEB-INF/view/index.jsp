<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <!-- AJAX API のロード -->
    <script type="text/javascript" src="https://www.google.com/jsapi"></script>
 <!-- JQuery のロード -->
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<title>BorderForecast</title>
 <script type="text/javascript">

 // Visualization API と折れ線グラフ用のパッケージのロード
 google.load("visualization", "1", {packages:["corechart"]});

 // Google Visualization API ロード時のコールバック関数の設定
 google.setOnLoadCallback(drawChart);



 // グラフ作成用のコールバック関数
 function drawChart() {
	 //tableの値取得
	 var Point =  document.getElementById('border');
	 //1位trの値取得
	 var Point_1 = Point.rows[1];
	 //1位tdの値を取得し数字に変換
	 var day1Point_1 = Point_1.cells[1].innerText;
	 day1Point_1 = Number(day1Point_1);
	 var day2Point_1 = Point_1.cells[2].innerText;
	 day2Point_1 = Number(day2Point_1);
	 var day3Point_1 = Point_1.cells[3].innerText;
	 day3Point_1 = Number(day3Point_1);
	 var day4Point_1 = Point_1.cells[4].innerText;
	 day4Point_1 = Number(day4Point_1);
	 var day5Point_1 = Point_1.cells[5].innerText;
	 day5Point_1 = Number(day5Point_1);
	 var day6Point_1 = Point_1.cells[6].innerText;
	 day6Point_1 = Number(day6Point_1);
	 var day7Point_1 = Point_1.cells[7].innerText;
	 day7Point_1 = Number(day7Point_1);
	 var day8Point_1 = Point_1.cells[8].innerText;
	 day8Point_1 = Number(day8Point_1);
	 var day9Point_1 = Point_1.cells[9].innerText;
	 day9Point_1 = Number(day9Point_1);
	//100位
	 var Point_100 = Point.rows[2];
	 var day1Point_100 = Point_100.cells[1].innerText;
	 day1Point_100 = Number(day1Point_100);
	 var day2Point_100 = Point_100.cells[2].innerText;
	 day2Point_100 = Number(day2Point_100);
	 var day3Point_100 = Point_100.cells[3].innerText;
	 day3Point_100 = Number(day3Point_100);
	 var day4Point_100 = Point_100.cells[4].innerText;
	 day4Point_100 = Number(day4Point_100);
	 var day5Point_100 = Point_100.cells[5].innerText;
	 day5Point_100 = Number(day5Point_100);
	 var day6Point_100 = Point_100.cells[6].innerText;
	 day6Point_100 = Number(day6Point_100);
	 var day7Point_100 = Point_100.cells[7].innerText;
	 day7Point_100 = Number(day7Point_100);
	 var day8Point_100 = Point_100.cells[8].innerText;
	 day8Point_100 = Number(day8Point_100);
	 var day9Point_100 = Point_100.cells[9].innerText;
	 day9Point_100 = Number(day9Point_100);
	// 200位
	 var Point_200 = Point.rows[3];
	 var day1Point_200 = Point_200.cells[1].innerText;
	 day1Point_200 = Number(day1Point_200);
	 var day2Point_200 = Point_200.cells[2].innerText;
	 day2Point_200 = Number(day2Point_200);
	 var day3Point_200 = Point_200.cells[3].innerText;
	 day3Point_200 = Number(day3Point_200);
	 var day4Point_200 = Point_200.cells[4].innerText;
	 day4Point_200 = Number(day4Point_200);
	 var day5Point_200 = Point_200.cells[5].innerText;
	 day5Point_200 = Number(day5Point_200);
	 var day6Point_200 = Point_200.cells[6].innerText;
	 day6Point_200 = Number(day6Point_200);
	 var day7Point_200 = Point_200.cells[7].innerText;
	 day7Point_200 = Number(day7Point_200);
	 var day8Point_200 = Point_200.cells[8].innerText;
	 day8Point_200 = Number(day8Point_200);
	 var day9Point_200 = Point_200.cells[9].innerText;
	 day9Point_200 = Number(day9Point_200);

	//1000位
	 var Point_1000 = Point.rows[4];
	 var day1Point_1000 = Point_1000.cells[1].innerText;
	 day1Point_1000 = Number(day1Point_1000);
	 var day2Point_1000 = Point_1000.cells[2].innerText;
	 day2Point_1000 = Number(day2Point_1000);
	 var day3Point_1000 = Point_1000.cells[3].innerText;
	 day3Point_1000 = Number(day3Point_100);
	 var day4Point_1000 = Point_1000.cells[4].innerText;
	 day4Point_1000 = Number(day4Point_1000);
	 var day5Point_1000 = Point_1000.cells[5].innerText;
	 day5Point_1000 = Number(day5Point_1000);
	 var day6Point_1000 = Point_1000.cells[6].innerText;
	 day6Point_1000 = Number(day6Point_1000);
	 var day7Point_1000 = Point_1000.cells[7].innerText;
	 day7Point_1000 = Number(day7Point_1000);
	 var day8Point_1000 = Point_1000.cells[8].innerText;
	 day8Point_1000 = Number(day8Point_1000);
	 var day9Point_1000 = Point_1000.cells[9].innerText;
	 day9Point_1000 = Number(day9Point_1000);

	//1500位
	 var Point_1500 = Point.rows[5];
	 var day1Point_1500 = Point_1500.cells[1].innerText;
	 day1Point_1500 = Number(day1Point_1500);
	 var day2Point_1500 = Point_1500.cells[2].innerText;
	 day2Point_1500 = Number(day2Point_1500);
	 var day3Point_1500 = Point_1500.cells[3].innerText;
	 day3Point_1500 = Number(day3Point_1500);
	 var day4Point_1500 = Point_1500.cells[4].innerText;
	 day4Point_1500 = Number(day4Point_1500);
	 var day5Point_1500 = Point_1500.cells[5].innerText;
	 day5Point_1500 = Number(day5Point_1500);
	 var day6Point_1500 = Point_1500.cells[6].innerText;
	 day6Point_1500 = Number(day6Point_1500);
	 var day7Point_1500 = Point_1500.cells[7].innerText;
	 day7Point_1500 = Number(day7Point_1500);
	 var day8Point_1500 = Point_1500.cells[8].innerText;
	 day8Point_1500 = Number(day8Point_1500);
	 var day9Point_1500 = Point_1500.cells[9].innerText;
	 day9Point_1500 = Number(day9Point_1500);

	// 2000位
	 var Point_2000 = Point.rows[6];
	 var day1Point_2000 = Point_2000.cells[1].innerText;
	 day1Point_2000 = Number(day1Point_2000);
	 var day2Point_2000 = Point_2000.cells[2].innerText;
	 day2Point_2000 = Number(day2Point_2000);
	 var day3Point_2000 = Point_2000.cells[3].innerText;
	 day3Point_2000 = Number(day3Point_2000);
	 var day4Point_2000 = Point_2000.cells[4].innerText;
	 day4Point_2000 = Number(day4Point_2000);
	 var day5Point_2000 = Point_2000.cells[5].innerText;
	 day5Point_2000 = Number(day5Point_2000);
	 var day6Point_2000 = Point_2000.cells[6].innerText;
	 day6Point_2000 = Number(day6Point_2000);
	 var day7Point_2000 = Point_2000.cells[7].innerText;
	 day7Point_2000 = Number(day7Point_2000);
	 var day8Point_2000 = Point_2000.cells[8].innerText;
	 day8Point_2000 = Number(day8Point_2000);
	 var day9Point_2000 = Point_2000.cells[9].innerText;
	 day9Point_2000 = Number(day9Point_2000);

     // データテーブルの作成
     var data = google.visualization.arrayToDataTable([
       ['日', '1位'    ,'100位'      ,'200位'      ,'1000位'       ,'1500位'        ,'2000位'],
       [1,  day1Point_1,day1Point_100,day1Point_200,day1Point_1000,day1Point_1500,day1Point_2000,],
       [2,  day2Point_1,day2Point_100,day2Point_200,day2Point_1000,day2Point_1500,day2Point_2000,],
       [3,  day3Point_1,day3Point_100,day3Point_200,day3Point_1000,day3Point_1500,day3Point_2000,],
       [4,  day4Point_1,day4Point_100,day4Point_200,day4Point_1000,day4Point_1500,day4Point_2000,],
       [5,  day5Point_1,day5Point_100,day5Point_200,day5Point_1000,day5Point_1500,day5Point_2000,],
       [6,  day6Point_1,day6Point_100,day6Point_200,day6Point_1000,day6Point_1500,day6Point_2000,],
       [7,  day7Point_1,day7Point_100,day7Point_200,day7Point_1000,day7Point_1500,day7Point_2000,],
       [8,  day8Point_1,day8Point_100,day8Point_200,day8Point_1000,day8Point_1500,day8Point_2000,],
       [9,  day9Point_1,day9Point_100,day9Point_200,day9Point_1000,day9Point_1500,day9Point_2000,],
     ]);

     // グラフのオプションを設定
     var options = {
       title: '予想'
     };

     // LineChart のオブジェクトの作成
     var chart = new google.visualization.LineChart(document.getElementById('chart_div'));
     // データテーブルとオプションを渡して、グラフを描画
     chart.draw(data, options);
   }

 </script>
</head>

<body>

 <%--${key}で値の取得ができる --%>
イベント名： ${eventName}

<table id = "border" style="table-layout: fixed;">
<tr>
<th>順位</th>
<th>1日目</th>
<th>2日目</th>
<th>3日目</th>
<th>4日目</th>
<th>5日目</th>
<th>6日目</th>
<th>7日目</th>
<th>8日目</th>
<th>9日目</th>
</tr>
<tr>
<td>1位</td>
<td>${day1Point_1}</td>
<td>${day2Point_1}</td>
<td>${day3Point_1}</td>
<td>${day4Point_1}</td>
<td>${day5Point_1}</td>
<td>${day6Point_1}</td>
<td>${day7Point_1}</td>
<td>${day8Point_1}</td>
<td>${day9Point_1}</td>
</tr>
<tr>
<td>100位</td>
<td>${day1Point_100}</td>
<td>${day2Point_100}</td>
<td>${day3Point_100}</td>
<td>${day4Point_100}</td>
<td>${day5Point_100}</td>
<td>${day6Point_100}</td>
<td>${day7Point_100}</td>
<td>${day8Point_100}</td>
<td>${day9Point_100}</td>
</tr>
<tr>
<td>200位</td>
<td>${day1Point_200}</td>
<td>${day2Point_200}</td>
<td>${day3Point_200}</td>
<td>${day4Point_200}</td>
<td>${day5Point_200}</td>
<td>${day6Point_200}</td>
<td>${day7Point_200}</td>
<td>${day8Point_200}</td>
<td>${day9Point_200}</td>
</tr>
<tr>
<td>1000位</td>
<td>${day1Point_1000}</td>
<td>${day2Point_1000}</td>
<td>${day3Point_1000}</td>
<td>${day4Point_1000}</td>
<td>${day5Point_1000}</td>
<td>${day6Point_1000}</td>
<td>${day7Point_1000}</td>
<td>${day8Point_1000}</td>
<td>${day9Point_1000}</td>
</tr>
<tr>
<td>1500位</td>
<td>${day1Point_1500}</td>
<td>${day2Point_1500}</td>
<td>${day3Point_1500}</td>
<td>${day4Point_1500}</td>
<td>${day5Point_1500}</td>
<td>${day6Point_1500}</td>
<td>${day7Point_1500}</td>
<td>${day8Point_1500}</td>
<td>${day9Point_1500}</td>
</tr>
<tr>
<td>2000位</td>
<td>${day1Point_2000}</td>
<td>${day2Point_2000}</td>
<td>${day3Point_2000}</td>
<td>${day4Point_2000}</td>
<td>${day5Point_2000}</td>
<td>${day6Point_2000}</td>
<td>${day7Point_2000}</td>
<td>${day8Point_2000}</td>
<td>${day9Point_2000}</td>
</tr>
</table>

<div id="chart_div" style="width: 80%; height: 1000px;"></div>


</body>
</html>