$(document).ready(function() {

	$("input#submit").click(function() {
		$.ajax({
			type : "POST",
			url : "saveToDoDetails",
			data : {
				'name' : $("#todoName").val(),
				'description' : $("#todoDescription").val()
			},
			success : function(msg) {
				$("#todoName").val('');
				$("#todoDescription").val('');

				$("#mainContainer").load();
				$("#createTodoList").modal('hide');
				//hide popup  
			},
			error : function() {
				alert("failure");
			}
		});
	});

	/* $('#testID2').click( function() {
	 	   $('#EditTodoList').dialog('open');
	 	});   */

	$("input#Update").click(function() {

		$.ajax({
			type : "POST",
			url : "updateToDoDetails",
			data : {
				'name' : $("#EditTodoName").val(),
				'description' : $("#EditTodoDescription").val()
			},
			success : function(msg) {
				$("#EditTodoName").val('');
				$("#EditTodoDescription").val('');

				//$("#mainContainer").load();
				$("#EditTodoList").modal('hide');
				//hide popup  
			},
			error : function() {
				alert("failure");
			}
		});
	});

});

function displayEditForm(el) {
	var id = $(el).attr('id');
	$('#EditTodoList' + id).modal('show');
}

function updateToDo(el) {
	var id = $(el).attr('id');

	$.ajax({
		type : "POST",
		url : "updateToDoDetails",
		data : {
			'name' : $("#EditTodoName" + id).val(),
			'description' : $("#EditTodoDescription" + id).val(),
			'todoID' : id
		},
		success : function(msg) {
			$("#EditTodoName" + id).val('');
			$("#EditTodoDescription" + id).val('');

			//$("#mainContainer").load();
			$("#EditTodoList" + id).modal('hide');
			//hide popup  
		},
		error : function() {
			alert("failure");
		}
	});
}

function deleteToDo(el) {
	var id = $(el).attr('id');

	$.ajax({
		type : "POST",
		url : "deleteToDoDetails",
		data : {
			'todoID' : id
		},
		success : function(msg) {
			$("#EditTodoName" + id).val('');
			$("#EditTodoDescription" + id).val('');

			//$("#mainContainer").load();
			$("#EditTodoList" + id).modal('hide');
			//hide popup  
		},
		error : function() {
			alert("failure");
		}
	});
}
