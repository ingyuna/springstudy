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
			fn_search();
			fn_init();
			fn_search_all();
			fn_auto_complete();
		});
		
		function fn_search() {
			$('#search_btn').click(function(){
				if ($('column').val() == '') {
					alert('검색 카테고리를 선택하세요.')	// 검색창이 비어있는데 검색할 때. 
					$('column').focus();
					return false;
				}
				$('#f').attr('action', 'search.do');
				$('#f').submit();
			});
		}
		
		function fn_init() {
			$('#column').val('');	// 아래 <option value=""> 선택하라는말.
			$('#query').val('');
		}
		
		function fn_search_all() {
			$('#search_all_btn').click(function(){
				location.href = 'searchAll.do';
			});
		}
		
		function fn_auto_complete() {
			$('#query').keyup(function(){
				$('#auto_complete_list').empty();	// 내부 value 태그를 모두 지워줌
				var obj = {
					column: $('#column').val(),
					query: $('#query').val() 
				};
				$.ajax({
					url: 'autoComplete.do',
					type: 'post',
					contentType: 'application/json',
					data: JSON.stringify(obj),
					dataType: 'text',
					success: function(resultMap){
						//console.log(resultMap.status);
						// console.log(resultMap.list);
						//alert(resultMap.status);
						cosole.log(resultMap);
						var result = JSON.parse(resultMap);
						if (result.status == 200) {
							$.each(result.list, function(i, employee){
								$('<option>')
								.val(employee[$('#column').find('option[value="' + obj.column + '"]').data('name')])							
								.appendTo('#auto_complete_list');
							});
						}
					},
					error: function() {
						alert('실패');
					}
				});
			});
		}
	
	</script>
</head>
<body>
	
	<!-- 검색화면 -->
	<form id="f" method="get">
		<select name="column" id="column">
			<option value="">:::::선택:::::</option>
			<option value="EMPLOYEE_ID">EMPLOYEE_ID</option>	<!-- 검색하려는 칼럼의 이름을 보내주려고 하는거기 때문에 옵션값을 대문자로(SQL 칼럼 이름 그대로) -->
			<option value="FIRST_NAME">FIRST_NAME</option>
			<option value="LAST_NAME">LAST_NAME</option>
		</select>
		<input list="auto_complete_list" type="text" name="query" id="query">
		<datalist ID="auto_complete_list">
		</datalist>
		<input type="number" name="bottom" placeholder="최소연봉">
		<input type="number" name="top" placeholder="최대연봉">
		<input type="button" value="검색" id="search_btn">	
		<input type="button" value="초기화" id="init_btn">	
		<input type="button" value="전체조회" id="search_all_btn">
	</form>
	
	
</body>
</html>