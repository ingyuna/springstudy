<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script>
		$(document).ready(function(){
			fn_selectAll();
			fn_selectQuery();
			fn_init();
		});
		
		function fn_init() {
			$('#init_btn').click(function(){
				$('#query').val('');
				fn_selectAll();
			});
		}
		
		// 전체 목록
		function fn_selectAll() {
			$.ajax({
				url: 'selectAll.do',
				type: 'get',
				dataType: 'json',
				success: function(resultMap) {
					alert(resultMap.message);
					fn_listTable(resultMap.status, resultMap.list);
				}
			});
		}
		
		// 검색
		function fn_selectQuery() {
			$('#search_btn').click(function(){			
				$.ajax({
					url: 'selectQuery.do',
					type: 'get',
					data: $('#f').serialize(),											
					success: function(resultMap) {
						alert(resultMap.message);
						fn_listTable(resultMap.status, resultMap.list);
					}
				});
			});
		}

		// 검색 결과 테이블 
		function fn_listTable(status, list) {
			$('#list').empty();
			if (status == 200) {	
				$.each(list, function(i, board) {
					$('<tr>')
					.append( $('<td>').text(board.title) )
					.append( $('<td>').text(board.content) )
					.append( $('<td>').text(board.regdate) )
					.appendTo('#list');
				});
			} else if (status == 500) {
				$('<tr>')
				.append( $('<td colspan="3">').text('검색 결과 없음') )
				.appendTo('#list');
			}
		}		
		
	
	</script>
	
	<style>
		table {
			width: 500px;
		}
		
	
	</style>
</head>
<body>

	<form id="f" method="get">
		<select id="column" name="column">
			<option value="TITLE">제목</option>
			<option value="CONTENT">내용</option>
		</select>
		<input type="text" name="query" id="query">
		<input type="button" value="검색" id="search_btn">
		<input type="button" value="초기화" id="init_btn">
		
		<hr>
		
		<br>
		
		<table border="1">
			<thead>
				<tr>
					<td>제목</td>
					<td>내용</td>
					<td>작성일</td>				
				</tr>
			</thead>
			<tbody id="list"></tbody>
		</table>
	</form>


</body>
</html>